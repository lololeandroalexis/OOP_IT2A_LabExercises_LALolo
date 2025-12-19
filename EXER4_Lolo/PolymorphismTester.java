import javax.swing.*;
import java.awt.*;

public class PolymorphismTester {
    private static void renderDashboardView(DashboardView view, JPanel container, int patientId) {
        System.out.println(">>> Switching to view: " + view.getViewTitle());
        
        container.removeAll();
        container.add(view.displayContent(patientId), BorderLayout.CENTER);
        
        container.revalidate();
        container.repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Polymorphism Tester - Dashboard Views");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel contentArea = new JPanel(new BorderLayout());
        contentArea.setBackground(Color.WHITE);

        DashboardView profileView = new ProfileView();
        DashboardView appointmentsView = new AppointmentsView();
        DashboardView staffView = new StaffInfoView();

        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(new Color(240, 240, 240));
        sidebar.setPreferredSize(new Dimension(220, 600));
        sidebar.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        JLabel titleLabel = new JLabel("DASHBOARD VIEWS");
        titleLabel.setFont(new Font("Inter", Font.BOLD, 16));
        titleLabel.setForeground(new Color(0, 102, 204));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidebar.add(titleLabel);
        sidebar.add(Box.createVerticalStrut(30));

        JButton profileBtn = new JButton("👤 Profile");
        JButton apptBtn = new JButton("📅 Appointments");
        JButton staffBtn = new JButton("👨‍⚕️ Staff Info");

        JButton[] buttons = {profileBtn, apptBtn, staffBtn};
        for (JButton btn : buttons) {
            btn.setMaximumSize(new Dimension(200, 45));
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
            btn.setBackground(Color.WHITE);
            btn.setForeground(new Color(0, 102, 204));
            btn.setFont(new Font("Inter", Font.BOLD, 14));
            btn.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 1));
            sidebar.add(btn);
            sidebar.add(Box.createVerticalStrut(10));
        }

        profileBtn.addActionListener(e -> renderDashboardView(profileView, contentArea, 999));
        apptBtn.addActionListener(e -> renderDashboardView(appointmentsView, contentArea, 999));
        staffBtn.addActionListener(e -> renderDashboardView(staffView, contentArea, 999));

        mainPanel.add(sidebar, BorderLayout.WEST);
        mainPanel.add(contentArea, BorderLayout.CENTER);

        frame.add(mainPanel);

        SwingUtilities.invokeLater(() -> renderDashboardView(profileView, contentArea, 999));

        frame.setVisible(true);

        System.out.println("=== Polymorphism Demonstration Started ===");
        System.out.println("Notice how the same method call 'displayContent()' produces");
        System.out.println("different UI content depending on the actual object type.");
        System.out.println("This is Runtime Polymorphism in Java!\n");
    }
}