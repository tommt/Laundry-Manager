
package poslaundry.UI;

import db.Db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

 
public class coynt extends javax.swing.JInternalFrame {
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
   DefaultTableModel model = new  DefaultTableModel();
    public coynt() throws Exception {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        conn = Db.java_db();
//       tableUpdate();
    }
    
    private void tableUpdate(){
     
        String category = txtCategory.getText();
        if(txtCategory.getText().length() >0){
        
        try {
            String table = "SELECT `Customer_Name`,`category`, `qty`  FROM `premium` where category LIKE  '%"+category+"%' ";
            pst = conn.prepareStatement(table);
            rs = pst.executeQuery();
            premiumTable.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            Logger.getLogger(coynt.class.getName()).log(Level.SEVERE, null, ex);
            {
            }
            }
        }else{
        }    
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Stocks = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtCategory = new javax.swing.JTextField();
        addCategory = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        qtu = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        premiumTable = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Stocks.setBackground(new java.awt.Color(255, 255, 255));
        Stocks.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.pink, java.awt.Color.red, java.awt.Color.black, java.awt.Color.orange), "Category", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI", 0, 18))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel7.setText("Category");

        txtCategory.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txtCategory.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCategoryKeyReleased(evt);
            }
        });

        addCategory.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        addCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/count.png"))); // NOI18N
        addCategory.setText("Count");
        addCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCategoryActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel9.setText("Qty");

        qtu.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout StocksLayout = new javax.swing.GroupLayout(Stocks);
        Stocks.setLayout(StocksLayout);
        StocksLayout.setHorizontalGroup(
            StocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StocksLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(StocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(StocksLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addCategory))
                    .addGroup(StocksLayout.createSequentialGroup()
                        .addGroup(StocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addGroup(StocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCategory, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(qtu))))
                .addContainerGap(386, Short.MAX_VALUE))
        );
        StocksLayout.setVerticalGroup(
            StocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StocksLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(StocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(StocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(qtu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(addCategory)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));

        premiumTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.pink, java.awt.Color.red, java.awt.Color.black, java.awt.Color.orange));
        premiumTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        premiumTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                premiumTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(premiumTable);

        jScrollPane3.setViewportView(jScrollPane2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Stocks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Stocks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCategoryActionPerformed
        model = (DefaultTableModel)premiumTable.getModel();
            int sum = 0;
                for(int i=0; i<premiumTable.getRowCount(); i++){
                    sum =  (sum + Integer.parseInt(premiumTable.getValueAt((int) i, 2).toString()));
                }
                qtu.setText(Integer.toString(sum));
    }//GEN-LAST:event_addCategoryActionPerformed

    private void premiumTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_premiumTableMouseClicked
        DefaultTableModel d1 = (DefaultTableModel) premiumTable.getModel();

        int selectIndex = premiumTable.getSelectedRow();
       

    }//GEN-LAST:event_premiumTableMouseClicked

    private void txtCategoryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCategoryKeyReleased
        tableUpdate();
    }//GEN-LAST:event_txtCategoryKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Stocks;
    private javax.swing.JButton addCategory;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable premiumTable;
    private javax.swing.JTextField qtu;
    private javax.swing.JTextField txtCategory;
    // End of variables declaration//GEN-END:variables
}
