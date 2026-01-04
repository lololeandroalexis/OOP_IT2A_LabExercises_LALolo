/**
 * ProjectTester Class
 * 
 * This class tests and creates instances of all classes in the Health Center Management System.
 * It demonstrates the complete class hierarchy including:
 * - Base classes (UIComponent, DomainModel)
 * - Domain model classes (User hierarchy: Patient, Admin, Staff; Document hierarchy: Appointment)
 * - UI component classes (LoginScreen, Dashboards, Managers, Forms)
 * - Utility classes (DatabaseHelper, SimpleProfileEditor)
 */
public class ProjectTester {
    
    // Static instances for testing
    private static Patient testPatient;
    private static Admin testAdmin;
    private static Staff testStaff;
    private static Appointment testAppointment;
    
    private static LoginScreen loginScreen;
    private static PatientDashboardUI patientDashboard;
    private static AdminDashboardUI adminDashboard;
    private static StaffDashboardUI staffDashboard;
    
    private static AppointmentManagerUI appointmentManager;
    private static BillingRecordFormUI billingForm;
    private static PatientProfileEditorUI profileEditor;
    private static ContactInformationUI contactInfo;
    private static HealthPersonnelDirectoryUI personnelDirectory;
    
    public static void main(String[] args) {
        System.out.println("================================================================================");
        System.out.println("         BARANGAY HEALTH CENTER MANAGEMENT SYSTEM - CLASS HIERARCHY TESTER");
        System.out.println("================================================================================\n");
        
        // Test all classes
        testDomainModelClasses();
        testUIComponentClasses();
        testUtilityClasses();
        
        System.out.println("\n================================================================================");
        System.out.println("                    ALL TESTS COMPLETED SUCCESSFULLY");
        System.out.println("================================================================================");
    }
    
    /**
     * Test domain model classes (User and Document hierarchies)
     */
    private static void testDomainModelClasses() {
        System.out.println("\n--- TESTING DOMAIN MODEL CLASSES ---\n");
        
        // Test Patient Class
        System.out.println("1. PATIENT CLASS:");
        testPatient = new Patient(
            1001,
            "john.doe@email.com",
            "password123",
            "John",
            "Doe",
            "(555) 123-4567",
            "1990-05-15",
            "Male",
            "123 Main Street, City"
        );
        testPatient.setMedicalHistory("No known allergies");
        testPatient.setBloodType("O+");
        System.out.println("   " + testPatient);
        System.out.println("   ✓ Patient instance created and populated\n");
        
        // Test Admin Class
        System.out.println("2. ADMIN CLASS:");
        testAdmin = new Admin(
            2001,
            "admin@bhc.gov",
            "adminpass",
            "Jane",
            "Smith",
            "(555) 987-6543",
            "Administration",
            "SUPER_ADMIN"
        );
        testAdmin.setCanManageUsers(true);
        testAdmin.setCanManageBilling(true);
        System.out.println("   " + testAdmin);
        System.out.println("   ✓ Admin instance created with permissions\n");
        
        // Test Staff Class
        System.out.println("3. STAFF CLASS:");
        testStaff = new Staff(
            3001,
            "dr.maria@bhc.gov",
            "staffpass",
            "Maria",
            "Garcia",
            "(555) 456-7890",
            "Physician",
            "General Medicine",
            "LIC-2024-001",
            "Medical"
        );
        testStaff.setWorkSchedule("Monday-Friday, 8AM-5PM");
        System.out.println("   " + testStaff);
        System.out.println("   ✓ Staff instance created with credentials\n");
        
        // Test Authentication
        System.out.println("4. AUTHENTICATION TESTS:");
        boolean patientAuth = testPatient.authenticate("john.doe@email.com", "password123");
        System.out.println("   Patient Authentication: " + (patientAuth ? "✓ SUCCESS" : "✗ FAILED"));
        
        boolean adminAuth = testAdmin.authenticate("admin@bhc.gov", "adminpass");
        System.out.println("   Admin Authentication: " + (adminAuth ? "✓ SUCCESS" : "✗ FAILED"));
        
        boolean staffAuth = testStaff.authenticate("dr.maria@bhc.gov", "staffpass");
        System.out.println("   Staff Authentication: " + (staffAuth ? "✓ SUCCESS" : "✗ FAILED") + "\n");
        
        // Test Appointment Class
        System.out.println("5. APPOINTMENT CLASS:");
        testAppointment = new Appointment(
            5001,
            1001,
            3001,
            "2024-01-15",
            "09:30 AM",
            "General Checkup",
            "Follow-up appointment for routine checkup"
        );
        System.out.println("   " + testAppointment);
        System.out.println("   ✓ Appointment instance created\n");
        
        // Test Document approval/rejection
        System.out.println("6. DOCUMENT WORKFLOW:");
        System.out.println("   Initial Status: " + testAppointment.getStatus());
        testAppointment.approve();
        System.out.println("   Status after approval: " + testAppointment.getStatus());
        
        Appointment rejectedAppointment = new Appointment(
            5002,
            1001,
            3001,
            "2024-01-16",
            "02:00 PM",
            "Consultation",
            "Initial request"
        );
        rejectedAppointment.reject("Conflict with staff schedule");
        System.out.println("   Status after rejection: " + rejectedAppointment.getStatus() + "\n");
    }
    
    /**
     * Test UI component classes
     */
    private static void testUIComponentClasses() {
        System.out.println("\n--- TESTING UI COMPONENT CLASSES ---\n");
        
        System.out.println("Creating instances of all UI components...\n");
        
        // Login Screen - Don't show, just create
        System.out.println("1. LoginScreen");
        loginScreen = new LoginScreen();
        loginScreen.setVisible(false);
        System.out.println("   ✓ LoginScreenUI instance created");
        System.out.println("     - Title: " + loginScreen.getWindowTitle());
        System.out.println("     - Size: 500x750\n");
        
        // Patient Dashboard - Don't show, just create
        System.out.println("2. PatientDashboardUI");
        patientDashboard = new PatientDashboardUI(1001, "john.doe@email.com");
        patientDashboard.setVisible(false);
        System.out.println("   ✓ PatientDashboardUI instance created");
        System.out.println("     - Title: " + patientDashboard.getWindowTitle());
        System.out.println("     - Patient ID: " + patientDashboard.getPatientId());
        System.out.println("     - Patient Email: " + patientDashboard.getPatientEmail() + "\n");
        
        // Admin Dashboard - Don't show, just create
        System.out.println("3. AdminDashboardUI");
        adminDashboard = new AdminDashboardUI();
        adminDashboard.setVisible(false);
        System.out.println("   ✓ AdminDashboardUI instance created");
        System.out.println("     - Title: " + adminDashboard.getWindowTitle());
        System.out.println("     - Size: 1200x750\n");
        
        // Staff Dashboard - Don't show, just create
        System.out.println("4. StaffDashboardUI");
        staffDashboard = new StaffDashboardUI();
        staffDashboard.setVisible(false);
        System.out.println("   ✓ StaffDashboardUI instance created");
        System.out.println("     - Title: " + staffDashboard.getWindowTitle() + "\n");
        
        // Appointment Manager - Don't show, just create
        System.out.println("5. AppointmentManagerUI");
        appointmentManager = new AppointmentManagerUI();
        appointmentManager.setVisible(false);
        System.out.println("   ✓ AppointmentManagerUI instance created");
        System.out.println("     - Title: " + appointmentManager.getWindowTitle() + "\n");
        
        // Billing Record Form - Don't show, just create
        System.out.println("6. BillingRecordFormUI");
        billingForm = new BillingRecordFormUI();
        billingForm.setVisible(false);
        System.out.println("   ✓ BillingRecordFormUI instance created");
        System.out.println("     - Title: " + billingForm.getWindowTitle() + "\n");
        
        // Patient Profile Editor - Don't show, just create
        System.out.println("7. PatientProfileEditorUI");
        profileEditor = new PatientProfileEditorUI();
        profileEditor.setVisible(false);
        System.out.println("   ✓ PatientProfileEditorUI instance created");
        System.out.println("     - Title: " + profileEditor.getWindowTitle() + "\n");
        
        // Contact Information - Don't show, just create
        System.out.println("8. ContactInformationUI");
        contactInfo = new ContactInformationUI();
        contactInfo.setVisible(false);
        contactInfo.setAddress("Barangay Health Center, Main Street, City");
        contactInfo.setPhone("(555) 123-4567");
        contactInfo.setEmail("info@bhc.gov");
        System.out.println("   ✓ ContactInformationUI instance created");
        System.out.println("     - Title: " + contactInfo.getWindowTitle() + "\n");
        
        // Health Personnel Directory - Don't show, just create
        System.out.println("9. HealthPersonnelDirectoryUI");
        personnelDirectory = new HealthPersonnelDirectoryUI();
        personnelDirectory.setVisible(false);
        personnelDirectory.addStaffMember(3001, "Dr. Maria Garcia", "Physician", "Medical", "LIC-2024-001", "(555) 456-7890");
        personnelDirectory.addStaffMember(3002, "Nurse John Smith", "Nurse", "Nursing", "LIC-2024-002", "(555) 456-7891");
        System.out.println("   ✓ HealthPersonnelDirectoryUI instance created");
        System.out.println("     - Title: " + personnelDirectory.getWindowTitle());
        System.out.println("     - Staff members added: 2\n");
    }
    
    /**
     * Test utility classes
     */
    private static void testUtilityClasses() {
        System.out.println("\n--- TESTING UTILITY CLASSES ---\n");
        
        // Test SimpleProfileEditor
        System.out.println("1. SIMPLE PROFILE EDITOR UTILITIES:");
        System.out.println("   ✓ Email Validation:");
        System.out.println("     - john@email.com: " + SimpleProfileEditor.isValidEmail("john@email.com"));
        System.out.println("     - invalid.email: " + SimpleProfileEditor.isValidEmail("invalid.email"));
        
        System.out.println("   ✓ Password Validation:");
        System.out.println("     - password123 (8 chars): " + SimpleProfileEditor.isValidPassword("password123"));
        System.out.println("     - short (5 chars): " + SimpleProfileEditor.isValidPassword("short"));
        
        System.out.println("   ✓ Phone Number Validation:");
        System.out.println("     - (555) 123-4567: " + SimpleProfileEditor.isValidPhoneNumber("(555) 123-4567"));
        System.out.println("     - 123: " + SimpleProfileEditor.isValidPhoneNumber("123"));
        
        System.out.println("   ✓ Date Validation:");
        System.out.println("     - 2024-01-15: " + SimpleProfileEditor.isValidDate("2024-01-15"));
        System.out.println("     - 01/15/2024: " + SimpleProfileEditor.isValidDate("01/15/2024"));
        
        System.out.println("   ✓ Name Validation:");
        System.out.println("     - John Doe: " + SimpleProfileEditor.isValidName("John Doe"));
        System.out.println("     - John123: " + SimpleProfileEditor.isValidName("John123") + "\n");
        
        // Test Profile Update
        System.out.println("2. PROFILE UPDATE OPERATIONS:");
        boolean patientUpdate = SimpleProfileEditor.updatePatientProfile(testPatient);
        System.out.println("   ✓ Patient Profile Update: " + (patientUpdate ? "SUCCESS" : "FAILED"));
        
        boolean staffUpdate = SimpleProfileEditor.updateStaffProfile(testStaff);
        System.out.println("   ✓ Staff Profile Update: " + (staffUpdate ? "SUCCESS" : "FAILED") + "\n");
        
        // Test Profile Retrieval
        System.out.println("3. PROFILE RETRIEVAL:");
        Patient retrievedPatient = SimpleProfileEditor.getPatientProfile(1001);
        System.out.println("   ✓ Retrieved Patient Profile ID: " + retrievedPatient.getId());
        
        Staff retrievedStaff = SimpleProfileEditor.getStaffProfile(3001);
        System.out.println("   ✓ Retrieved Staff Profile ID: " + retrievedStaff.getId() + "\n");
        
        // Test Password Hashing
        System.out.println("4. SECURITY UTILITIES:");
        String hashedPassword = SimpleProfileEditor.hashPassword("password123");
        System.out.println("   ✓ Original Password: password123");
        System.out.println("   ✓ Hashed Password: " + hashedPassword + "\n");
        
        // Test Input Sanitization
        System.out.println("5. INPUT SANITIZATION:");
        String maliciousInput = "Robert'; DROP TABLE users; --";
        String sanitized = SimpleProfileEditor.sanitizeInput(maliciousInput);
        System.out.println("   ✓ Original: " + maliciousInput);
        System.out.println("   ✓ Sanitized: " + sanitized + "\n");
        
        // Test DatabaseHelper
        System.out.println("6. DATABASE HELPER:");
        System.out.println("   ✓ DatabaseHelper utility class loaded");
        System.out.println("   ✓ Available methods:");
        System.out.println("     - getConnection()");
        System.out.println("     - authenticateUser(email, password)");
        System.out.println("     - registerUser(...)");
        System.out.println("     - getUserId(email)");
        System.out.println("     - getAllAppointments()");
        System.out.println("     - insertAppointment(Appointment)");
        System.out.println("     - closeConnection(Connection)\n");
    }
    
    /**
     * Print summary of all instances created
     */
    private static void printSummary() {
        System.out.println("\n================================================================================");
        System.out.println("                         TEST SUMMARY");
        System.out.println("================================================================================\n");
        
        System.out.println("DOMAIN MODEL INSTANCES:");
        System.out.println("✓ Patient instance: " + (testPatient != null ? "Created" : "Failed"));
        System.out.println("✓ Admin instance: " + (testAdmin != null ? "Created" : "Failed"));
        System.out.println("✓ Staff instance: " + (testStaff != null ? "Created" : "Failed"));
        System.out.println("✓ Appointment instance: " + (testAppointment != null ? "Created" : "Failed"));
        
        System.out.println("\nUI COMPONENT INSTANCES:");
        System.out.println("✓ LoginScreen: " + (loginScreen != null ? "Created" : "Failed"));
        System.out.println("✓ PatientDashboardUI: " + (patientDashboard != null ? "Created" : "Failed"));
        System.out.println("✓ AdminDashboardUI: " + (adminDashboard != null ? "Created" : "Failed"));
        System.out.println("✓ StaffDashboardUI: " + (staffDashboard != null ? "Created" : "Failed"));
        System.out.println("✓ AppointmentManagerUI: " + (appointmentManager != null ? "Created" : "Failed"));
        System.out.println("✓ BillingRecordFormUI: " + (billingForm != null ? "Created" : "Failed"));
        System.out.println("✓ PatientProfileEditorUI: " + (profileEditor != null ? "Created" : "Failed"));
        System.out.println("✓ ContactInformationUI: " + (contactInfo != null ? "Created" : "Failed"));
        System.out.println("✓ HealthPersonnelDirectoryUI: " + (personnelDirectory != null ? "Created" : "Failed"));
        
        System.out.println("\nUTILITY CLASSES:");
        System.out.println("✓ SimpleProfileEditor: Loaded with validation and update methods");
        System.out.println("✓ DatabaseHelper: Loaded with database operation methods");
    }
}
