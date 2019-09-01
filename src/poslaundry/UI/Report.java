package poslaundry.UI;

import db.Db;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.TableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

    
public class Report extends javax.swing.JInternalFrame {
    PreparedStatement pst = null;
    ResultSet rs = null;
    Connection conn;
   
    public Report() throws SQLException, Exception {
        initComponents();
        conn = Db.java_db();
        stockData();

        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
    }
    private void writetoExcelStock(){
         TableModel dm= stockReportTable.getModel();
         XSSFWorkbook wb = new XSSFWorkbook();
         XSSFSheet ws = wb.createSheet();
         
         // LOAD DATA
         TreeMap<String, Object[]> data = new TreeMap<>();
         data.put("-1", new Object[]{dm.getColumnName(0), 
             dm.getColumnName(1), 
             dm.getColumnName(2),dm.getColumnName(3),
             dm.getColumnName(4),dm.getColumnName(5),
             dm.getColumnName(6),
             dm.getColumnName(7),dm.getColumnName(8), dm.getColumnName(9),
             dm.getColumnName(10),} );
         
         //ADD Rows and cells
         
         for(int i=0; i<dm.getRowCount(); i++){
             data.put(Integer.toString(i), new Object[]{getCellValue(i, 0),getCellValue(i, 1),getCellValue(i, 2), getCellValue(i, 3),
             getCellValue(i, 4), getCellValue(i, 5),getCellValue(i, 6),getCellValue(i, 7),getCellValue(i, 8),getCellValue(i, 9),
             getCellValue(i, 10)});
         }
        // Write to exel file
         Set<String> ids=data.keySet();
         XSSFRow row;
         int rowID=0;
         
         for(String key: ids)
         {
             row = ws.createRow(rowID++);
             
             //Get data as per key
             Object[] values = data.get(key);
             int cellID=0;
             for(Object o: values){
             Cell cell = row.createCell(cellID++);
             cell.setCellValue(o.toString());
         }
         }
         //Write to file system
         try {
             String filename = "\\Documents\\Laundry\\sales.xls";
            File file = new File(System.getProperty("user.home"),filename);
            file.getParentFile().mkdir();
            file.createNewFile();

            FileOutputStream fos = new FileOutputStream(file) ;
                
                wb.write(fos);
                JOptionPane.showMessageDialog(rootPane, "Hooray Exported successfully!!");
            
        } catch (IOException | HeadlessException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    
    private String getCellValue(int x, int y){
         TableModel dm= stockReportTable.getModel();
        return dm.getValueAt(x, y).toString();
    
    }
    
    private void stockData() throws SQLException{
         String table = "SELECT `Product_Code`, `Product_Name`, `Qty`, `Price`, `Weight`, `Sub_Total`,`Discount`, `Total`, `Date`, `CID`, `Customer_Name`  FROM `invoice` ";
        pst = conn.prepareStatement(table);
        rs = pst.executeQuery();
        stockReportTable.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
    }   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        StockProcess = new javax.swing.JButton();
        fDate = new com.toedter.calendar.JDateChooser();
        tDate = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        stockReportTable = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setTitle("Report");
        setPreferredSize(new java.awt.Dimension(989, 611));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1380, 660));
        jPanel1.setPreferredSize(new java.awt.Dimension(1436, 754));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel6.setPreferredSize(new java.awt.Dimension(1270, 801));

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        jLabel9.setText("Sales");

        StockProcess.setBackground(new java.awt.Color(255, 255, 255));
        StockProcess.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        StockProcess.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/process.png"))); // NOI18N
        StockProcess.setText("Process");
        StockProcess.setBorder(null);
        StockProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StockProcessActionPerformed(evt);
            }
        });

        fDate.setDateFormatString("yyyy-MM-dd");
        fDate.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N

        tDate.setDateFormatString("yyyy-MM-dd");
        tDate.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel15.setText("From");

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel16.setText("To");

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/export.png"))); // NOI18N
        jButton9.setText("Export");
        jButton9.setBorder(null);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/process.png"))); // NOI18N
        jButton10.setText("Clear");
        jButton10.setBorder(null);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.pink, java.awt.Color.red, java.awt.Color.black, java.awt.Color.orange));

        stockReportTable.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        stockReportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        stockReportTable.setRowHeight(30);
        stockReportTable.setRowMargin(5);
        jScrollPane3.setViewportView(stockReportTable);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                            .addComponent(fDate, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tDate, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addGap(146, 146, 146)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(StockProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(198, 198, 198))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel9)
                .addGap(42, 42, 42)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StockProcess)
                    .addComponent(jButton9)
                    .addComponent(jButton10))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 790, 660));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-200, 0, 1000, 1020));
        jPanel1.getAccessibleContext().setAccessibleName("");

        setSize(new java.awt.Dimension(760, 640));
    }// </editor-fold>//GEN-END:initComponents

    private void StockProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StockProcessActionPerformed
        String saleFDate = ((JTextField)fDate.getDateEditor().getUiComponent()).getText();
        String saleTDate = ((JTextField)tDate.getDateEditor().getUiComponent()).getText();
        if(saleFDate.length() > 0  && saleTDate.isEmpty()){
             
            try {
                String table = "SELECT `Product_Code`, `Product_Name`, `Qty`, `Price`, `Weight`, `Sub_Total`,`Discount`, `Total`, `Date`, `CID`, `Customer_Name` FROM `invoice` WHERE Date='"+saleFDate+"' ";
                pst = conn.prepareStatement(table);
                rs = pst.executeQuery(); 
                stockReportTable.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
            } catch (SQLException ex) {
                Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, ex);
            }
            
        } else if(saleFDate.length()>0 && saleTDate.length()>0){
        
            
            try {
                String table = "SELECT `Product_Code`, `Product_Name`, `Qty`, `Price`, `Weight`, `Sub_Total`,`Discount`, `Total`, `Date`, `CID`, `Customer_Name`  FROM `invoice` WHERE Date between '"+saleFDate+"'and '"+saleTDate+"' ";
                pst = conn.prepareStatement(table);
                rs = pst.executeQuery(); 
                stockReportTable.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
            } catch (SQLException ex) {
                Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, ex);
            }
            
        
        }else {
            JOptionPane.showMessageDialog(rootPane, "Please Select Date");
        }
    }//GEN-LAST:event_StockProcessActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        
        writetoExcelStock();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        try {
             ((JTextField)fDate.getDateEditor().getUiComponent()).setText("");
            ((JTextField)tDate.getDateEditor().getUiComponent()).setText("");
            stockData();
           
        } catch (SQLException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton10ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton StockProcess;
    private com.toedter.calendar.JDateChooser fDate;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable stockReportTable;
    private com.toedter.calendar.JDateChooser tDate;
    // End of variables declaration//GEN-END:variables
}
