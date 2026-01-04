import javax.swing.*;

/**
 * Abstract base class for all UI components in the Health Center Management System.
 * All GUI windows should extend this class.
 */
public abstract class UIComponent extends JFrame {
    
    // Define standard colors and fonts
    protected static final java.awt.Color PRIMARY_BLUE = new java.awt.Color(0, 102, 204);
    protected static final java.awt.Color SIDEBAR_GRAY = new java.awt.Color(240, 240, 240);
    protected static final java.awt.Color LIGHT_GRAY = new java.awt.Color(245, 245, 245);
    protected static final java.awt.Color ERROR_RED = new java.awt.Color(220, 53, 69);
    protected static final java.awt.Color TEXT_GRAY = new java.awt.Color(100, 100, 100);
    
    protected static final java.awt.Font INTER_FONT = new java.awt.Font("Inter", java.awt.Font.PLAIN, 14);
    protected static final java.awt.Font TITLE_FONT = new java.awt.Font("Inter", java.awt.Font.BOLD, 18);
    protected static final java.awt.Font LABEL_FONT = new java.awt.Font("Inter", java.awt.Font.BOLD, 12);
    protected static final java.awt.Font BUTTON_FONT = new java.awt.Font("Inter", java.awt.Font.BOLD, 14);
    
    private String windowTitle;
    private int defaultWidth = 1200;
    private int defaultHeight = 750;
    
    /**
     * Initialize UI component with title
     */
    protected UIComponent(String title) {
        this.windowTitle = title;
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(defaultWidth, defaultHeight));
    }
    
    /**
     * Initialize UI with custom dimensions
     */
    protected UIComponent(String title, int width, int height) {
        this(title);
        this.defaultWidth = width;
        this.defaultHeight = height;
        setPreferredSize(new java.awt.Dimension(width, height));
    }
    
    /**
     * Display the UI component centered on screen
     */
    protected void displayComponent() {
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    /**
     * Abstract method for creating the main UI
     */
    protected abstract void initializeUI();
    
    /**
     * Get the window title
     */
    public String getWindowTitle() {
        return windowTitle;
    }
    
    /**
     * Set the window title
     */
    public void setWindowTitle(String title) {
        this.windowTitle = title;
        setTitle(title);
    }
}
