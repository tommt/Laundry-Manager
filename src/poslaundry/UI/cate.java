
package poslaundry.UI;

import db.Db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

 
public class cate extends javax.swing.JInternalFrame {
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
   
    public cate() throws Exception {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        conn = Db.java_db();
       tableUpdate();
    }
    
    private void tableUpdate(){
        try{
        String sql ="select * from category";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        CustomerTable.setModel(DbUtils.resultSetToTableModel(rs));
    }
    catch(Exception e){
//    JOptionPane.showMessageDialog(null, e);
    }
    finally {
            
            try{
                rs.close();
                pst.close();
                
            }
            catch(Exception e){
                
            }
        }}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtCategory = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        CustomerTable = new javax.swing.JTable();
        addCategory = new javax.swing.JButton();
        editCategory = new javax.swing.JButton();
        deletsCategory = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(760, 640));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.pink, java.awt.Color.red, java.awt.Color.black, java.awt.Color.orange), "Category", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI", 0, 18))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel7.setText("Category");

        txtCategory.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(273, 273, 273))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        CustomerTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.pink, java.awt.Color.red, java.awt.Color.black, java.awt.Color.orange));
        CustomerTable.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        CustomerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Category", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        CustomerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustomerTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(CustomerTable);

        addCategory.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        addCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        addCategory.setText("Add");
        addCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCategoryActionPerformed(evt);
            }
        });

        editCategory.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        editCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        editCategory.setText("Edit");
        editCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCategoryActionPerformed(evt);
            }
        });

        deletsCategory.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        deletsCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        deletsCategory.setText("Delete");
        deletsCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletsCategoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addCategory)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editCategory)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deletsCategory)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deletsCategory)
                    .addComponent(editCategory)
                    .addComponent(addCategory))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addContainerGap())
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
        try {
            String category = txtCategory.getText();
           

            pst = conn.prepareStatement("insert into category (category) values (?)");
            pst.setString(1, category);
           
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Hooray! Category Added");
            txtCategory.setText(null);
            
            txtCategory.requestFocus();
        } catch (SQLException ex) {
            Logger.getLogger(cate.class.getName()).log(Level.SEVERE, null, ex);
        }
        tableUpdate();
    }//GEN-LAST:event_addCategoryActionPerformed

    private void editCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCategoryActionPerformed
        try {
            DefaultTableModel d1 = (DefaultTableModel) CustomerTable.getModel();

            int selectIndex = CustomerTable.getSelectedRow();
            int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());

            String category = txtCategory.getText();
            

            pst = conn.prepareStatement("update category set category=? where id=?");
            pst.setString(1, category);
          
            pst.setInt(2, id);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Hooray! Category updated");

        } catch (SQLException ex) {
            Logger.getLogger(cate.class.getName()).log(Level.SEVERE, null, ex);
        }
        tableUpdate();
        txtCategory.setText(null);
        
        txtCategory.requestFocus();
    }//GEN-LAST:event_editCategoryActionPerformed

    private void deletsCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletsCategoryActionPerformed
        DefaultTableModel d1 = (DefaultTableModel) CustomerTable.getModel();

        int selectIndex = CustomerTable.getSelectedRow();
        int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
        int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to delet the Record","warning",JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            try {
                pst = conn.prepareStatement("delete from category where id=?");
                pst.setInt(1, id);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Hooray! Category Deleted");
                tableUpdate();
                txtCategory.setText(null);
                
                txtCategory.requestFocus();
            } catch (SQLException ex) {
                Logger.getLogger(cate.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_deletsCategoryActionPerformed

    private void CustomerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomerTableMouseClicked
        DefaultTableModel d1 = (DefaultTableModel) CustomerTable.getModel();

        int selectIndex = CustomerTable.getSelectedRow();
        txtCategory.setText(d1.getValueAt(selectIndex, 1).toString());
        

    }//GEN-LAST:event_CustomerTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CustomerTable;
    private javax.swing.JButton addCategory;
    private javax.swing.JButton deletsCategory;
    private javax.swing.JButton editCategory;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCategory;
    // End of variables declaration//GEN-END:variables
}
