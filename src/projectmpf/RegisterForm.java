/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmpf;

import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class RegisterForm extends javax.swing.JFrame {
    
    File fileGambar = new File("Assets\\exit.png");
    Image img;

    /**
     * Creates new form RegisterForm
     */
    public RegisterForm() {
        initComponents();
        
        try {
            img = ImageIO.read(fileGambar);
            
            Image resizedImage = img.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
            
            ImageIcon imgIcon = new ImageIcon(resizedImage);
            
            btnExit.setIcon(imgIcon);
        } catch (IOException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainForm = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Footer = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        ComponentForm = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        InnerComponent = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        txtConfirm = new javax.swing.JPasswordField();
        btnRegister = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Register");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        MainForm.setBackground(new java.awt.Color(236, 244, 190));
        MainForm.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(153, 153, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bluejack Market");
        jLabel1.setOpaque(true);
        MainForm.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        Footer.setOpaque(false);
        Footer.setLayout(new java.awt.BorderLayout());

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        btnExit.setBackground(new java.awt.Color(236, 244, 190));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });
        jPanel1.add(btnExit, java.awt.BorderLayout.CENTER);

        Footer.add(jPanel1, java.awt.BorderLayout.EAST);

        MainForm.add(Footer, java.awt.BorderLayout.PAGE_END);

        ComponentForm.setOpaque(false);
        ComponentForm.setLayout(new java.awt.BorderLayout());

        btnBack.setText("Back");
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
        });
        ComponentForm.add(btnBack, java.awt.BorderLayout.PAGE_END);

        InnerComponent.setOpaque(false);
        InnerComponent.setLayout(new java.awt.GridLayout(4, 2));

        jLabel2.setText("Username :");
        InnerComponent.add(jLabel2);
        InnerComponent.add(txtUsername);

        jLabel3.setText("Password :");
        InnerComponent.add(jLabel3);
        InnerComponent.add(txtPassword);

        jLabel4.setText("Confirm Password :");
        InnerComponent.add(jLabel4);
        InnerComponent.add(txtConfirm);

        btnRegister.setText("Register");
        btnRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegisterMouseClicked(evt);
            }
        });
        InnerComponent.add(btnRegister);

        btnReset.setText("Reset");
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
        });
        InnerComponent.add(btnReset);

        ComponentForm.add(InnerComponent, java.awt.BorderLayout.CENTER);

        MainForm.add(ComponentForm, java.awt.BorderLayout.CENTER);

        getContentPane().add(MainForm, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterMouseClicked
        // TODO add your handling code here:
        if (txtUsername.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username must be filled!");
        }
        else if (txtPassword.getText().isEmpty()) { 
            JOptionPane.showMessageDialog(null, "Password must be filled!");
        }
        else if(!isAlphanumeric(txtPassword.getText()))
        {
            JOptionPane.showMessageDialog(null, "Password must be alphanumeric!");
        }
        else if(!txtConfirm.getText().equals(txtPassword.getText()))
        {
             JOptionPane.showMessageDialog(null, "Confirm Password must be filled!");
        }
        else
        {
            String username = txtUsername.getText();
            String password = String.valueOf(txtPassword.getText());
            boolean isExist = false;

            for(int i=0;i<UserList.username.size();i++)
            {
                if(UserList.username.get(i).equals(username)){
                    JOptionPane.showMessageDialog(null, "Username exists!");
                    isExist = true;
                    break;
                }
            }
        
            if(isExist == false)
            {
                    UserList.username.add(username);
                    UserList.password.add(password);
                    new LoginForm().setVisible(true);
                    this.dispose();
            }
        }
    }//GEN-LAST:event_btnRegisterMouseClicked

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        // TODO add your handling code here:
        txtUsername.setText("");
        txtPassword.setText("");
        txtConfirm.setText("");
    }//GEN-LAST:event_btnResetMouseClicked

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        // TODO add your handling code here:
        new LoginForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackMouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnExitMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        setExtendedState(MAXIMIZED_BOTH);
    }//GEN-LAST:event_formWindowOpened
    
    public boolean isAlphanumeric(String password) 
    {   
        boolean isDigit = false;
        boolean isAlpha = false;
        for (char ch : password.toCharArray()) 
        {
          if (Character.isDigit(ch)) 
          {
            isDigit = true;
          }
          if (Character.isLetter(ch)) 
          {
            isAlpha = true;
          }
          if (isAlpha && isDigit) 
          {   
            return true;
          }
        }        
        return false;
    }
    
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
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterForm().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ComponentForm;
    private javax.swing.JPanel Footer;
    private javax.swing.JPanel InnerComponent;
    private javax.swing.JPanel MainForm;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtConfirm;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
