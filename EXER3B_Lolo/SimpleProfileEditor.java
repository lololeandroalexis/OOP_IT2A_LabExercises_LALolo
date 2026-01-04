/**
 * Utility class for simple profile editing operations.
 * Provides helper methods for profile management.
 */
public class SimpleProfileEditor {
    
    /**
     * Validate email format
     */
    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
    
    /**
     * Validate password strength
     */
    public static boolean isValidPassword(String password) {
        return password != null && password.length() >= 8;
    }
    
    /**
     * Validate phone number
     */
    public static boolean isValidPhoneNumber(String phone) {
        return phone != null && phone.matches("^[0-9\\-\\+\\(\\)\\s]+$") && phone.length() >= 10;
    }
    
    /**
     * Validate date format (YYYY-MM-DD)
     */
    public static boolean isValidDate(String date) {
        return date != null && date.matches("^\\d{4}-\\d{2}-\\d{2}$");
    }
    
    /**
     * Validate name field (not empty, contains only letters and spaces)
     */
    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty() && name.matches("^[a-zA-Z\\s]+$");
    }
    
    /**
     * Sanitize input to remove potential SQL injection characters
     */
    public static String sanitizeInput(String input) {
        if (input == null) {
            return "";
        }
        return input.trim().replaceAll("[;'\"]", "");
    }
    
    /**
     * Update patient profile information
     */
    public static boolean updatePatientProfile(Patient patient) {
        // Validate input
        if (!isValidName(patient.getFirstName())) {
            System.out.println("Invalid first name");
            return false;
        }
        if (!isValidName(patient.getLastName())) {
            System.out.println("Invalid last name");
            return false;
        }
        if (!isValidEmail(patient.getEmail())) {
            System.out.println("Invalid email");
            return false;
        }
        if (!isValidPhoneNumber(patient.getPhoneNumber())) {
            System.out.println("Invalid phone number");
            return false;
        }
        
        // Update the profile in database
        try {
            // Simulate database update
            System.out.println("Patient profile updated: " + patient.getFullName());
            patient.updateLastModifiedDate();
            return true;
        } catch (Exception e) {
            System.out.println("Error updating patient profile: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Update staff profile information
     */
    public static boolean updateStaffProfile(Staff staff) {
        // Validate input
        if (!isValidName(staff.getFirstName())) {
            System.out.println("Invalid first name");
            return false;
        }
        if (!isValidName(staff.getLastName())) {
            System.out.println("Invalid last name");
            return false;
        }
        if (!isValidEmail(staff.getEmail())) {
            System.out.println("Invalid email");
            return false;
        }
        
        try {
            System.out.println("Staff profile updated: " + staff.getFullName());
            staff.updateLastModifiedDate();
            return true;
        } catch (Exception e) {
            System.out.println("Error updating staff profile: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Get patient profile details
     */
    public static Patient getPatientProfile(int patientId) {
        // Simulate fetching from database
        Patient patient = new Patient();
        patient.setId(patientId);
        System.out.println("Fetched patient profile for ID: " + patientId);
        return patient;
    }
    
    /**
     * Get staff profile details
     */
    public static Staff getStaffProfile(int staffId) {
        // Simulate fetching from database
        Staff staff = new Staff();
        staff.setId(staffId);
        System.out.println("Fetched staff profile for ID: " + staffId);
        return staff;
    }
    
    /**
     * Format date for display
     */
    public static String formatDate(String dateString) {
        if (dateString == null || dateString.isEmpty()) {
            return "N/A";
        }
        return dateString;
    }
    
    /**
     * Hash password for security
     */
    public static String hashPassword(String password) {
        // In a real application, use bcrypt or similar
        return java.util.Base64.getEncoder().encodeToString(password.getBytes());
    }
}
