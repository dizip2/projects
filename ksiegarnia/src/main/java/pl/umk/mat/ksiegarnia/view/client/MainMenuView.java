/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.umk.mat.ksiegarnia.view.client;

import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import pl.umk.mat.ksiegarnia.view.services.ServicesView;

/**
 *
 * @author Mariusz
 */
public class MainMenuView extends ServicesView {

    /**
     * Creates new form NewJFrame1
     */
    public MainMenuView(){
        initComponents();
        initView();
        
    }
    public void initView()
    {
        buyBooks.setVisible(false);buyBooksNone.setVisible(true);myBacket.setVisible(false);myBacketNone.setVisible(true);editInfo.setVisible(false);editInfoNone.setVisible(true);myOrders.setVisible(false); myOrdersNone.setVisible(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buyBooksNone = new javax.swing.JLabel();
        buyBooks = new javax.swing.JLabel();
        myBacket = new javax.swing.JLabel();
        myBacketNone = new javax.swing.JLabel();
        editInfo = new javax.swing.JLabel();
        editInfoNone = new javax.swing.JLabel();
        myOrders = new javax.swing.JLabel();
        myOrdersNone = new javax.swing.JLabel();
        logOut = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(920, 525));
        getContentPane().setLayout(null);

        buyBooksNone.setMinimumSize(new java.awt.Dimension(170, 0));
        buyBooksNone.setPreferredSize(new java.awt.Dimension(235, 183));
        buyBooksNone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buyBooksNoneMouseEntered(evt);
            }
        });
        getContentPane().add(buyBooksNone);
        buyBooksNone.setBounds(20, 220, 235, 183);

        buyBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ksiegarnia/img/przycisk1gif.gif"))); // NOI18N
        buyBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buyBooksMouseExited(evt);
            }
        });
        getContentPane().add(buyBooks);
        buyBooks.setBounds(20, 220, 235, 183);

        myBacket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ksiegarnia/img/przycisk3gif.gif"))); // NOI18N
        myBacket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                myBacketMouseExited(evt);
            }
        });
        getContentPane().add(myBacket);
        myBacket.setBounds(460, 220, 214, 189);

        myBacketNone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                myBacketNoneMouseEntered(evt);
            }
        });
        getContentPane().add(myBacketNone);
        myBacketNone.setBounds(460, 210, 214, 189);

        editInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ksiegarnia/img/przycisk2GIF.gif"))); // NOI18N
        editInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editInfoMouseExited(evt);
            }
        });
        getContentPane().add(editInfo);
        editInfo.setBounds(250, 220, 231, 185);

        editInfoNone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editInfoNoneMouseEntered(evt);
            }
        });
        getContentPane().add(editInfoNone);
        editInfoNone.setBounds(240, 220, 231, 185);

        myOrders.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ksiegarnia/img/przycisk4gif.gif"))); // NOI18N
        myOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                myOrdersMouseExited(evt);
            }
        });
        getContentPane().add(myOrders);
        myOrders.setBounds(670, 210, 226, 209);

        myOrdersNone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                myOrdersNoneMouseEntered(evt);
            }
        });
        getContentPane().add(myOrdersNone);
        myOrdersNone.setBounds(670, 220, 226, 209);

        logOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ksiegarnia/img/PrzyciskWyloguj.gif"))); // NOI18N
        logOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logOutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logOutMouseExited(evt);
            }
        });
        getContentPane().add(logOut);
        logOut.setBounds(780, 0, 120, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ksiegarnia/img/tło_menu.jpeg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 900, 500);
        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buyBooksNoneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buyBooksNoneMouseEntered
        buyBooks.setVisible(true);buyBooksNone.setVisible(false);
    }//GEN-LAST:event_buyBooksNoneMouseEntered
    
    private void buyBooksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buyBooksMouseExited
        buyBooks.setVisible(false);buyBooksNone.setVisible(true);
    }//GEN-LAST:event_buyBooksMouseExited

    private void myBacketMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myBacketMouseExited
        myBacket.setVisible(false);myBacketNone.setVisible(true);
    }//GEN-LAST:event_myBacketMouseExited

    private void myBacketNoneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myBacketNoneMouseEntered
        myBacket.setVisible(true);myBacketNone.setVisible(false);
    }//GEN-LAST:event_myBacketNoneMouseEntered

    private void editInfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editInfoMouseExited
        editInfo.setVisible(false);editInfoNone.setVisible(true);
    }//GEN-LAST:event_editInfoMouseExited

    private void editInfoNoneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editInfoNoneMouseEntered
        editInfo.setVisible(true);editInfoNone.setVisible(false);
    }//GEN-LAST:event_editInfoNoneMouseEntered

    private void myOrdersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myOrdersMouseExited
        myOrders.setVisible(false);myOrdersNone.setVisible(true);
    }//GEN-LAST:event_myOrdersMouseExited

    private void myOrdersNoneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myOrdersNoneMouseEntered
        myOrders.setVisible(true);myOrdersNone.setVisible(false);
    }//GEN-LAST:event_myOrdersNoneMouseEntered

    private void logOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutMouseEntered
        logOut.setIcon(new ImageIcon(getClass().getResource("/ksiegarnia/img/PrzyciskWylogujClick.gif")));
    }//GEN-LAST:event_logOutMouseEntered

    private void logOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutMouseExited
        logOut.setIcon(new ImageIcon(getClass().getResource("/ksiegarnia/img/PrzyciskWyloguj.gif")));
    }//GEN-LAST:event_logOutMouseExited

    public void setLogOutActionListener(MouseAdapter listener)
    {
    	logOut.addMouseListener(listener);   
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
            java.util.logging.Logger.getLogger(MainMenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenuView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel buyBooks;
    private javax.swing.JLabel buyBooksNone;
    private javax.swing.JLabel editInfo;
    private javax.swing.JLabel editInfoNone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton logOut;
    private javax.swing.JLabel myBacket;
    private javax.swing.JLabel myBacketNone;
    private javax.swing.JLabel myOrders;
    private javax.swing.JLabel myOrdersNone;
    // End of variables declaration//GEN-END:variables

    /**
     * sets listener on button
     * @param listener
     */
	public void setBuyBooksActionListener(MouseAdapter listener)
    {
    	buyBooks.addMouseListener(listener);   
    }
	/**
     * sets listener on button
     * @param listener
     */
    public void setMyOrdersBooksActionListener(MouseAdapter listener)
    {
    	myOrders.addMouseListener(listener);   
    }
    /**
     * sets listener on button
     * @param listener
     */
    public void setEditInfoBooksActionListener(MouseAdapter listener)
    {
    	editInfo.addMouseListener(listener);   
    }
    /**
     * sets listener on button
     * @param listener
     */
    public void setMyBacketBooksActionListener(MouseAdapter listener)
    {
    	myBacket.addMouseListener(listener);   
    }
}
