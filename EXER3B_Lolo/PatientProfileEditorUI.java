import javax.swing.*;

/**
 * Concrete PatientProfileEditor class - represents the patient profile editor interface.
 */
public class PatientProfileEditorUI extends UIComponent {
    
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField dateOfBirthField;
    private JComboBox<String> genderCombo;
    private JTextArea addressArea;
    private JButton saveButton;
    private JButton cancelButton;
    
    /**
     * Initialize PatientProfileEditor
     */
    public PatientProfileEditorUI() {
        super("Patient Profile Editor", 600, 700);
        initializeUI();
    }
    
    @Override
    protected void initializeUI() {
        JPanel mainPanel = new JPanel(new java.awt.BorderLayout());
        mainPanel.setBackground(java.awt.Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel titleLabel = new JLabel("Edit Patient Profile");
        titleLabel.setFont(TITLE_FONT);
        mainPanel.add(titleLabel, java.awt.BorderLayout.NORTH);
        
        JPanel formPanel = createFormPanel();
        mainPanel.add(formPanel, java.awt.BorderLayout.CENTER);
        
        add(mainPanel);
        displayComponent();
    }
    
    /**
     * Create form panel with profile fields
     */
    private JPanel createFormPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new javax.swing.BoxLayout(panel, javax.swing.BoxLayout.Y_AXIS));
        panel.setBackground(java.awt.Color.WHITE);
        
        // First Name
        addLabeledField(panel, "First Name", firstNameField = new JTextField());
        
        // Last Name
        addLabeledField(panel, "Last Name", lastNameField = new JTextField());
        
        // Email
        addLabeledField(panel, "Email", emailField = new JTextField());
        
        // Phone
        addLabeledField(panel, "Phone Number", phoneField = new JTextField());
        
        // Date of Birth
        addLabeledField(panel, "Date of Birth (YYYY-MM-DD)", dateOfBirthField = new JTextField());
        
        // Gender
        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setFont(LABEL_FONT);
        panel.add(genderLabel);
        genderCombo = new JComboBox<>(new String[]{"Male", "Female", "Other"});
        genderCombo.setFont(INTER_FONT);
        genderCombo.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 35));
        panel.add(genderCombo);
        panel.add(Box.createVerticalStrut(15));
        
        // Address
        JLabel addressLabel = new JLabel("Address");
        addressLabel.setFont(LABEL_FONT);
        panel.add(addressLabel);
        addressArea = new JTextArea();
        addressArea.setFont(INTER_FONT);
        addressArea.setRows(4);
        JScrollPane scrollPane = new JScrollPane(addressArea);
        panel.add(scrollPane);
        panel.add(Box.createVerticalStrut(20));
        
        // Buttons
        JPanel buttonPanel = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER));
        
        saveButton = new JButton("Save");
        saveButton.setFont(BUTTON_FONT);
        saveButton.setBackground(PRIMARY_BLUE);
        saveButton.setForeground(java.awt.Color.WHITE);
        saveButton.setPreferredSize(new java.awt.Dimension(120, 40));
        
        cancelButton = new JButton("Cancel");
        cancelButton.setFont(BUTTON_FONT);
        cancelButton.setBackground(java.awt.Color.WHITE);
        cancelButton.setForeground(PRIMARY_BLUE);
        cancelButton.setBorder(BorderFactory.createLineBorder(PRIMARY_BLUE, 2));
        cancelButton.setPreferredSize(new java.awt.Dimension(120, 40));
        
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);
        
        panel.add(buttonPanel);
        
        return panel;
    }
    
    /**
     * Helper method to add labeled field
     */
    private void addLabeledField(JPanel panel, String labelText, JTextField field) {
        JLabel label = new JLabel(labelText);
        label.setFont(LABEL_FONT);
        panel.add(label);
        field.setFont(INTER_FONT);
        field.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 35));
        panel.add(field);
        panel.add(Box.createVerticalStrut(15));
    }
    
    public String getFirstName() { return firstNameField.getText(); }
    public String getLastName() { return lastNameField.getText(); }
    public String getEmail() { return emailField.getText(); }
    public String getPhone() { return phoneField.getText(); }
    public String getDateOfBirth() { return dateOfBirthField.getText(); }
    public String getGender() { return (String) genderCombo.getSelectedItem(); }
    public String getAddress() { return addressArea.getText(); }
}
