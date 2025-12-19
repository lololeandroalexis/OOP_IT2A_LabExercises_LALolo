import javax.swing.*;
import java.awt.*;

interface DashboardView {
  
    JPanel displayContent(int patientId);
    
    
    default String getViewTitle() {
        return "Untitled View";
    }
}

class ProfileView implements DashboardView {
    @Override
    public JPanel displayContent(int patientId) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("Patient Profile");
        title.setFont(new Font("Inter", Font.BOLD, 18));
        title.setForeground(new Color(0, 102, 204));

        JLabel name = new JLabel("Name: Juan Dela Cruz");
        JLabel birthdate = new JLabel("Birthdate: January 15, 1990");
        JLabel email = new JLabel("Email: patient@example.com");

        panel.add(title);
        panel.add(Box.createVerticalStrut(20));
        panel.add(name);
        panel.add(birthdate);
        panel.add(email);
        panel.add(Box.createVerticalStrut(20));

        JButton editBtn = new JButton("Edit Profile");
        editBtn.setBackground(new Color(0, 102, 204));
        editBtn.setForeground(Color.WHITE);
        panel.add(editBtn);

        return panel;
    }

    @Override
    public String getViewTitle() {
        return "Profile";
    }
}

class AppointmentsView implements DashboardView {
    @Override
    public JPanel displayContent(int patientId) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("My Appointments");
        title.setFont(new Font("Inter", Font.BOLD, 18));
        title.setForeground(new Color(0, 102, 204));
        panel.add(title, BorderLayout.NORTH);

        String[][] data = {
            {"1", "Check-up", "2025-12-20", "10:00 AM", "Dr. Santos", "Approved"},
            {"2", "Vaccination", "2025-12-25", "02:00 PM", "Nurse Reyes", "Pending"}
        };
        String[] columns = {"ID", "Reason", "Date", "Time", "Staff", "Status"};

        JTable table = new JTable(data, columns);
        JScrollPane scroll = new JScrollPane(table);
        panel.add(scroll, BorderLayout.CENTER);

        JButton bookBtn = new JButton("+ Book Appointment");
        bookBtn.setBackground(new Color(0, 102, 204));
        bookBtn.setForeground(Color.WHITE);
        JPanel south = new JPanel();
        south.add(bookBtn);
        panel.add(south, BorderLayout.SOUTH);

        return panel;
    }

    @Override
    public String getViewTitle() {
        return "Appointments";
    }
}

class StaffInfoView implements DashboardView {
    @Override
    public JPanel displayContent(int patientId) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("Health Center Staff");
        title.setFont(new Font("Inter", Font.BOLD, 18));
        title.setForeground(new Color(0, 102, 204));

        String[][] staffData = {
            {"101", "Dr. Maria Santos", "Doctor", "General Medicine", "maria@healthcenter.com"},
            {"102", "Nurse Ana Reyes", "Nurse", "Patient Care", "ana@healthcenter.com"},
            {"103", "Midwife Clara Lim", "Midwife", "Maternal Health", "clara@healthcenter.com"}
        };
        String[] columns = {"ID", "Name", "Role", "Focus", "Contact"};

        JTable table = new JTable(staffData, columns);
        JScrollPane scroll = new JScrollPane(table);

        panel.add(title);
        panel.add(Box.createVerticalStrut(20));
        panel.add(scroll);

        return panel;
    }

    @Override
    public String getViewTitle() {
        return "Staff Info";
    }
}

public class PolymorphismFromDashboard {
    
    // This method accepts ANY DashboardView — polymorphism in action!
    private static void showView(DashboardView view, JPanel contentPanel, int patientId) {
        contentPanel.removeAll();
        contentPanel.add(view.displayContent(patientId));
        contentPanel.revalidate();
        contentPanel.repaint();
        
        System.out.println("Now showing: " + view.getViewTitle());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Polymorphism Demo - From PatientDashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel mainPanel = new JPanel(new BorderLayout());
        
        // Sidebar with navigation (just like your original)
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(new Color(240, 240, 240));
        sidebar.setPreferredSize(new Dimension(200, 600));

        DashboardView[] views = {
            new ProfileView(),
            new AppointmentsView(),
            new StaffInfoView()
        };

        String[] labels = {"Profile", "Appointments", "Staff Info"};

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        for (int i = 0; i < views.length; i++) {
            final int index = i;
            JButton btn = new JButton(labels[i]);
            btn.addActionListener(e -> showView(views[index], contentPanel, 1)); // patientId = 1
            btn.setMaximumSize(new Dimension(180, 40));
            btn.setAlignmentX(Component.LEFT_ALIGNMENT);
            sidebar.add(btn);
            sidebar.add(Box.createVerticalStrut(10));
        }

        mainPanel.add(sidebar, BorderLayout.WEST);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        frame.add(mainPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Initially show Profile
        showView(views[0], contentPanel, 1);
    }
}