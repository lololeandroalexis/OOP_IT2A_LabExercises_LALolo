import javax.swing.*;

/**
 * Concrete LoginScreen class - represents the login interface of the system.
 */
public class LoginScreen extends UIComponent {
    
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton signInButton;
    private JButton signUpButton;
    private JLabel statusLabel;
    private boolean isAuthenticated;
    
    /**
     * Initialize LoginScreen
     */
    public LoginScreen() {
        super("Barangay Health Center - Login", 500, 750);
        this.isAuthenticated = false;
        initializeUI();
    }
    
    @Override
    protected void initializeUI() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new javax.swing.BoxLayout(mainPanel, javax.swing.BoxLayout.Y_AXIS));
        mainPanel.setBackground(java.awt.Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
        
        // Title
        JLabel titleLabel = new JLabel("WELCOME BACK");
        titleLabel.setFont(TITLE_FONT);
        titleLabel.setForeground(PRIMARY_BLUE);
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalStrut(20));
        
        // Email field
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(LABEL_FONT);
        mainPanel.add(emailLabel);
        emailField = new JTextField();
        emailField.setFont(INTER_FONT);
        emailField.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 35));
        mainPanel.add(emailField);
        mainPanel.add(Box.createVerticalStrut(15));
        
        // Password field
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(LABEL_FONT);
        mainPanel.add(passwordLabel);
        passwordField = new JPasswordField();
        passwordField.setFont(INTER_FONT);
        passwordField.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 35));
        mainPanel.add(passwordField);
        mainPanel.add(Box.createVerticalStrut(20));
        
        // Status label
        statusLabel = new JLabel("");
        statusLabel.setFont(new java.awt.Font("Inter", java.awt.Font.PLAIN, 11));
        statusLabel.setForeground(ERROR_RED);
        mainPanel.add(statusLabel);
        mainPanel.add(Box.createVerticalStrut(10));
        
        // Sign In button
        signInButton = new JButton("Sign In");
        signInButton.setFont(BUTTON_FONT);
        signInButton.setBackground(PRIMARY_BLUE);
        signInButton.setForeground(java.awt.Color.WHITE);
        signInButton.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 40));
        signInButton.addActionListener(e -> handleSignIn());
        mainPanel.add(signInButton);
        mainPanel.add(Box.createVerticalStrut(15));
        
        // Sign Up button
        signUpButton = new JButton("Sign Up");
        signUpButton.setFont(BUTTON_FONT);
        signUpButton.setBackground(java.awt.Color.WHITE);
        signUpButton.setForeground(PRIMARY_BLUE);
        signUpButton.setBorder(BorderFactory.createLineBorder(PRIMARY_BLUE, 2));
        signUpButton.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 40));
        signUpButton.addActionListener(e -> handleSignUp());
        mainPanel.add(signUpButton);
        
        add(mainPanel);
        displayComponent();
    }
    
    /**
     * Handle sign in action
     */
    private void handleSignIn() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        
        if (email.isEmpty() || password.isEmpty()) {
            statusLabel.setText("Please fill in all fields");
            return;
        }
        
        // Simulate authentication
        isAuthenticated = true;
        statusLabel.setForeground(new java.awt.Color(40, 167, 69));
        statusLabel.setText("Login successful!");
        System.out.println("User logged in: " + email);
    }
    
    /**
     * Handle sign up action
     */
    private void handleSignUp() {
        System.out.println("Sign up button clicked");
        statusLabel.setText("Redirecting to sign up...");
    }
    
    public boolean isAuthenticated() {
        return isAuthenticated;
    }
    
    public String getEmail() {
        return emailField.getText();
    }
    
    public void setEmail(String email) {
        emailField.setText(email);
    }
}
