import javax.swing.*;

/**
 * Concrete StaffDashboard class - represents the staff interface.
 */
public class StaffDashboardUI extends UIComponent {
    
    private JPanel mainContentPanel;
    private JLabel totalAppointmentsLabel;
    private JLabel totalPatientsLabel;
    private JButton dashboardButton;
    private JButton appointmentsButton;
    private JButton patientRecordsButton;
    private JButton appointmentHistoryButton;
    private JButton billingHistoryButton;
    private JButton logoutButton;
    
    /**
     * Initialize StaffDashboard
     */
    public StaffDashboardUI() {
        super("Barangay Health Center - Staff Dashboard", 1200, 750);
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
        
        JLabel titleLabel = new JLabel("STAFF PANEL");
        titleLabel.setFont(new java.awt.Font("Inter", java.awt.Font.BOLD, 16));
        titleLabel.setForeground(PRIMARY_BLUE);
        sidebar.add(titleLabel);
        sidebar.add(Box.createVerticalStrut(30));
        
        dashboardButton = createNavButton("📊 Dashboard");
        appointmentsButton = createNavButton("📅 Appointments");
        patientRecordsButton = createNavButton("👤 Patient Records");
        appointmentHistoryButton = createNavButton("📋 History");
        billingHistoryButton = createNavButton("💳 Billing");
        logoutButton = createNavButton("🚪 Logout");
        
        sidebar.add(dashboardButton);
        sidebar.add(Box.createVerticalStrut(10));
        sidebar.add(appointmentsButton);
        sidebar.add(Box.createVerticalStrut(10));
        sidebar.add(patientRecordsButton);
        sidebar.add(Box.createVerticalStrut(10));
        sidebar.add(appointmentHistoryButton);
        sidebar.add(Box.createVerticalStrut(10));
        sidebar.add(billingHistoryButton);
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
        
        showDashboard();
        return mainContentPanel;
    }
    
    /**
     * Display dashboard overview
     */
    public void showDashboard() {
        mainContentPanel.removeAll();
        JLabel titleLabel = new JLabel("Dashboard");
        titleLabel.setFont(TITLE_FONT);
        mainContentPanel.add(titleLabel, java.awt.BorderLayout.NORTH);
        
        JPanel statsPanel = new JPanel();
        statsPanel.setLayout(new java.awt.GridLayout(1, 2, 20, 20));
        
        totalAppointmentsLabel = new JLabel("Total Appointments: 0");
        totalAppointmentsLabel.setFont(LABEL_FONT);
        totalPatientsLabel = new JLabel("Total Patients: 0");
        totalPatientsLabel.setFont(LABEL_FONT);
        
        statsPanel.add(totalAppointmentsLabel);
        statsPanel.add(totalPatientsLabel);
        
        mainContentPanel.add(statsPanel, java.awt.BorderLayout.CENTER);
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
    }
    
    /**
     * Display manage appointments
     */
    public void showManageAppointments() {
        mainContentPanel.removeAll();
        JLabel titleLabel = new JLabel("Manage Appointments");
        titleLabel.setFont(TITLE_FONT);
        mainContentPanel.add(titleLabel, java.awt.BorderLayout.NORTH);
        
        JLabel infoLabel = new JLabel("Appointment management interface");
        mainContentPanel.add(infoLabel, java.awt.BorderLayout.CENTER);
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
    }
    
    /**
     * Display patient records
     */
    public void showPatientRecords() {
        mainContentPanel.removeAll();
        JLabel titleLabel = new JLabel("Patient Records");
        titleLabel.setFont(TITLE_FONT);
        mainContentPanel.add(titleLabel, java.awt.BorderLayout.NORTH);
        
        JLabel infoLabel = new JLabel("Patient records will be displayed here");
        mainContentPanel.add(infoLabel, java.awt.BorderLayout.CENTER);
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
    }
    
    /**
     * Logout action
     */
    public void logout() {
        System.out.println("Staff logged out");
        System.exit(0);
    }
}
