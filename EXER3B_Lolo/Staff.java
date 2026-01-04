/**
 * Concrete Staff class - represents a staff/healthcare personnel user in the system.
 */
public class Staff extends User {
    
    private String profession;
    private String specialization;
    private String licenseNumber;
    private String department;
    private String workSchedule;
    
    /**
     * Initialize staff with all information
     */
    public Staff(int id, String email, String password, String firstName, 
                 String lastName, String phoneNumber, String profession, 
                 String specialization, String licenseNumber, String department) {
        super(id, email, password, firstName, lastName, "STAFF", phoneNumber);
        this.profession = profession;
        this.specialization = specialization;
        this.licenseNumber = licenseNumber;
        this.department = department;
        this.workSchedule = "";
    }
    
    /**
     * Default constructor
     */
    public Staff() {
        super();
        this.role = "STAFF";
        this.profession = "";
        this.specialization = "";
        this.licenseNumber = "";
        this.department = "";
        this.workSchedule = "";
    }
    
    // Getters and Setters
    public String getProfession() {
        return profession;
    }
    
    public void setProfession(String profession) {
        this.profession = profession;
    }
    
    public String getSpecialization() {
        return specialization;
    }
    
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    
    public String getLicenseNumber() {
        return licenseNumber;
    }
    
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public String getWorkSchedule() {
        return workSchedule;
    }
    
    public void setWorkSchedule(String workSchedule) {
        this.workSchedule = workSchedule;
    }
    
    @Override
    public boolean authenticate(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }
    
    @Override
    public void displayDashboard() {
        System.out.println("Displaying Staff Dashboard for: " + getFullName());
    }
    
    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", profession='" + profession + '\'' +
                ", specialization='" + specialization + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", department='" + department + '\'' +
                ", workSchedule='" + workSchedule + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
