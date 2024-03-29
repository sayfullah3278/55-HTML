/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class NewFrone10 extends javax.swing.JFrame {
    DddCon con=new DddCon();
    PreparedStatement ps;
    String sql="";
    ResultSet rs;
    
    
    
    public NewFrone10() {
        initComponents();
        getAllStuInfo();
    }
    
    public  java.sql.Date convertUtlToSql(java.util.Date utilDate){
        if(utilDate!=null){
        return new java.sql.Date(utilDate.getTime());
        }
    return null;
    }
    
    public void getAllStuInfo(){
    String[] columnse={"id","name","role","gender","subject","date"};
        DefaultTableModel mod=new DefaultTableModel();
        mod.setColumnIdentifiers(columnse);
        
        tblStudent.setModel(mod);
        
        sql="select * from studentinfo";
        
        try {
            ps=con.getcon().prepareStatement(sql);
            
            rs=ps.executeQuery();
            
            while(rs.next()){
            int id=rs.getInt("Id");
            String name=rs.getString("name");
            String role=rs.getString("rolenumber");
            String gender=rs.getString("gender");
            String sub=rs.getString("subject");
            Date date=rs.getDate("date");
            
            
            mod.addRow(new Object[] {id,name,role,gender,sub,date});
//             model.addRow(new Object[]{id, name,email,subject,gender,date});
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewFrone10.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void updateStudent(){
    String gender="";
    
    if(radiomale.isSelected()){
    gender="Male";
    }
    else if(radiofemale.isSelected()){
    gender="Femal";
    }
    
    sql="update studentinfo set name=?,rolenumber=?,gender=?,subject=?,date=? where Id=?";
    
        try {
            ps=con.getcon().prepareStatement(sql);
            
             ps.setString(1,txtname.getText().trim());
            ps.setString(2, txtrole.getText().trim());
            ps.setString(3, gender);
            ps.setString(4, comSub.getSelectedItem().toString());
            ps.setDate(5,convertUtlToSql(dateDob.getDate()));
            ps.setInt(6, Integer.parseInt(txtid.getText().trim()));
            
            ps.executeUpdate();
            ps.close();
           
            JOptionPane.showMessageDialog(rootPane, "data update");
            getAllStuInfo();
            
        } catch (SQLException ex) {
            Logger.getLogger(NewFrone10.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void resat(){
    txtid.setText(null);
    txtname.setText(null);
    txtrole.setText(null);
    buttonGroup1.clearSelection();
    comSub.setSelectedIndex(0);
    dateDob.setDate(null);
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtrole = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        radiomale = new javax.swing.JRadioButton();
        radiofemale = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        comSub = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        dateDob = new com.toedter.calendar.JDateChooser();
        btnsave = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnresat = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudent = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome to JEE & CCSL");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 60));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("ID");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 90, 30));
        jPanel2.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 160, 30));
        jPanel2.add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 160, 30));

        jLabel3.setText("Name");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 90, 30));
        jPanel2.add(txtrole, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 160, 30));

        jLabel4.setText("Role");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 90, 30));

        jLabel5.setText("Gender");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 90, 30));

        buttonGroup1.add(radiomale);
        radiomale.setText("Male");
        jPanel2.add(radiomale, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, -1));

        buttonGroup1.add(radiofemale);
        radiofemale.setText("Female");
        jPanel2.add(radiofemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, -1, -1));

        jLabel6.setText("Subject");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 70, 40));

        comSub.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Sub--", "JEE", "CSS", "DDD", "HTML", "C#", "CADE", " " }));
        jPanel2.add(comSub, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 180, 30));

        jLabel7.setText("Date");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 70, 30));
        jPanel2.add(dateDob, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 190, 30));

        btnsave.setText("save");
        btnsave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsaveMouseClicked(evt);
            }
        });
        jPanel2.add(btnsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 293, 80, 30));

        btnupdate.setText("update");
        btnupdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnupdateMouseClicked(evt);
            }
        });
        jPanel2.add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 293, 90, 30));

        btndelete.setText("Delete");
        btndelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btndeleteMouseClicked(evt);
            }
        });
        jPanel2.add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 363, 80, 30));

        btnresat.setText("Resat");
        btnresat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnresatMouseClicked(evt);
            }
        });
        jPanel2.add(btnresat, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 363, 80, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 310, 460));

        tblStudent.setModel(new javax.swing.table.DefaultTableModel(
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
        tblStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStudent);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 320, 390));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Srudent info Tabil");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 290, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsaveMouseClicked
        // TODO add your handling code here:
        sql="insert into studentinfo(name,rolenumber,gender,subject,date)values(?,?,?,?,?)";
        String gender="";
        
        if(radiomale.isSelected()){
        gender="Male";
        }
        else if(radiofemale.isSelected()){
        gender="Female";
        }
        
        try {
            ps=con.getcon().prepareStatement(sql);
            
            ps.setString(1,txtname.getText().trim());
            ps.setString(2, txtrole.getText().trim());
            ps.setString(3, gender);
            ps.setString(4, comSub.getSelectedItem().toString());
            ps.setDate(5,convertUtlToSql(dateDob.getDate()));
            
            ps.executeUpdate();
            ps.close();
            con.getcon().close();
            JOptionPane.showMessageDialog(rootPane, "data saved");
            
            getAllStuInfo();
            
        } catch (SQLException ex) {
            Logger.getLogger(NewFrone10.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "data not save");
        }
        
    }//GEN-LAST:event_btnsaveMouseClicked

    private void btnupdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnupdateMouseClicked
        // TODO add your handling code here:
        updateStudent();
    }//GEN-LAST:event_btnupdateMouseClicked

    private void btndeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndeleteMouseClicked
        // TODO add your handling code here:
        sql="delete from studentinfo where Id=?";
        
        try {
            ps=con.getcon().prepareStatement(sql);
            
            ps.setInt(1, Integer.parseInt(txtid.getText().trim()));
            ps.executeUpdate();
            ps.close();
            con.getcon().close();
            
            JOptionPane.showMessageDialog(rootPane, "data is delete");
            getAllStuInfo();
        } catch (SQLException ex) {
            Logger.getLogger(NewFrone10.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(rootPane, "data is not delete");

        }
    }//GEN-LAST:event_btndeleteMouseClicked

    private void btnresatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnresatMouseClicked
        // TODO add your handling code here:
        resat();
    }//GEN-LAST:event_btnresatMouseClicked

    private void tblStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentMouseClicked
        // TODO add your handling code here:
      int row=tblStudent.getSelectedRow();
      
      String id=tblStudent.getModel().getValueAt(row, 0).toString();
      String name=tblStudent.getModel().getValueAt(row, 1).toString();
      String role=tblStudent.getModel().getValueAt(row, 2).toString();
      String gender=tblStudent.getModel().getValueAt(row, 3).toString();
      String subject=tblStudent.getModel().getValueAt(row, 4).toString();
      String date=tblStudent.getModel().getValueAt(row, 5).toString();  
      
      txtid.setText(id);
      txtname.setText(name);
      txtrole.setText(role);
      if(gender.equalsIgnoreCase("Male")){
      radiomale.setSelected(rootPaneCheckingEnabled);
      }
      else if(gender.equalsIgnoreCase("Female")){
      radiofemale.setSelected(rootPaneCheckingEnabled);
      }
    }//GEN-LAST:event_tblStudentMouseClicked

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
            java.util.logging.Logger.getLogger(NewFrone10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewFrone10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewFrone10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewFrone10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewFrone10().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnresat;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnupdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comSub;
    private com.toedter.calendar.JDateChooser dateDob;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radiofemale;
    private javax.swing.JRadioButton radiomale;
    private javax.swing.JTable tblStudent;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtrole;
    // End of variables declaration//GEN-END:variables
}
