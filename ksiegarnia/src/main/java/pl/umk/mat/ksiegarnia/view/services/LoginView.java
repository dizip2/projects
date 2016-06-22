/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.umk.mat.ksiegarnia.view.services;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import pl.umk.mat.ksiegarnia.app.Ksiegarnia;
import pl.umk.mat.ksiegarnia.model.SQLUserServices;


/**
 *
 * @author Mariusz
 */
public class LoginView extends ServicesView {
    
    public LoginView() {
        initComponents();       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginInput = new javax.swing.JTextField();
        NewUser = new javax.swing.JLabel();
        logButton = new javax.swing.JButton();
        clearInput = new javax.swing.JButton();
        PassInput = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(null);
        getContentPane().add(loginInput);
        loginInput.setBounds(150, 180, 250, 37);

        NewUser.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NewUser.setForeground(new java.awt.Color(0, 51, 255));
        NewUser.setText("Nowy użytkownik ( Rejestracja )");
        getContentPane().add(NewUser);
        NewUser.setBounds(270, 90, 177, 20);

        logButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ksiegarnia/img/PrzyciskZaloguj2.gif"))); // NOI18N
        logButton.setFocusable(false);
        logButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logButtonMouseExited(evt);
            }
        });
        getContentPane().add(logButton);
        logButton.setBounds(110, 290, 140, 40);

        clearInput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ksiegarnia/img/PrzyciskWyczysc2.gif"))); // NOI18N
        clearInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clearInputMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clearInputMouseExited(evt);
            }
        });
        getContentPane().add(clearInput);
        clearInput.setBounds(300, 290, 140, 40);
        getContentPane().add(PassInput);
        PassInput.setBounds(150, 240, 250, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ksiegarnia/img/tło_logowanie.gif"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-10, 0, 900, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logButtonMouseEntered
        logButton.setIcon(new ImageIcon(getClass().getResource("/ksiegarnia/img/PrzyciskZalogujClick2.gif")));  
    }//GEN-LAST:event_logButtonMouseEntered

    private void clearInputMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearInputMouseEntered
        clearInput.setIcon(new ImageIcon(getClass().getResource("/ksiegarnia/img/PrzyciskWyczyscClick2.gif")));
    }//GEN-LAST:event_clearInputMouseEntered


    private void logButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logButtonMouseExited
        logButton.setIcon(new ImageIcon(getClass().getResource("/ksiegarnia/img/PrzyciskZaloguj2.gif")));
    }//GEN-LAST:event_logButtonMouseExited

    private void clearInputMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearInputMouseExited
        clearInput.setIcon(new ImageIcon(getClass().getResource("/ksiegarnia/img/PrzyciskWyczysc2.gif")));
    }//GEN-LAST:event_clearInputMouseExited


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
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NewUser;
    private javax.swing.JPasswordField PassInput;
    private javax.swing.JButton clearInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton logButton;
    private javax.swing.JTextField loginInput;
    // End of variables declaration//GEN-END:variables
    
    /**
     * sets listener on button
     * @param listener
     */
    public void setLogButtonActionListener(ActionListener listener)
    {
    	logButton.addActionListener(listener);
    }
    /**
     * sets listener on button
     * @param listener
     */
    public void setClearInputnActionListener(ActionListener listener)
    {
    	clearInput.addActionListener(listener);
    }
    /**
     * sets listener on button
     * @param listener
     */
    public void setNewUserActionListener(MouseAdapter listener)
    {
    	NewUser.addMouseListener(listener);   
    }
    /**
     * clears all fields in view
     */
    public void clearAllInput()
    {
    	loginInput.setText("");
    	PassInput.setText("");
    }
    /**
     * 
     * @return user login from fields in view
     */
    public String getLoginInput()
    {
    	return loginInput.getText();
    }
    /**
     * 
     * @return user password from fields in view
     */
    public String getPassInput()
    {
    	return PassInput.getText();
    }
}
