import javax.swing.*;

/**
 * Concrete PatientDashboard class - represents the patient interface.
 */
public class PatientDashboardUI extends UIComponent {
    
    private int patientId;
    private String patientEmail;
    private JLabel patientNameLabel;
    private JLabel birthdateLabel;
    private JPanel mainContentPanel;
    private JButton profileButton;
    private JButton appointmentsButton;
    private JButton staffInfoButton;
    private JButton logoutButton;
    
    /**
     * Initialize PatientDashboard
     */
    public PatientDashboardUI(int userId, String email) {
        super("Barangay Health Center - Patient Dashboard", 1200, 700);
        this.patientId = userId;
        this.patientEmail = email;
        initializeUI();
    }
    
    @Override
    protected void initializeUI() {
        JPanel mainPanel = new JPanel(new java.awt.BorderLayout());
        mainPanel.add(createSidebar(), java.awt.BorderLayout.WEST);
        mainPanel.add(createContent(), java.awt.BorderLayout.CENTER);
        
        add(mainPanel);
        displayComponent();
    }
    
    /**
     * Create left sidebar navigation
     */
    private JPanel createSidebar() {
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new javax.swing.BoxLayout(sidebar, javax.swing.BoxLayout.Y_AXIS));
        sidebar.setBackground(SIDEBAR_GRAY);
        sidebar.setPreferredSize(new java.awt.Dimension(200, 750));
        sidebar.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        
        JLabel titleLabel = new JLabel("PATIENT");
        titleLabel.setFont(new java.awt.Font("Inter", java.awt.Font.BOLD, 16));
        titleLabel.setForeground(PRIMARY_BLUE);
        sidebar.add(titleLabel);
        sidebar.add(Box.createVerticalStrut(30));
        
        profileButton = createNavButton("👤 Profile");
        appointmentsButton = createNavButton("📅 Appointments");
        staffInfoButton = createNavButton("👨‍⚕️ Staff Info");
        logoutButton = createNavButton("🚪 Logout");
        
        sidebar.add(profileButton);
        sidebar.add(Box.createVerticalStrut(10));
        sidebar.add(appointmentsButton);
        sidebar.add(Box.createVerticalStrut(10));
        sidebar.add(staffInfoButton);
        sidebar.add(Box.createVerticalStrut(30));
        sidebar.add(Box.createVerticalGlue());
        sidebar.add(logoutButton);
        
        return sidebar;
    }
    
    /**
     * Create navigation button
     */
    private JButton createNavButton(String text) {
        JButton button = new JButton(text);
        button.setFont(BUTTON_FONT);
        button.setForeground(PRIMARY_BLUE);
        button.setBackground(java.awt.Color.WHITE);
        button.setBorder(BorderFactory.createLineBorder(PRIMARY_BLUE, 1));
        button.setMaximumSize(new java.awt.Dimension(180, 40));
        button.setAlignmentX(javax.swing.JComponent.LEFT_ALIGNMENT);
        return button;
    }
    
    /**
     * Create main content panel
     */
    private JPanel createContent() {
        mainContentPanel = new JPanel(new java.awt.BorderLayout());
        mainContentPanel.setBackground(java.awt.Color.WHITE);
        mainContentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        showProfile();
        return mainContentPanel;
    }
    
    /**
     * Display patient profile
     */
    public void showProfile() {
        mainContentPanel.removeAll();
        JLabel titleLabel = new JLabel("My Profile");
        titleLabel.setFont(TITLE_FONT);
        mainContentPanel.add(titleLabel, java.awt.BorderLayout.NORTH);
        
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new javax.swing.BoxLayout(contentPanel, javax.swing.BoxLayout.Y_AXIS));
        
        patientNameLabel = new JLabel("Patient Name: " + patientEmail);
        birthdateLabel = new JLabel("Date of Birth: [To be loaded]");
        
        contentPanel.add(patientNameLabel);
        contentPanel.add(birthdateLabel);
        
        mainContentPanel.add(contentPanel, java.awt.BorderLayout.CENTER);
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
    }
    
    /**
     * Display appointments
     */
    public void showAppointments() {
        mainContentPanel.removeAll();
        JLabel titleLabel = new JLabel("My Appointments");
        titleLabel.setFont(TITLE_FONT);
        mainContentPanel.add(titleLabel, java.awt.BorderLayout.NORTH);
        
        JLabel infoLabel = new JLabel("Appointments will be displayed here");
        mainContentPanel.add(infoLabel, java.awt.BorderLayout.CENTER);
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
    }
    
    /**
     * Display staff information
     */
    public void showStaffInfo() {
        mainContentPanel.removeAll();
        JLabel titleLabel = new JLabel("Available Staff");
        titleLabel.setFont(TITLE_FONT);
        mainContentPanel.add(titleLabel, java.awt.BorderLayout.NORTH);
        
        JLabel infoLabel = new JLabel("Staff directory will be displayed here");
        mainContentPanel.add(infoLabel, java.awt.BorderLayout.CENTER);
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
    }
    
    /**
     * Logout action
     */
    public void logout() {
        System.out.println("Patient logged out");
        System.exit(0);
    }
    
    public int getPatientId() {
        return patientId;
    }
    
    public String getPatientEmail() {
        return patientEmail;
    }
}
