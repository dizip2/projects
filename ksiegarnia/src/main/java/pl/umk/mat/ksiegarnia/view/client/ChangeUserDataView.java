/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.umk.mat.ksiegarnia.view.client;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;
import pl.umk.mat.ksiegarnia.model.Client;
import pl.umk.mat.ksiegarnia.model.SQLUserServices;
import pl.umk.mat.ksiegarnia.view.services.ServicesView;

/**
 *
 * @author Mariusz
 */
public class ChangeUserDataView extends ServicesView {
    
    public ChangeUserDataView()
    {
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

        nameUser = new javax.swing.JTextField();
        surnameUser = new javax.swing.JTextField();
        addressUser = new javax.swing.JTextField();
        phoneUser = new javax.swing.JTextField();
        registerUser = new javax.swing.JButton();
        cancelRegister = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(415, 520));
        getContentPane().setLayout(null);
        getContentPane().add(nameUser);
        nameUser.setBounds(200, 150, 144, 29);
        getContentPane().add(surnameUser);
        surnameUser.setBounds(200, 210, 144, 29);
        getContentPane().add(addressUser);
        addressUser.setBounds(200, 270, 144, 29);
        getContentPane().add(phoneUser);
        phoneUser.setBounds(200, 330, 144, 28);

        registerUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ksiegarnia/img/Potwierdź.gif"))); // NOI18N
        registerUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registerUserMouseExited(evt);
            }
        });
        getContentPane().add(registerUser);
        registerUser.setBounds(220, 400, 160, 30);

        cancelRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ksiegarnia/img/Anuluj.gif"))); // NOI18N
        cancelRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelRegisterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelRegisterMouseExited(evt);
            }
        });
        getContentPane().add(cancelRegister);
        cancelRegister.setBounds(30, 400, 160, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ksiegarnia/img/tlo_edytuj.gif"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 400, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void cancelRegisterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelRegisterMouseExited
        cancelRegister.setIcon(new ImageIcon(getClass().getResource("/ksiegarnia/img/Anuluj.gif")));
    }//GEN-LAST:event_cancelRegisterMouseExited

    private void registerUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerUserMouseExited
        registerUser.setIcon(new ImageIcon(getClass().getResource("/ksiegarnia/img/Potwierdź.gif")));
    }//GEN-LAST:event_registerUserMouseExited

    private void cancelRegisterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelRegisterMouseEntered
        cancelRegister.setIcon(new ImageIcon(getClass().getResource("/ksiegarnia/img/AnulujClick.gif")));        
    }//GEN-LAST:event_cancelRegisterMouseEntered

    private void registerUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerUserMouseEntered
        registerUser.setIcon(new ImageIcon(getClass().getResource("/ksiegarnia/img/ZarejestrujClick.gif")));
    }//GEN-LAST:event_registerUserMouseEntered

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
            java.util.logging.Logger.getLogger(ChangeUserDataView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangeUserDataView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangeUserDataView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangeUserDataView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangeUserDataView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressUser;
    private javax.swing.JButton cancelRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField nameUser;
    private javax.swing.JTextField phoneUser;
    private javax.swing.JButton registerUser;
    private javax.swing.JTextField surnameUser;
    // End of variables declaration//GEN-END:variables
    
    /**
     * @return user name from field in view
     */
    public String getName()
    {
    	return nameUser.getText();
    }
    /**
     * @return user surname from field in view
     */
    public String getSurname()
    {
    	return surnameUser.getText();
    }
    /**
     * @return user address from field in view
     */
    public String getAdrdress()
    {
    	return addressUser.getText();
    }
    /**
     * @return user phone from field in view
     */
    public String getPhone()
    {
    	return phoneUser.getText();
    }
    /**
     * sets listener on button
     */
    public void setCancelRegisterActionListener(ActionListener listener)
    {
    	cancelRegister.addActionListener(listener);
    }
    /**
     * sets listener on button
     */
    public void setRegisterUserActionListener(ActionListener listener)
    {
    	registerUser.addActionListener(listener);
    }
}
