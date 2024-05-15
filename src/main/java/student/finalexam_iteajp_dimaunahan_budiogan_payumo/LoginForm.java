package student.finalexam_iteajp_dimaunahan_budiogan_payumo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Paul Dimaunahan
 */
public class LoginForm extends javax.swing.JFrame {

    public LoginForm() {
        initComponents();       
        // Add action listener to the login button
        loginButton.addActionListener(e -> login());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Left = new javax.swing.JPanel();
        iconLabel = new javax.swing.JLabel();
        madebyLabel = new javax.swing.JLabel();
        Right = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        userField = new javax.swing.JTextField();
        passLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        utypeLabel = new javax.swing.JLabel();
        chooseUserType = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(800, 500));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        Left.setBackground(new java.awt.Color(102, 102, 102));
        Left.setPreferredSize(new java.awt.Dimension(400, 500));

        iconLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Paul Dimaunahan\\Documents\\NetBeansProjects\\FINALEXAM_ITEAJP_Dimaunahan_Budiogan_Payumo\\src\\main\\java\\student\\finalexam_iteajp_dimaunahan_budiogan_payumo\\Icons\\Product.png")); // NOI18N

        madebyLabel.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        madebyLabel.setForeground(new java.awt.Color(204, 204, 204));
        madebyLabel.setText("© By Dimaunahan, Budiongan, Payumo 2024");

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(iconLabel)
                .addGap(176, 176, 176))
            .addGroup(LeftLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(madebyLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addComponent(iconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(madebyLabel)
                .addGap(66, 66, 66))
        );

        jPanel1.add(Left);
        Left.setBounds(0, 0, 410, 510);
        Left.getAccessibleContext().setAccessibleName("Right");

        Right.setBackground(new java.awt.Color(102, 255, 255));
        Right.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("LOGIN");

        userLabel.setBackground(new java.awt.Color(153, 153, 153));
        userLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userLabel.setForeground(new java.awt.Color(51, 51, 51));
        userLabel.setText("Username");

        userField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userFieldActionPerformed(evt);
            }
        });

        passLabel.setBackground(new java.awt.Color(255, 255, 255));
        passLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        passLabel.setForeground(new java.awt.Color(51, 51, 51));
        passLabel.setText("Password");

        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        loginButton.setBackground(new java.awt.Color(102, 102, 102));
        loginButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("Login");

        utypeLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        utypeLabel.setText("User Type");

        chooseUserType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "System Admin", "Manager", "Regular User" }));
        chooseUserType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseUserTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(userField)
                        .addComponent(userLabel)
                        .addComponent(passLabel)
                        .addComponent(passwordField)
                        .addComponent(utypeLabel)
                        .addComponent(chooseUserType, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel1)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addComponent(userLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(utypeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chooseUserType, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );

        jPanel1.add(Right);
        Right.setBounds(410, 0, 390, 510);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userFieldActionPerformed
        //
    }//GEN-LAST:event_userFieldActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        //
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void chooseUserTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseUserTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chooseUserTypeActionPerformed
    
    private void login() {
    String username = userField.getText();
    String password = new String(passwordField.getPassword());
    String userType = (String) chooseUserType.getSelectedItem();
    String dbUrl = "jdbc:sqlserver://LAPTOP-GAj60UQH\\SQLEXPRESS:1433;databaseName=finalExam_ITEAJP;user=sa;password=Pa$$w0rd;;encrypt=true;trustServerCertificate=true;";
    
    int[] roleIds = {1, 2, 3};
    int selectedIndex = chooseUserType.getSelectedIndex();
    int roleId = roleIds[selectedIndex];
    
    try (Connection connection = DriverManager.getConnection(dbUrl)) {
        if (validateLogin(username, password, userType, connection)) {
            openDashboardWindow(userType);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        // Handle any database connection errors
        e.printStackTrace();
    }
}

private boolean validateLogin(String username, String password, String userType, Connection connection) {
    boolean isValid = false; // Flag to track if the login is valid

    try {
        // Prepare the SQL query to select the user based on username, password, and role
        String sql = "SELECT * FROM [User] WHERE Username = ? AND Password = ? AND RoleId = ?";
        
        // Create a PreparedStatement to execute the query
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);
        
        // Map the userType to the corresponding role value
        int role;
        switch(userType) {
            case "System Admin":
                role = 1;
                break;
            case "Manager":
                role = 2;
                break;
            case "Regular User":
                role = 3;
                break;
            default:
                role = -1; // Invalid role
        }
        
        statement.setInt(3, role);

        // Execute the query
        ResultSet resultSet = statement.executeQuery();
        // Check if any rows are returned
        if (resultSet.next()) {
            // If a row is returned, the login is valid
            isValid = true;
        }
        
        // Close the ResultSet and PreparedStatement
        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        // Handle any database errors
        e.printStackTrace();
    }

    // Return the result of the validation
    return isValid;
}




    private void openDashboardWindow(String userType) {
        // Open appropriate dashboard window based on user type
        if (userType.equals("System Admin")) {
            AdminDashboard adminDashboard = new AdminDashboard();
            adminDashboard.setVisible(true);
        } else if (userType.equals("Manager")) {
            //
        } else if (userType.equals("Regular User")) {
            //
        }
        // Close the login window
        dispose();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JPanel Right;
    private javax.swing.JComboBox<String> chooseUserType;
    private javax.swing.JLabel iconLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel madebyLabel;
    private javax.swing.JLabel passLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField userField;
    private javax.swing.JLabel userLabel;
    private javax.swing.JLabel utypeLabel;
    // End of variables declaration//GEN-END:variables
}
