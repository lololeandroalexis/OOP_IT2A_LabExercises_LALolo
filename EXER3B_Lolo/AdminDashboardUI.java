import javax.swing.*;

/**
 * Concrete AdminDashboard class - represents the admin interface.
 */
public class AdminDashboardUI extends UIComponent {
    
    private JPanel mainContentPanel;
    private JLabel totalPatientsLabel;
    private JLabel totalStaffLabel;
    private JLabel pendingAppointmentsLabel;
    private JButton dashboardButton;
    private JButton manageStaffButton;
    private JButton billingButton;
    private JButton userManagementButton;
    private JButton settingsButton;
    private JButton logoutButton;
    
    /**
     * Initialize AdminDashboard
     */
    public AdminDashboardUI() {
        super("Barangay Health Center - Admin Dashboard", 1200, 750);
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
        
        JLabel titleLabel = new JLabel("ADMIN PANEL");
        titleLabel.setFont(new java.awt.Font("Inter", java.awt.Font.BOLD, 16));
        titleLabel.setForeground(PRIMARY_BLUE);
        sidebar.add(titleLabel);
        sidebar.add(Box.createVerticalStrut(30));
        
        dashboardButton = createNavButton("📊 Dashboard");
        manageStaffButton = createNavButton("👥 Manage Staff");
        billingButton = createNavButton("💰 Billing Records");
        userManagementButton = createNavButton("👤 Users");
        settingsButton = createNavButton("⚙️ Settings");
        logoutButton = createNavButton("🚪 Logout");
        
        sidebar.add(dashboardButton);
        sidebar.add(Box.createVerticalStrut(10));
        sidebar.add(manageStaffButton);
        sidebar.add(Box.createVerticalStrut(10));
        sidebar.add(billingButton);
        sidebar.add(Box.createVerticalStrut(10));
        sidebar.add(userManagementButton);
        sidebar.add(Box.createVerticalStrut(10));
        sidebar.add(settingsButton);
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
        statsPanel.setLayout(new java.awt.GridLayout(1, 3, 20, 20));
        
        totalPatientsLabel = new JLabel("Total Patients: 0");
        totalPatientsLabel.setFont(LABEL_FONT);
        totalStaffLabel = new JLabel("Total Staff: 0");
        totalStaffLabel.setFont(LABEL_FONT);
        pendingAppointmentsLabel = new JLabel("Pending Appointments: 0");
        pendingAppointmentsLabel.setFont(LABEL_FONT);
        
        statsPanel.add(totalPatientsLabel);
        statsPanel.add(totalStaffLabel);
        statsPanel.add(pendingAppointmentsLabel);
        
        mainContentPanel.add(statsPanel, java.awt.BorderLayout.CENTER);
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
    }
    
    /**
     * Display staff management
     */
    public void showStaffManagement() {
        mainContentPanel.removeAll();
        JLabel titleLabel = new JLabel("Manage Staff");
        titleLabel.setFont(TITLE_FONT);
        mainContentPanel.add(titleLabel, java.awt.BorderLayout.NORTH);
        
        JLabel infoLabel = new JLabel("Staff management interface");
        mainContentPanel.add(infoLabel, java.awt.BorderLayout.CENTER);
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
    }
    
    /**
     * Display billing records
     */
    public void showBillingRecords() {
        mainContentPanel.removeAll();
        JLabel titleLabel = new JLabel("Billing Records");
        titleLabel.setFont(TITLE_FONT);
        mainContentPanel.add(titleLabel, java.awt.BorderLayout.NORTH);
        
        JLabel infoLabel = new JLabel("Billing records will be displayed here");
        mainContentPanel.add(infoLabel, java.awt.BorderLayout.CENTER);
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
    }
    
    /**
     * Logout action
     */
    public void logout() {
        System.out.println("Admin logged out");
        System.exit(0);
    }
}
