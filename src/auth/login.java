package auth;
import admin.home_page;
import connect.connect;
import java.sql.*;
import java.awt.*;
import javax.swing.JOptionPane;
public class login extends javax.swing.JFrame {
    public login() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtField_pass = new javax.swing.JPasswordField();
        txtField_username = new javax.swing.JTextField();
        forgot = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_login = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtField_pass.setBackground(new java.awt.Color(255, 255, 255));
        txtField_pass.setFont(new java.awt.Font("Fredoka One", 0, 14)); // NOI18N
        txtField_pass.setBorder(null);
        txtField_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtField_passActionPerformed(evt);
            }
        });
        getContentPane().add(txtField_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 400, 280, 30));

        txtField_username.setBackground(new java.awt.Color(255, 255, 255));
        txtField_username.setFont(new java.awt.Font("Fredoka One", 0, 14)); // NOI18N
        txtField_username.setForeground(new java.awt.Color(0, 0, 0));
        txtField_username.setBorder(null);
        txtField_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtField_usernameActionPerformed(evt);
            }
        });
        getContentPane().add(txtField_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 320, 280, 30));

        forgot.setFont(new java.awt.Font("Fredoka One", 0, 16)); // NOI18N
        forgot.setForeground(new java.awt.Color(26, 72, 70));
        forgot.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        forgot.setText("Lupa Password ?");
        forgot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                forgotMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                forgotMouseExited(evt);
            }
        });
        getContentPane().add(forgot, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 550, 130, 30));

        jLabel4.setFont(new java.awt.Font("Fredoka One", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(26, 72, 70));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Password");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 360, 90, 30));

        btn_login.setFont(new java.awt.Font("Fredoka One", 0, 18)); // NOI18N
        btn_login.setForeground(new java.awt.Color(26, 72, 70));
        btn_login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_login.setText("Login");
        btn_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_loginMouseClicked(evt);
            }
        });
        getContentPane().add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(1037, 486, 90, 40));

        jLabel3.setFont(new java.awt.Font("Fredoka One", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(26, 72, 70));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Username");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 280, 90, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Auth8.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void forgotMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotMouseEntered
        forgot.setForeground(Color.black);
    }//GEN-LAST:event_forgotMouseEntered

    private void forgotMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotMouseExited
        forgot.setForeground(Color.decode("#1A4846"));
    }//GEN-LAST:event_forgotMouseExited

    private void txtField_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtField_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtField_usernameActionPerformed

    private void txtField_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtField_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtField_passActionPerformed

    private void btn_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginMouseClicked
        String pass = new String(txtField_pass.getPassword());
        String user = txtField_username.getText();
        
        if(user.equals("") && pass.equals("")) {
            JOptionPane.showMessageDialog(null, "Harap di isi Username dan Password");
        } else if(user.equals("")) {
            JOptionPane.showMessageDialog(null, "Harap di isi Username");
        } else if(pass.equals("")) {
            JOptionPane.showMessageDialog(null,"Harap di isi Password");
        } else {
            try {
                String query = "select username,password from persons where username='"+user+"' and password='"+pass+"'";
                Connection conn = (Connection)connect.configDB();
                Statement stm = conn.createStatement();
                ResultSet res = stm.executeQuery(query);
                if(res.next()) {
                    home_page home = new home_page();
                    home.setTitle("Hello");
                    home.setVisible(true);
                    this.setVisible(false);
                }
            } catch(SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_loginMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_login;
    private javax.swing.JLabel forgot;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txtField_pass;
    private javax.swing.JTextField txtField_username;
    // End of variables declaration//GEN-END:variables
}
