/**
 * Utility class for database operations in the Health Center Management System.
 * Handles database connections and CRUD operations.
 */
public class DatabaseHelper {
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/barangay_health_center";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";
    
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found");
            e.printStackTrace();
        }
    }
    
    /**
     * Get database connection
     */
    public static java.sql.Connection getConnection() throws java.sql.SQLException {
        return java.sql.DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
    
    /**
     * Authenticate user by email and password
     */
    public static String authenticateUser(String email, String password) {
        String query = "SELECT role FROM users WHERE email = ? AND password = ?";
        
        try (java.sql.Connection conn = getConnection();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            java.sql.ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return rs.getString("role");
            }
            
        } catch (java.sql.SQLException e) {
            System.err.println("Error during authentication: " + e.getMessage());
            e.printStackTrace();
        }
        
        return null;
    }
    
    /**
     * Register a new user
     */
    public static boolean registerUser(String email, String password, String firstName, 
                                      String lastName, String role) {
        String query = "INSERT INTO users (email, password, first_name, last_name, role) VALUES (?, ?, ?, ?, ?)";
        
        try (java.sql.Connection conn = getConnection();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            pstmt.setString(3, firstName);
            pstmt.setString(4, lastName);
            pstmt.setString(5, role);
            
            pstmt.executeUpdate();
            return true;
            
        } catch (java.sql.SQLException e) {
            System.err.println("Error during registration: " + e.getMessage());
            e.printStackTrace();
        }
        
        return false;
    }
    
    /**
     * Get user ID from email
     */
    public static int getUserId(String email) {
        String query = "SELECT id FROM users WHERE email = ?";
        
        try (java.sql.Connection conn = getConnection();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, email);
            java.sql.ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("id");
            }
            
        } catch (java.sql.SQLException e) {
            System.err.println("Error retrieving user ID: " + e.getMessage());
            e.printStackTrace();
        }
        
        return -1;
    }
    
    /**
     * Get all appointments
     */
    public static java.util.List<Appointment> getAllAppointments() {
        java.util.List<Appointment> appointments = new java.util.ArrayList<>();
        String query = "SELECT * FROM appointments";
        
        try (java.sql.Connection conn = getConnection();
             java.sql.Statement stmt = conn.createStatement();
             java.sql.ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                Appointment apt = new Appointment(
                    rs.getInt("id"),
                    rs.getInt("patient_id"),
                    rs.getInt("staff_id"),
                    rs.getString("appointment_date"),
                    rs.getString("appointment_time"),
                    rs.getString("service_type"),
                    rs.getString("notes")
                );
                apt.setStatus(rs.getString("status"));
                appointments.add(apt);
            }
            
        } catch (java.sql.SQLException e) {
            System.err.println("Error retrieving appointments: " + e.getMessage());
            e.printStackTrace();
        }
        
        return appointments;
    }
    
    /**
     * Insert new appointment
     */
    public static boolean insertAppointment(Appointment appointment) {
        String query = "INSERT INTO appointments (patient_id, staff_id, appointment_date, " +
                      "appointment_time, service_type, status, notes) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (java.sql.Connection conn = getConnection();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, appointment.getPatientId());
            pstmt.setInt(2, appointment.getStaffId());
            pstmt.setString(3, appointment.getAppointmentDate());
            pstmt.setString(4, appointment.getAppointmentTime());
            pstmt.setString(5, appointment.getServiceType());
            pstmt.setString(6, appointment.getStatus());
            pstmt.setString(7, appointment.getNotes());
            
            pstmt.executeUpdate();
            return true;
            
        } catch (java.sql.SQLException e) {
            System.err.println("Error inserting appointment: " + e.getMessage());
            e.printStackTrace();
        }
        
        return false;
    }
    
    /**
     * Close database connection
     */
    public static void closeConnection(java.sql.Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (java.sql.SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}
