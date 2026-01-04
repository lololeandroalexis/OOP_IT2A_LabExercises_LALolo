import javax.swing.*;

/**
 * Concrete ContactInformation class - represents the contact information interface.
 */
public class ContactInformationUI extends UIComponent {
    
    private JLabel addressLabel;
    private JLabel phoneLabel;
    private JLabel emailLabel;
    private JLabel hoursLabel;
    
    /**
     * Initialize ContactInformation
     */
    public ContactInformationUI() {
        super("BHC Contact Information and Operating Hours", 950, 850);
        initializeUI();
    }
    
    @Override
    protected void initializeUI() {
        JPanel mainPanel = new JPanel(new java.awt.BorderLayout());
        mainPanel.setBackground(java.awt.Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        
        JLabel titleLabel = new JLabel("Contact Information");
        titleLabel.setFont(TITLE_FONT);
        mainPanel.add(titleLabel, java.awt.BorderLayout.NORTH);
        
        JPanel contentPanel = createContentPanel();
        mainPanel.add(contentPanel, java.awt.BorderLayout.CENTER);
        
        add(mainPanel);
        displayComponent();
    }
    
    /**
     * Create content panel with contact information
     */
    private JPanel createContentPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new javax.swing.BoxLayout(panel, javax.swing.BoxLayout.Y_AXIS));
        panel.setBackground(java.awt.Color.WHITE);
        
        // Address Section
        JLabel addressSectionLabel = new JLabel("📍 Address");
        addressSectionLabel.setFont(new java.awt.Font("Inter", java.awt.Font.BOLD, 14));
        addressSectionLabel.setForeground(PRIMARY_BLUE);
        panel.add(addressSectionLabel);
        addressLabel = new JLabel("Barangay Health Center, Main Street, City, Country");
        addressLabel.setFont(INTER_FONT);
        panel.add(addressLabel);
        panel.add(Box.createVerticalStrut(20));
        
        // Phone Section
        JLabel phoneSectionLabel = new JLabel("☎️ Phone");
        phoneSectionLabel.setFont(new java.awt.Font("Inter", java.awt.Font.BOLD, 14));
        phoneSectionLabel.setForeground(PRIMARY_BLUE);
        panel.add(phoneSectionLabel);
        phoneLabel = new JLabel("(555) 123-4567");
        phoneLabel.setFont(INTER_FONT);
        panel.add(phoneLabel);
        panel.add(Box.createVerticalStrut(20));
        
        // Email Section
        JLabel emailSectionLabel = new JLabel("📧 Email");
        emailSectionLabel.setFont(new java.awt.Font("Inter", java.awt.Font.BOLD, 14));
        emailSectionLabel.setForeground(PRIMARY_BLUE);
        panel.add(emailSectionLabel);
        emailLabel = new JLabel("contact@bhc.gov");
        emailLabel.setFont(INTER_FONT);
        panel.add(emailLabel);
        panel.add(Box.createVerticalStrut(20));
        
        // Operating Hours Section
        JLabel hoursSectionLabel = new JLabel("🕐 Operating Hours");
        hoursSectionLabel.setFont(new java.awt.Font("Inter", java.awt.Font.BOLD, 14));
        hoursSectionLabel.setForeground(PRIMARY_BLUE);
        panel.add(hoursSectionLabel);
        hoursLabel = new JLabel("<html>Monday - Friday: 8:00 AM - 5:00 PM<br>Saturday: 9:00 AM - 1:00 PM<br>Sunday: Closed</html>");
        hoursLabel.setFont(INTER_FONT);
        panel.add(hoursLabel);
        panel.add(Box.createVerticalGlue());
        
        return panel;
    }
    
    public void setAddress(String address) { addressLabel.setText(address); }
    public void setPhone(String phone) { phoneLabel.setText(phone); }
    public void setEmail(String email) { emailLabel.setText(email); }
    public void setOperatingHours(String hours) { hoursLabel.setText(hours); }
}
