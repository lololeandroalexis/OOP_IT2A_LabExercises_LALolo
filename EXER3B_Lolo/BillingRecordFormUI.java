import javax.swing.*;

/**
 * Concrete BillingRecordForm class - represents the billing record interface.
 */
public class BillingRecordFormUI extends UIComponent {
    
    private JTextField invoiceNumberField;
    private JTextField patientNameField;
    private JTextField totalAmountField;
    private JComboBox<String> paymentStatusCombo;
    private JTextArea serviceDescriptionArea;
    private JButton saveButton;
    private JButton printButton;
    
    /**
     * Initialize BillingRecordForm
     */
    public BillingRecordFormUI() {
        super("BHC Service and Fee Collection Record", 900, 800);
        initializeUI();
    }
    
    @Override
    protected void initializeUI() {
        JPanel mainPanel = new JPanel(new java.awt.BorderLayout());
        mainPanel.setBackground(java.awt.Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel titleLabel = new JLabel("Billing Record");
        titleLabel.setFont(TITLE_FONT);
        mainPanel.add(titleLabel, java.awt.BorderLayout.NORTH);
        
        JPanel formPanel = createFormPanel();
        JScrollPane scrollPane = new JScrollPane(formPanel);
        mainPanel.add(scrollPane, java.awt.BorderLayout.CENTER);
        
        add(mainPanel);
        displayComponent();
    }
    
    /**
     * Create form panel with billing fields
     */
    private JPanel createFormPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new javax.swing.BoxLayout(panel, javax.swing.BoxLayout.Y_AXIS));
        panel.setBackground(java.awt.Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Invoice Number
        JLabel invoiceLabel = new JLabel("Invoice Number");
        invoiceLabel.setFont(LABEL_FONT);
        panel.add(invoiceLabel);
        invoiceNumberField = new JTextField();
        invoiceNumberField.setFont(INTER_FONT);
        invoiceNumberField.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 35));
        panel.add(invoiceNumberField);
        panel.add(Box.createVerticalStrut(15));
        
        // Patient Name
        JLabel patientLabel = new JLabel("Patient Name");
        patientLabel.setFont(LABEL_FONT);
        panel.add(patientLabel);
        patientNameField = new JTextField();
        patientNameField.setFont(INTER_FONT);
        patientNameField.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 35));
        panel.add(patientNameField);
        panel.add(Box.createVerticalStrut(15));
        
        // Service Description
        JLabel serviceLabel = new JLabel("Service Description");
        serviceLabel.setFont(LABEL_FONT);
        panel.add(serviceLabel);
        serviceDescriptionArea = new JTextArea();
        serviceDescriptionArea.setFont(INTER_FONT);
        serviceDescriptionArea.setRows(6);
        JScrollPane scrollPane = new JScrollPane(serviceDescriptionArea);
        panel.add(scrollPane);
        panel.add(Box.createVerticalStrut(15));
        
        // Total Amount
        JLabel amountLabel = new JLabel("Total Amount");
        amountLabel.setFont(LABEL_FONT);
        panel.add(amountLabel);
        totalAmountField = new JTextField();
        totalAmountField.setFont(INTER_FONT);
        totalAmountField.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 35));
        panel.add(totalAmountField);
        panel.add(Box.createVerticalStrut(15));
        
        // Payment Status
        JLabel statusLabel = new JLabel("Payment Status");
        statusLabel.setFont(LABEL_FONT);
        panel.add(statusLabel);
        paymentStatusCombo = new JComboBox<>(new String[]{"Pending", "Paid", "Partial", "Overdue"});
        paymentStatusCombo.setFont(INTER_FONT);
        paymentStatusCombo.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 35));
        panel.add(paymentStatusCombo);
        panel.add(Box.createVerticalStrut(20));
        
        // Buttons
        JPanel buttonPanel = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER));
        
        saveButton = new JButton("Save");
        saveButton.setFont(BUTTON_FONT);
        saveButton.setBackground(PRIMARY_BLUE);
        saveButton.setForeground(java.awt.Color.WHITE);
        saveButton.setPreferredSize(new java.awt.Dimension(120, 40));
        
        printButton = new JButton("Print");
        printButton.setFont(BUTTON_FONT);
        printButton.setBackground(java.awt.Color.WHITE);
        printButton.setForeground(PRIMARY_BLUE);
        printButton.setBorder(BorderFactory.createLineBorder(PRIMARY_BLUE, 2));
        printButton.setPreferredSize(new java.awt.Dimension(120, 40));
        
        buttonPanel.add(saveButton);
        buttonPanel.add(printButton);
        
        panel.add(buttonPanel);
        
        return panel;
    }
    
    public String getInvoiceNumber() {
        return invoiceNumberField.getText();
    }
    
    public String getPatientName() {
        return patientNameField.getText();
    }
    
    public String getTotalAmount() {
        return totalAmountField.getText();
    }
    
    public String getPaymentStatus() {
        return (String) paymentStatusCombo.getSelectedItem();
    }
}
