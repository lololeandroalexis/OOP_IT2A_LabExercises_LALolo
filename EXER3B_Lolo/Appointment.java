/**
 * Concrete Appointment class - represents a healthcare appointment.
 */
public class Appointment extends Document {
    
    private int patientId;
    private int staffId;
    private String appointmentDate;
    private String appointmentTime;
    private String serviceType;
    private String notes;
    private String diagnosis;
    private String treatment;
    
    /**
     * Initialize appointment with all information
     */
    public Appointment(int id, int patientId, int staffId, String appointmentDate, 
                      String appointmentTime, String serviceType, String notes) {
        super(id, "APPOINTMENT", "PENDING", notes);
        this.patientId = patientId;
        this.staffId = staffId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.serviceType = serviceType;
        this.notes = notes;
        this.diagnosis = "";
        this.treatment = "";
    }
    
    /**
     * Default constructor
     */
    public Appointment() {
        super();
        this.documentType = "APPOINTMENT";
        this.patientId = 0;
        this.staffId = 0;
        this.appointmentDate = "";
        this.appointmentTime = "";
        this.serviceType = "";
        this.notes = "";
        this.diagnosis = "";
        this.treatment = "";
    }
    
    // Getters and Setters
    public int getPatientId() {
        return patientId;
    }
    
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
    
    public int getStaffId() {
        return staffId;
    }
    
    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }
    
    public String getAppointmentDate() {
        return appointmentDate;
    }
    
    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
    
    public String getAppointmentTime() {
        return appointmentTime;
    }
    
    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
    
    public String getServiceType() {
        return serviceType;
    }
    
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
    
    public String getNotes() {
        return notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    public String getDiagnosis() {
        return diagnosis;
    }
    
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    
    public String getTreatment() {
        return treatment;
    }
    
    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
    
    @Override
    public void approve() {
        this.status = "APPROVED";
        updateLastModifiedDate();
        System.out.println("Appointment " + documentNumber + " has been approved.");
    }
    
    @Override
    public void reject(String reason) {
        this.status = "REJECTED";
        this.notes = "Rejection reason: " + reason;
        updateLastModifiedDate();
        System.out.println("Appointment " + documentNumber + " has been rejected.");
    }
    
    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", staffId=" + staffId +
                ", appointmentDate='" + appointmentDate + '\'' +
                ", appointmentTime='" + appointmentTime + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", status='" + status + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", createdDate='" + createdDate + '\'' +
                '}';
    }
}
