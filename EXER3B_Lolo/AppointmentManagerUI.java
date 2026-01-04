import javax.swing.*;

/**
 * Concrete AppointmentManager class - represents the appointment management interface.
 */
public class AppointmentManagerUI extends UIComponent {
    
    private JTextField patientNameField;
    private JTextField appointmentDateField;
    private JComboBox<String> serviceTypeCombo;
    private JTextArea notesArea;
    private JButton submitButton;
    private JButton cancelButton;
    
    /**
     * Initialize AppointmentManager
     */
    public AppointmentManagerUI() {
        super("Barangay Health Center - Appointment Manager", 900, 700);
        initializeUI();
    }
    
    @Override
    protected void initializeUI() {
        JPanel mainPanel = new JPanel(new java.awt.BorderLayout());
        mainPanel.setBackground(java.awt.Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel titleLabel = new JLabel("Appointment Manager");
        titleLabel.setFont(TITLE_FONT);
        mainPanel.add(titleLabel, java.awt.BorderLayout.NORTH);
        
        JPanel formPanel = createFormPanel();
        mainPanel.add(formPanel, java.awt.BorderLayout.CENTER);
        
        add(mainPanel);
        displayComponent();
    }
    
    /**
     * Create form panel with appointment fields
     */
    private JPanel createFormPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new javax.swing.BoxLayout(panel, javax.swing.BoxLayout.Y_AXIS));
        panel.setBackground(java.awt.Color.WHITE);
        
        // Patient Name
        JLabel patientLabel = new JLabel("Patient Name");
        patientLabel.setFont(LABEL_FONT);
        panel.add(patientLabel);
        patientNameField = new JTextField();
        patientNameField.setFont(INTER_FONT);
        patientNameField.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 35));
        panel.add(patientNameField);
        panel.add(Box.createVerticalStrut(15));
        
        // Appointment Date
        JLabel dateLabel = new JLabel("Appointment Date");
        dateLabel.setFont(LABEL_FONT);
        panel.add(dateLabel);
        appointmentDateField = new JTextField();
        appointmentDateField.setFont(INTER_FONT);
        appointmentDateField.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 35));
        panel.add(appointmentDateField);
        panel.add(Box.createVerticalStrut(15));
        
        // Service Type
        JLabel serviceLabel = new JLabel("Service Type");
        serviceLabel.setFont(LABEL_FONT);
        panel.add(serviceLabel);
        serviceTypeCombo = new JComboBox<>(new String[]{"General Checkup", "Consultation", "Vaccination", "Lab Test"});
        serviceTypeCombo.setFont(INTER_FONT);
        serviceTypeCombo.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 35));
        panel.add(serviceTypeCombo);
        panel.add(Box.createVerticalStrut(15));
        
        // Notes
        JLabel notesLabel = new JLabel("Notes");
        notesLabel.setFont(LABEL_FONT);
        panel.add(notesLabel);
        notesArea = new JTextArea();
        notesArea.setFont(INTER_FONT);
        notesArea.setRows(5);
        JScrollPane scrollPane = new JScrollPane(notesArea);
        panel.add(scrollPane);
        panel.add(Box.createVerticalStrut(20));
        
        // Buttons
        JPanel buttonPanel = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER));
        
        submitButton = new JButton("Submit");
        submitButton.setFont(BUTTON_FONT);
        submitButton.setBackground(PRIMARY_BLUE);
        submitButton.setForeground(java.awt.Color.WHITE);
        submitButton.setPreferredSize(new java.awt.Dimension(120, 40));
        
        cancelButton = new JButton("Cancel");
        cancelButton.setFont(BUTTON_FONT);
        cancelButton.setBackground(java.awt.Color.WHITE);
        cancelButton.setForeground(PRIMARY_BLUE);
        cancelButton.setBorder(BorderFactory.createLineBorder(PRIMARY_BLUE, 2));
        cancelButton.setPreferredSize(new java.awt.Dimension(120, 40));
        
        buttonPanel.add(submitButton);
        buttonPanel.add(cancelButton);
        
        panel.add(buttonPanel);
        
        return panel;
    }
    
    public String getPatientName() {
        return patientNameField.getText();
    }
    
    public String getAppointmentDate() {
        return appointmentDateField.getText();
    }
    
    public String getServiceType() {
        return (String) serviceTypeCombo.getSelectedItem();
    }
    
    public String getNotes() {
        return notesArea.getText();
    }
}
