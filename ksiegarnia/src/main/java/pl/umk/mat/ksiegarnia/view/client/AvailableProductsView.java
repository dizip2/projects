/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.umk.mat.ksiegarnia.view.client;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

import pl.umk.mat.ksiegarnia.model.book.BookInformation;
import pl.umk.mat.ksiegarnia.view.services.ServicesView;

/**
 *
 * @author Mariusz
 */
public class AvailableProductsView extends ServicesView {

    /**
     * Creates new form MyBasket
     */

    public AvailableProductsView() {
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

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableBasket = new javax.swing.JTable();
        lMessage = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lSum = new javax.swing.JLabel();
        mainMenu = new javax.swing.JButton();
        addToBasket = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 530));
        getContentPane().setLayout(null);

        tableBasket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tytuł", "Autor", "Wydawnictwo", "Data Wydania", "Cena", "Zaznacz"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableBasket);
        if (tableBasket.getColumnModel().getColumnCount() > 0) {
            tableBasket.getColumnModel().getColumn(0).setResizable(false);
            tableBasket.getColumnModel().getColumn(0).setPreferredWidth(5);
            tableBasket.getColumnModel().getColumn(1).setResizable(false);
            tableBasket.getColumnModel().getColumn(2).setResizable(false);
            tableBasket.getColumnModel().getColumn(3).setResizable(false);
            tableBasket.getColumnModel().getColumn(4).setResizable(false);
            tableBasket.getColumnModel().getColumn(5).setResizable(false);
            tableBasket.getColumnModel().getColumn(5).setPreferredWidth(5);
            tableBasket.getColumnModel().getColumn(6).setResizable(false);
            tableBasket.getColumnModel().getColumn(6).setPreferredWidth(5);
        }

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(20, 70, 850, 340);

        lMessage.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(lMessage);
        lMessage.setBounds(20, 380, 480, 18);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Suma:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(550, 380, 42, 18);

        lSum.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(lSum);
        lSum.setBounds(600, 380, 68, 18);

        mainMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ksiegarnia/img/PrzyciskMenuGłówne.gif"))); // NOI18N
        mainMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mainMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mainMenuMouseExited(evt);
            }
        });
        getContentPane().add(mainMenu);
        mainMenu.setBounds(30, 420, 150, 40);

        addToBasket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ksiegarnia/img/PrzyciskDodaj.png"))); // NOI18N
        addToBasket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addToBasketMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addToBasketMouseExited(evt);
            }
        });
        getContentPane().add(addToBasket);
        addToBasket.setBounds(710, 420, 150, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ksiegarnia/img/DostepneProduktyTlo.gif"))); // NOI18N
        jLabel3.setPreferredSize(new java.awt.Dimension(900, 530));
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, -10, 900, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mainMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainMenuMouseEntered
        mainMenu.setIcon(new ImageIcon(getClass().getResource("/ksiegarnia/img/PrzyciskMenuGłówneClick.gif")));
    }//GEN-LAST:event_mainMenuMouseEntered

    private void addToBasketMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addToBasketMouseEntered
        addToBasket.setIcon(new ImageIcon(getClass().getResource("/ksiegarnia/img/PrzyciskDodajClick.gif")));
    }//GEN-LAST:event_addToBasketMouseEntered

    private void mainMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainMenuMouseExited
        mainMenu.setIcon(new ImageIcon(getClass().getResource("/ksiegarnia/img/PrzyciskMenuGłówne.gif")));
    }//GEN-LAST:event_mainMenuMouseExited

    private void addToBasketMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addToBasketMouseExited
        addToBasket.setIcon(new ImageIcon(getClass().getResource("/ksiegarnia/img/PrzyciskDodaj.png")));
    }//GEN-LAST:event_addToBasketMouseExited
    

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
            java.util.logging.Logger.getLogger(AvailableProductsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AvailableProductsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AvailableProductsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AvailableProductsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AvailableProductsView().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToBasket;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lMessage;
    private javax.swing.JLabel lSum;
    private javax.swing.JButton mainMenu;
    private javax.swing.JTable tableBasket;
    // End of variables declaration//GEN-END:variables
    
    /**
     *  @return Array List with ids of selected book from table
     */
    public ArrayList<Integer> getSelectedBooks()
    {
    	ArrayList<Integer> allSelected = new ArrayList<Integer>();
    	
    	DefaultTableModel model = (DefaultTableModel) tableBasket.getModel();
    	for (int i = 0; i < tableBasket.getModel().getRowCount(); i++) {
    		Boolean checked = (Boolean) model.getValueAt(i, 6);
    		if (checked != null && checked) {
    			int idBook = (int) model.getValueAt(i, 0);
    			allSelected.add(idBook);
    		}
    	}
    	return allSelected; 	
    }
    /**
     * sets listener on button
     * @param listener
     */
    public void setAddToBasketActionListener(ActionListener listener)
    {
    	addToBasket.addActionListener(listener);
    }
    /**
     * sets listener on button
     * @param listener
     */
    public void setMainMenuActionListener(ActionListener listener)
    {
    	mainMenu.addActionListener(listener);
    }
    
    /**
     * shows the filled table of available books
     * @param ArraList<BookInformation> 
     */

    public void showTable(ArrayList<BookInformation> allBooks ) {
        float sum = (float) 0.00;
        
        DefaultTableModel model = (DefaultTableModel) tableBasket.getModel();
        allBooks.stream().forEach((curBook) -> {
            model.addRow(new Object[]{curBook.getID(),curBook.getTitle(), curBook.getAuthor(),curBook.getPH(),curBook.getDate(), curBook.getPrice()});
        });
        lSum.setText(String.valueOf(sum) + "zl");
        tableBasket.getModel().addTableModelListener((TableModelEvent e) -> {
            float sum1 = (float) 0.0;
            for (int i = 0; i < tableBasket.getModel().getRowCount(); i++) {
                Boolean checked = (Boolean) model.getValueAt(i, 6);
                if (checked != null && checked) {
                    sum1 += (float) model.getValueAt(i, 5);
                }
            }
            lSum.setText(String.valueOf(sum1) + "zl");
        });
    }
}
