
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author GAURAV
 */
public class ReceptionistLogin extends javax.swing.JFrame {

    /**
     * Creates new form ReceptionistLogin
     */
    boolean isLoggedIn;

    public ReceptionistLogin() {
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtreceptionistidlogin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtpasswordreceptionistlogin = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 102, 204));
        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Receptionist ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 210, -1, 40));

        txtreceptionistidlogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtreceptionistidlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtreceptionistidloginActionPerformed(evt);
            }
        });
        txtreceptionistidlogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtreceptionistidloginKeyPressed(evt);
            }
        });
        getContentPane().add(txtreceptionistidlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 280, 340, 40));

        jLabel3.setBackground(new java.awt.Color(0, 102, 204));
        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("PASSWORD");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 350, -1, -1));

        jButton1.setBackground(new java.awt.Color(102, 153, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jButton1.setText("LOGIN");
        jButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 490, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setText("RECEPTIONIST LOGIN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, -1, 60));

        txtpasswordreceptionistlogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtpasswordreceptionistlogin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtpasswordreceptionistlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordreceptionistloginActionPerformed(evt);
            }
        });
        getContentPane().add(txtpasswordreceptionistlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 411, 340, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 590));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txtpasswordreceptionistlogin.getText().trim().isEmpty() || txtreceptionistidlogin.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "plese enter some data");
            txtpasswordreceptionistlogin.setText("");
            txtreceptionistidlogin.setText("");
            return;
        }
        int did = Integer.parseInt(txtreceptionistidlogin.getText());
        String password = txtpasswordreceptionistlogin.getText();

        try {
            Database dbcon = new Database();
            String s = "select * from  receptionist where rid='" + did + "' and password='" + password + "'";

            ResultSet res = dbcon.sm.executeQuery(s);

            if (res.next()) {
                isLoggedIn = true;
                new ReceptionistDashBoard().setVisible(true);
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(this, "plese enter valid data");
                txtpasswordreceptionistlogin.setText("");
                txtreceptionistidlogin.setText("");
                this.setVisible(false);
                this.setVisible(true);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtreceptionistidloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtreceptionistidloginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtreceptionistidloginActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (!isLoggedIn) {
            new Login().setVisible(true);        // TODO add your handling code here:
        }        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void txtreceptionistidloginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtreceptionistidloginKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtreceptionistidlogin.setEditable(true);
            return;
        }
        if (!(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9')) {
            txtreceptionistidlogin.setEditable(false);
        } else {
            txtreceptionistidlogin.setEditable(true);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtreceptionistidloginKeyPressed

    private void txtpasswordreceptionistloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordreceptionistloginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpasswordreceptionistloginActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ReceptionistLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReceptionistLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReceptionistLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReceptionistLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReceptionistLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField txtpasswordreceptionistlogin;
    private javax.swing.JTextField txtreceptionistidlogin;
    // End of variables declaration//GEN-END:variables
}
