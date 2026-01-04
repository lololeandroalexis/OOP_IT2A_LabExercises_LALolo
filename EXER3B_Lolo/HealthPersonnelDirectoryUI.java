import javax.swing.*;

/**
 * Concrete HealthPersonnelDirectory class - represents the health personnel directory interface.
 */
public class HealthPersonnelDirectoryUI extends UIComponent {
    
    private JTable staffTable;
    private javax.swing.table.DefaultTableModel tableModel;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    
    /**
     * Initialize HealthPersonnelDirectory
     */
    public HealthPersonnelDirectoryUI() {
        super("Health Personnel Directory", 1000, 700);
        initializeUI();
    }
    
    @Override
    protected void initializeUI() {
        JPanel mainPanel = new JPanel(new java.awt.BorderLayout());
        mainPanel.setBackground(java.awt.Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel titleLabel = new JLabel("Health Personnel Directory");
        titleLabel.setFont(TITLE_FONT);
        mainPanel.add(titleLabel, java.awt.BorderLayout.NORTH);
        
        // Table
        String[] columnNames = {"ID", "Name", "Profession", "Department", "License#", "Contact"};
        tableModel = new javax.swing.table.DefaultTableModel(columnNames, 0);
        staffTable = new JTable(tableModel);
        staffTable.setFont(INTER_FONT);
        staffTable.setRowHeight(25);
        JScrollPane scrollPane = new JScrollPane(staffTable);
        mainPanel.add(scrollPane, java.awt.BorderLayout.CENTER);
        
        // Button Panel
        JPanel buttonPanel = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER));
        
        addButton = new JButton("Add Staff");
        addButton.setFont(BUTTON_FONT);
        addButton.setBackground(PRIMARY_BLUE);
        addButton.setForeground(java.awt.Color.WHITE);
        
        editButton = new JButton("Edit");
        editButton.setFont(BUTTON_FONT);
        
        deleteButton = new JButton("Delete");
        deleteButton.setFont(BUTTON_FONT);
        deleteButton.setBackground(ERROR_RED);
        deleteButton.setForeground(java.awt.Color.WHITE);
        
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        
        mainPanel.add(buttonPanel, java.awt.BorderLayout.SOUTH);
        
        add(mainPanel);
        displayComponent();
    }
    
    /**
     * Add staff member to table
     */
    public void addStaffMember(int id, String name, String profession, String department, 
                              String licenseNumber, String contact) {
        tableModel.addRow(new Object[]{id, name, profession, department, licenseNumber, contact});
    }
    
    /**
     * Remove selected staff member
     */
    public void removeStaffMember() {
        int selectedRow = staffTable.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
        }
    }
    
    public int getSelectedStaffId() {
        int selectedRow = staffTable.getSelectedRow();
        if (selectedRow != -1) {
            return (int) tableModel.getValueAt(selectedRow, 0);
        }
        return -1;
    }
}
