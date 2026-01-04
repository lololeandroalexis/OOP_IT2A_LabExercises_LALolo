/**
 * Abstract User class representing all users in the system (Patient, Admin, Staff).
 */
public abstract class User extends DomainModel {
    
    protected String email;
    protected String password;
    protected String firstName;
    protected String lastName;
    protected String role;
    protected String phoneNumber;
    
    /**
     * Initialize user with basic information
     */
    protected User(int id, String email, String password, String firstName, 
                   String lastName, String role, String phoneNumber) {
        super(id);
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.phoneNumber = phoneNumber;
    }
    
    /**
     * Default constructor
     */
    protected User() {
        super();
        this.email = "";
        this.password = "";
        this.firstName = "";
        this.lastName = "";
        this.role = "";
        this.phoneNumber = "";
    }
    
    // Getters and Setters
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    /**
     * Get full name
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }
    
    /**
     * Abstract method for user-specific authentication
     */
    public abstract boolean authenticate(String email, String password);
    
    /**
     * Abstract method for user-specific dashboard display
     */
    public abstract void displayDashboard();
    
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
