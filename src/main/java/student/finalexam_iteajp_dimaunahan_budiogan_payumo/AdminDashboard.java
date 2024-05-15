package student.finalexam_iteajp_dimaunahan_budiogan_payumo;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class AdminDashboard extends javax.swing.JFrame {
    public AdminDashboard() {
        initComponents();
    }

    private void initComponents() {
        // Initialize components for AdminDashboard
        // For demonstration, let's just add a label indicating the user type
        JLabel userTypeLabel = new JLabel("Admin Dashboard");
        add(userTypeLabel);
        setTitle("Admin Dashboard");
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
