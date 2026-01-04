/**
 * Abstract Document class representing all documents in the system (Appointments, Billing Records, etc.).
 */
public abstract class Document extends DomainModel {
    
    protected String documentType;
    protected String status;
    protected String description;
    protected String documentNumber;
    
    /**
     * Initialize document with basic information
     */
    protected Document(int id, String documentType, String status, String description) {
        super(id);
        this.documentType = documentType;
        this.status = status;
        this.description = description;
        this.documentNumber = generateDocumentNumber();
    }
    
    /**
     * Default constructor
     */
    protected Document() {
        super();
        this.documentType = "";
        this.status = "PENDING";
        this.description = "";
        this.documentNumber = generateDocumentNumber();
    }
    
    /**
     * Generate a unique document number
     */
    private String generateDocumentNumber() {
        return "DOC-" + System.currentTimeMillis();
    }
    
    // Getters and Setters
    public String getDocumentType() {
        return documentType;
    }
    
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getDocumentNumber() {
        return documentNumber;
    }
    
    /**
     * Abstract method for approving document
     */
    public abstract void approve();
    
    /**
     * Abstract method for rejecting document
     */
    public abstract void reject(String reason);
    
    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", documentType='" + documentType + '\'' +
                ", status='" + status + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                ", createdDate='" + createdDate + '\'' +
                '}';
    }
}
