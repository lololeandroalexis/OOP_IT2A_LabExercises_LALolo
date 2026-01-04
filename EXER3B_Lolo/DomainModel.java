/**
 * Abstract base class for all domain models in the Health Center Management System.
 * Represents business entities with common properties and methods.
 */
public abstract class DomainModel {
    
    protected int id;
    protected String createdDate;
    protected String lastModifiedDate;
    
    /**
     * Initialize domain model with ID
     */
    protected DomainModel(int id) {
        this.id = id;
        this.createdDate = java.time.LocalDate.now().toString();
        this.lastModifiedDate = this.createdDate;
    }
    
    /**
     * Default constructor
     */
    protected DomainModel() {
        this.id = 0;
        this.createdDate = java.time.LocalDate.now().toString();
        this.lastModifiedDate = this.createdDate;
    }
    
    /**
     * Get the ID of this domain object
     */
    public int getId() {
        return id;
    }
    
    /**
     * Set the ID of this domain object
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Get creation date
     */
    public String getCreatedDate() {
        return createdDate;
    }
    
    /**
     * Get last modified date
     */
    public String getLastModifiedDate() {
        return lastModifiedDate;
    }
    
    /**
     * Update the last modified date to current date
     */
    public void updateLastModifiedDate() {
        this.lastModifiedDate = java.time.LocalDate.now().toString();
    }
    
    /**
     * Abstract method for retrieving a string representation
     */
    @Override
    public abstract String toString();
}
