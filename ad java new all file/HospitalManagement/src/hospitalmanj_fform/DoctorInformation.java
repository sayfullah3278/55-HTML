/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hospitalmanj_fform;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SAIFULLAH
 */
public class DoctorInformation extends javax.swing.JFrame {

    DataBasseconnaction con=new DataBasseconnaction();
    PreparedStatement ps;
    String sql="";
    ResultSet rs;
    
    private FromtPage fromtPage;
    public DoctorInformation(FromtPage fromtPage) {
        initComponents();
        getAllDoctors();
        this.fromtPage=fromtPage;
        
        
         setLocationRelativeTo(null);
    }
    public java.sql.Date convertUtlToSql(java.util.Date utilDate){
    if(utilDate !=null){
    return new java.sql.Date(utilDate.getTime());
    }
    return null;
    }
    
    public static java.util.Date formatStringdateToUtilDate(String dateString) {
    SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
   
      try {
          return dateformat.parse(dateString);
      } catch (ParseException ex) {
          System.out.println("Date format wrong");
          Logger.getLogger(DoctorInformation.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
   
       
   }
 
   
    public void getAllDoctors(){
    String[] columnse={"id","name","password","qualifications","joiningDate","contactNo","gender","bloodGroup"};
    DefaultTableModel modleno1=new DefaultTableModel();
    modleno1.setColumnIdentifiers(columnse);
    
    tbldoclist.setModel(modleno1);
    
    sql="select * from doctorinformation";
    
        try {
            ps=con.getcom().prepareStatement(sql);
            
            rs=ps.executeQuery();
            
            while(rs.next()){
            int id= rs.getInt("id");
            String name=rs.getString("name");
            String password=rs.getString("password");
            String qualific=rs.getString("qualifications");
            Date jonDate=rs.getDate("joiningDate"); 
            String contact=rs.getString("contactNo");
            String gender=rs.getString("gender");
            String bloodgrp=rs.getString("bloodGroup");
            
            modleno1.addRow(new Object[]{id,name,password,qualific,jonDate,contact,gender,bloodgrp});
            }
        } catch (SQLException ex) {
            Logger.getLogger(DoctorInformation.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void updateDoctor(){
    String gender="";
    
    if(radiomale.isSelected()){
    gender="Male";
    }
    else if(radiofemale.isSelected()){
    gender="Female";
    }
    sql="update doctorinformation set name=?,password=?,qualifications=?,joiningDate=?,contactNo=?,gender=?,bloodGroup=? where id=?";
        try {
            ps=con.getcom().prepareStatement(sql);
            
            ps.setString(1, txtname.getText().trim());
            ps.setString(2, txtpassw.getText().trim());
            ps.setString(3, txtqualificatn.getText().trim());
            ps.setDate(4, convertUtlToSql(txtjondate.getDate()));
            ps.setString(5, txtcontact.getText().trim());
            ps.setString(6, gender);
            ps.setString(7, comboblood.getSelectedItem().toString());
            
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(rootPane, "data updated");
            getAllDoctors();
        } catch (SQLException ex) {
            Logger.getLogger(DoctorInformation.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public  void reset(){
    txtid.setText(null);
    txtname.setText(null);
    txtpassw.setText(null);
    txtqualificatn.setText(null);
    txtjondate.setDate(null);
    txtcontact.setText(null);
    buttonGroup1.clearSelection();
    comboblood.setSelectedIndex(0);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtqualificatn = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        txtpassw = new javax.swing.JTextField();
        btnadd = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btnremove = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtjondate = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtcontact = new javax.swing.JTextField();
        radiomale = new javax.swing.JRadioButton();
        radiofemale = new javax.swing.JRadioButton();
        comboblood = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbldoclist = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("HOSPITAL MANAGMENT SYSTEM");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 80));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 80));

        jPanel1.setBackground(new java.awt.Color(146, 242, 30));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 80, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 80, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Password");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 80, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Qualifications");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 80, 40));
        jPanel1.add(txtqualificatn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 260, 40));
        jPanel1.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 260, 40));
        jPanel1.add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 260, 40));
        jPanel1.add(txtpassw, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 260, 40));

        btnadd.setBackground(new java.awt.Color(51, 51, 0));
        btnadd.setForeground(new java.awt.Color(255, 255, 255));
        btnadd.setText("ADD");
        btnadd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnaddMouseClicked(evt);
            }
        });
        jPanel1.add(btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 90, 40));

        btnupdate.setBackground(new java.awt.Color(51, 51, 0));
        btnupdate.setForeground(new java.awt.Color(255, 255, 204));
        btnupdate.setText("UPDATE");
        btnupdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnupdateMouseClicked(evt);
            }
        });
        jPanel1.add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 90, 40));

        btnremove.setBackground(new java.awt.Color(51, 51, 0));
        btnremove.setForeground(new java.awt.Color(255, 255, 204));
        btnremove.setText("REMOVE");
        jPanel1.add(btnremove, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 470, 90, 40));

        btndelete.setBackground(new java.awt.Color(51, 51, 0));
        btndelete.setForeground(new java.awt.Color(255, 255, 255));
        btndelete.setText("DELETE");
        btndelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btndeleteMouseClicked(evt);
            }
        });
        jPanel1.add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, 90, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Date Of Joining");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 130, 40));
        jPanel1.add(txtjondate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 210, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Blood Group");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 100, 40));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Contact no");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, 40));
        jPanel1.add(txtcontact, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 260, 40));

        buttonGroup1.add(radiomale);
        radiomale.setText("Male");
        jPanel1.add(radiomale, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, -1, -1));

        buttonGroup1.add(radiofemale);
        radiofemale.setText("Female");
        jPanel1.add(radiofemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, -1, -1));

        comboblood.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "O+", "O-", "A+", "A-", "AB+", "AB-", "B+", "B-" }));
        jPanel1.add(comboblood, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 70, 40));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Gender");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 390, 520));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(87, 139, 41));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(82, 243, 82));
        jButton1.setText("HOME");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 220, 80));

        tbldoclist.setModel(new javax.swing.table.DefaultTableModel(
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
        tbldoclist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldoclistMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbldoclist);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 320));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 480, 520));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Dctors List");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 390, 50));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("MANAGE DOCTOR");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 180, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Doctor  Information");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 180, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
        fromtPage.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbldoclistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldoclistMouseClicked
        // TODO add your handling code here:
        
        int row=tbldoclist.getSelectedRow();
        
       String id=tbldoclist.getModel().getValueAt(row, 0).toString();
        String name=tbldoclist.getModel().getValueAt(row, 1).toString();
        String password=tbldoclist.getModel().getValueAt(row, 2).toString();
        String qualifications=tbldoclist.getModel().getValueAt(row, 3).toString();
        String joiningDate=tbldoclist.getModel().getValueAt(row, 4).toString();
        String contactNo=tbldoclist.getModel().getValueAt(row, 5).toString();
        String gender=tbldoclist.getModel().getValueAt(row, 6).toString();
        String bloodGrop=tbldoclist.getModel().getValueAt(row, 7).toString();
        
        txtid.setText(id);
        txtname.setText(name);
        txtpassw.setText(password);
        txtqualificatn.setText(qualifications);
        txtjondate.setDate(formatStringdateToUtilDate(joiningDate));
        txtcontact.setText(contactNo);
        if(gender.equalsIgnoreCase("Male")){
        radiomale.setSelected(rootPaneCheckingEnabled);
        }
        else if(gender.equalsIgnoreCase("Female")){
        radiofemale.setSelected(rootPaneCheckingEnabled);
        }
        comboblood.setSelectedItem(bloodGrop);
        
        
    }//GEN-LAST:event_tbldoclistMouseClicked

    private void btnaddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnaddMouseClicked
        // TODO add your handling code here:
        sql="insert into doctorinformation(name,password,qualifications,joiningDate,contactNo,gender,bloodGroup)values(?,?,?,?,?,?,?)";
        String gender="";
        
        if(radiomale.isSelected()){
        gender="Male";
        }
        else if(radiofemale.isSelected()){
        gender="Female";
        }
        
        try {
            ps=con.getcom().prepareStatement(sql);
            
            ps.setString(1,txtname.getText().trim());
            ps.setString(2, txtpassw.getText().trim());
            ps.setString(3, txtqualificatn.getText().trim());
            ps.setDate(4, convertUtlToSql(txtjondate.getDate()));
            ps.setString(5,txtcontact.getText().trim());
            ps.setString(6,gender);
            ps.setString(7,comboblood.getSelectedItem().toString());
            
            ps.executeUpdate();
            ps.close();
            con.getcom().close();
            
            JOptionPane.showMessageDialog(rootPane, "add data");
            getAllDoctors();
        } catch (SQLException ex) {
            Logger.getLogger(DoctorInformation.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, " data is not add");

        }
        
    }//GEN-LAST:event_btnaddMouseClicked

    private void btnupdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnupdateMouseClicked
        // TODO add your handling code here:
        updateDoctor();
    }//GEN-LAST:event_btnupdateMouseClicked

    private void btndeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndeleteMouseClicked
        // TODO add your handling code here:
        sql="delete from doctorinformation where id=?";
        
        try {
            ps=con.getcom().prepareStatement(sql);
            
            ps.setInt(1, Integer.parseInt(txtid.getText().trim()));
            ps.executeUpdate();
            ps.close();
            con.getcom().close();
            JOptionPane.showMessageDialog(rootPane, "data delete");
            getAllDoctors();
        } catch (SQLException ex) {
            Logger.getLogger(DoctorInformation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btndeleteMouseClicked

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
            java.util.logging.Logger.getLogger(DoctorInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoctorInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoctorInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoctorInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                 FromtPage fromtPage=new FromtPage();
                DoctorInformation doctorInformation=new DoctorInformation(fromtPage);
                doctorInformation.setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnremove;
    private javax.swing.JButton btnupdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comboblood;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton radiofemale;
    private javax.swing.JRadioButton radiomale;
    private javax.swing.JTable tbldoclist;
    private javax.swing.JTextField txtcontact;
    private javax.swing.JTextField txtid;
    private com.toedter.calendar.JDateChooser txtjondate;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtpassw;
    private javax.swing.JTextField txtqualificatn;
    // End of variables declaration//GEN-END:variables
}
