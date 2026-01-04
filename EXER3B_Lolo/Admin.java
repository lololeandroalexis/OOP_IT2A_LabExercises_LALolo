/**
 * Concrete Admin class - represents an administrator user in the system.
 */
public class Admin extends User {
    
    private String departmentName;
    private String accessLevel;
    private boolean canManageUsers;
    private boolean canManageBilling;
    private boolean canManageSettings;
    
    /**
     * Initialize admin with all information
     */
    public Admin(int id, String email, String password, String firstName, 
                 String lastName, String phoneNumber, String departmentName, String accessLevel) {
        super(id, email, password, firstName, lastName, "ADMIN", phoneNumber);
        this.departmentName = departmentName;
        this.accessLevel = accessLevel;
        this.canManageUsers = true;
        this.canManageBilling = true;
        this.canManageSettings = true;
    }
    
    /**
     * Default constructor
     */
    public Admin() {
        super();
        this.role = "ADMIN";
        this.departmentName = "";
        this.accessLevel = "STANDARD";
        this.canManageUsers = false;
        this.canManageBilling = false;
        this.canManageSettings = false;
    }
    
    // Getters and Setters
    public String getDepartmentName() {
        return departmentName;
    }
    
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
    public String getAccessLevel() {
        return accessLevel;
    }
    
    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }
    
    public boolean isCanManageUsers() {
        return canManageUsers;
    }
    
    public void setCanManageUsers(boolean canManageUsers) {
        this.canManageUsers = canManageUsers;
    }
    
    public boolean isCanManageBilling() {
        return canManageBilling;
    }
    
    public void setCanManageBilling(boolean canManageBilling) {
        this.canManageBilling = canManageBilling;
    }
    
    public boolean isCanManageSettings() {
        return canManageSettings;
    }
    
    public void setCanManageSettings(boolean canManageSettings) {
        this.canManageSettings = canManageSettings;
    }
    
    @Override
    public boolean authenticate(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }
    
    @Override
    public void displayDashboard() {
        System.out.println("Displaying Admin Dashboard for: " + getFullName());
    }
    
    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", accessLevel='" + accessLevel + '\'' +
                ", canManageUsers=" + canManageUsers +
                ", canManageBilling=" + canManageBilling +
                ", canManageSettings=" + canManageSettings +
                ", role='" + role + '\'' +
                '}';
    }
}
