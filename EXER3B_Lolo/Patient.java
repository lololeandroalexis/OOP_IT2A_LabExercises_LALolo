/**
 * Concrete Patient class - represents a patient user in the system.
 */
public class Patient extends User {
    
    private String dateOfBirth;
    private String gender;
    private String address;
    private String medicalHistory;
    private String bloodType;
    
    /**
     * Initialize patient with all information
     */
    public Patient(int id, String email, String password, String firstName, 
                   String lastName, String phoneNumber, String dateOfBirth, 
                   String gender, String address) {
        super(id, email, password, firstName, lastName, "PATIENT", phoneNumber);
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.medicalHistory = "";
        this.bloodType = "";
    }
    
    /**
     * Default constructor
     */
    public Patient() {
        super();
        this.role = "PATIENT";
        this.dateOfBirth = "";
        this.gender = "";
        this.address = "";
        this.medicalHistory = "";
        this.bloodType = "";
    }
    
    // Getters and Setters
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getMedicalHistory() {
        return medicalHistory;
    }
    
    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
    
    public String getBloodType() {
        return bloodType;
    }
    
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
    
    @Override
    public boolean authenticate(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }
    
    @Override
    public void displayDashboard() {
        System.out.println("Displaying Patient Dashboard for: " + getFullName());
    }
    
    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
