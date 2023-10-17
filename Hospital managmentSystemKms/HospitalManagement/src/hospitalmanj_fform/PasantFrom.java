/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hospitalmanj_fform;

import static hospitalmanj_fform.DoctorInformation.formatStringdateToUtilDate;
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
public class PasantFrom extends javax.swing.JFrame {

    
    DataBasseconnaction con=new DataBasseconnaction();
    PreparedStatement ps;
    String sql="";
    ResultSet rs;
    
    
     public  java.sql.Date convertUtlToSql(java.util.Date utilDate){
        if(utilDate!=null){
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
    
    
    
   private FromtPage fromtPage;
    public PasantFrom(FromtPage fromtPage) {
        initComponents();
        getAllpashint();
//        updateallpesant();
        
        this.fromtPage=fromtPage;
        
        
         
        setLocationRelativeTo(null);
    }
     public  void getAllpashint(){
        String[] colums={"pasantid","name","address","phone","age","blodgroup","gender","Phathologist","date","disease"};

         DefaultTableModel modl=new DefaultTableModel();
         modl.setColumnIdentifiers(colums);
         
         tablePashintList.setModel(modl);
         sql="select * from pasantinformation";
         
        try {
            ps=con.getcom().prepareStatement(sql);
            
            rs=ps.executeQuery();
            
            while(rs.next()){
            int pasid=rs.getInt("pasantid");
            String pasName=rs.getString("name");
            String pasaddres=rs.getString("address");
            String phoneno=rs.getString("phone");
            String age=rs.getString("age");
            String blodgtoup=rs.getString("blodgroup");
            String gender=rs.getString("gender");
            String Phathologist=rs.getString("Phathologist");
            Date datee=rs.getDate("date");
            String disease=rs.getString("disease");
            
            modl.addRow(new Object[]{pasid,pasName,pasaddres,phoneno,age,blodgtoup,gender,Phathologist,datee,disease});
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DigonosisFrom.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
public  void updateallpesant(){
     String gender = "";

        if (radioppmale.isSelected()) {
            gender = "Male";
        } else if (radoppfemale.isSelected()) {
            gender = "Female";
        }
     
     sql="update pasantinformation set name=?,address=?,phone=?,age=?,blodgroup=?,gender=?,Phathologist=?,date=?,disease=? where pasantid=?";
     
      
        try {
            ps=con.getcom().prepareStatement(sql);
            
            ps.setString(1,txtppname.getText().trim());
            ps.setString(2,txtppaddresse.getText().trim());
            ps.setString(3,txtppphone.getText().trim());
            ps.setString(4,txtppage.getText().trim());
            ps.setString(5, comboppblodgrp.getSelectedItem().toString());
            ps.setString(6, gender);
            ps.setString(7, comboPhatologist.getSelectedItem().toString());
            ps.setDate(8, convertUtlToSql(PashintregstrationDate.getDate()));
            ps.setString(9, comboppdisease.getSelectedItem().toString());
            ps.setInt(10, Integer.parseInt(txtppid.getText().trim()));
            
            ps.executeUpdate();
             ps.close();
             con.getcom().close();
             JOptionPane.showMessageDialog(rootPane,"Pasant data update");
             
            
        } catch (SQLException ex) {
            Logger.getLogger(PasantFrom.class.getName()).log(Level.SEVERE, null, ex);
        }
  }      
public void reset() {
        txtppid.setText(null);
        txtppname.setText(null);
        txtppaddresse.setText(null);
       txtppage.setText(null);
        comboppblodgrp.setSelectedIndex(0);
        buttonGroup1.clearSelection();
        comboPhatologist.setSelectedIndex(0);
        PashintregstrationDate.setDate(null);
        txtppphone.setText(null);
        comboppdisease.setSelectedIndex(0);
        
        
//        DefaultTableModel model=(DefaultTableModel)tablePashintList.getModel();
//        model.setRowCount(0);
        
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
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtppphone = new javax.swing.JTextField();
        txtppid = new javax.swing.JTextField();
        comboppblodgrp = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtppname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtppaddresse = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        radioppmale = new javax.swing.JRadioButton();
        radoppfemale = new javax.swing.JRadioButton();
        btnppupdate = new javax.swing.JButton();
        btnppdelete = new javax.swing.JButton();
        btnppnew = new javax.swing.JButton();
        btnppadd = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtppage = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        PashintregstrationDate = new com.toedter.calendar.JDateChooser();
        comboPhatologist = new javax.swing.JComboBox<>();
        comboppdisease = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePashintList = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btnhomepat = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Manage Paitnes");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(165, 252, 161));
        jPanel1.setForeground(new java.awt.Color(102, 51, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 51, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HOSPITAL MANAGMENT SYSTEM");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 80));

        jPanel2.setBackground(new java.awt.Color(0, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 85, 52));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Patient   Information");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 940, 50));

        jPanel3.setBackground(new java.awt.Color(192, 140, 242));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("ID");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 59, 41));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Phone");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 6, 71, 35));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Blod Group");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(577, 11, 248, 30));
        jPanel3.add(txtppphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 6, 190, 33));
        jPanel3.add(txtppid, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 6, 190, 35));

        comboppblodgrp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Blod Group", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" }));
        jPanel3.add(comboppblodgrp, new org.netbeans.lib.awtextra.AbsoluteConstraints(843, 6, 91, 27));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Name");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 47, 59, 33));
        jPanel3.add(txtppname, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 47, 190, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("AGE");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 47, 80, 33));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Pathologist");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 89, -1, 33));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Addresse");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 75, -1));

        txtppaddresse.setColumns(20);
        txtppaddresse.setRows(5);
        jScrollPane1.setViewportView(txtppaddresse);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 190, 53));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Gander");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 47, -1, 35));

        buttonGroup1.add(radioppmale);
        radioppmale.setText("Male");
        jPanel3.add(radioppmale, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 55, 58, -1));

        buttonGroup1.add(radoppfemale);
        radoppfemale.setText("Female");
        jPanel3.add(radoppfemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 55, -1, -1));

        btnppupdate.setText("UPDATE");
        btnppupdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnppupdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnppupdateMouseClicked(evt);
            }
        });
        jPanel3.add(btnppupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 246, -1, 41));

        btnppdelete.setText("DELETE");
        btnppdelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnppdelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnppdeleteMouseClicked(evt);
            }
        });
        jPanel3.add(btnppdelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(386, 246, -1, 41));

        btnppnew.setText("New");
        btnppnew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnppnew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnppnewMouseClicked(evt);
            }
        });
        jPanel3.add(btnppnew, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 246, -1, 41));

        btnppadd.setText("ADD");
        btnppadd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnppadd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnppaddMouseClicked(evt);
            }
        });
        jPanel3.add(btnppadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 246, -1, 41));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Disease");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 70, 30));
        jPanel3.add(txtppage, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 190, 35));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Ragistration Date");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 130, 30));
        jPanel3.add(PashintregstrationDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 170, 30));

        comboPhatologist.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--select--", "Dr. Md. Mahmudul Huda (Himel) Assistant", "Professor Dr. Naila Huq. Head of the Department", "Dr. Mashud Parvez. Associate Professor of Histopathology, Department ", "Professor Dr. M. Shawkat Hasan", "Dr. Md. Amer Wahed", "Dr. Abdul Khaleq Akond" }));
        jPanel3.add(comboPhatologist, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 230, 30));

        comboppdisease.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--select--", " Cardiology ", "Orthopedics", "Urology", "Obstetrics and Gynaecology", "Internal medicine", "Internal medicine", "Neurology", "General surgery", "Physical medicine and rehabilitation", " Medicine" }));
        jPanel3.add(comboppdisease, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 190, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 940, 280));

        tablePashintList.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePashintList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePashintListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablePashintList);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 940, 170));

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 2, 36)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Patient List");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 940, 50));

        btnhomepat.setBackground(new java.awt.Color(87, 139, 41));
        btnhomepat.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btnhomepat.setForeground(new java.awt.Color(204, 255, 102));
        btnhomepat.setText("HOME");
        btnhomepat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnhomepat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhomepatActionPerformed(evt);
            }
        });
        getContentPane().add(btnhomepat, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 640, 340, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnhomepatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhomepatActionPerformed
        // TODO add your handling code here:
        this.dispose();
        fromtPage.setVisible(true);
    
    }//GEN-LAST:event_btnhomepatActionPerformed

    private void btnppaddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnppaddMouseClicked
        // TODO add your handling code here:
         sql = "insert into pasantinformation(name,address,phone,age,blodgroup,gender,Phathologist,date,disease)values(?,?,?,?,?,?,?,?,?)";
        String gender = "";

        if (radioppmale.isSelected()) {
            gender = "Male";
        } else if (radoppfemale.isSelected()) {
            gender = "Female";
        }

        try {
            ps = con.getcom().prepareStatement(sql);

            ps.setString(1, txtppname.getText().trim());
            ps.setString(2, txtppaddresse.getText().trim());
            ps.setString(3, txtppphone.getText().trim());
            ps.setString(4, txtppage.getText().trim());
            ps.setString(5, comboppblodgrp.getSelectedItem().toString());
            ps.setString(6, gender);
            ps.setString(7, comboPhatologist.getSelectedItem().toString());
            ps.setDate(8, convertUtlToSql(PashintregstrationDate.getDate()));
            ps.setString(9, comboppdisease.getSelectedItem().toString());

            ps.executeUpdate();
            ps.close();
            con.getcom().close();

            JOptionPane.showMessageDialog(rootPane, "add data");
            getAllpashint();
        } catch (SQLException ex) {
            Logger.getLogger(DoctorInformation.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, " data is not add");

        }
    }//GEN-LAST:event_btnppaddMouseClicked

    private void btnppupdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnppupdateMouseClicked
        // TODO add your handling code here:
        updateallpesant();
    }//GEN-LAST:event_btnppupdateMouseClicked

    private void btnppdeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnppdeleteMouseClicked
        // TODO add your handling code here
sql = "delete from pasantinformation where pasantid=?";

        try {
            ps = con.getcom().prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(txtppid.getText().trim()));
            ps.executeUpdate();
            ps.close();
            con.getcom().close();
            JOptionPane.showMessageDialog(rootPane, "data delete");
            getAllpashint();
        } catch (SQLException ex) {
            Logger.getLogger(DoctorInformation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnppdeleteMouseClicked

    private void tablePashintListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePashintListMouseClicked
        // TODO add your handling code here:
         int row = tablePashintList.getSelectedRow();

        String id = tablePashintList.getModel().getValueAt(row, 0).toString();
        String name = tablePashintList.getModel().getValueAt(row, 1).toString();
        String address = tablePashintList.getModel().getValueAt(row, 2).toString();
        String phone = tablePashintList.getModel().getValueAt(row, 3).toString();
        String age = tablePashintList.getModel().getValueAt(row, 4).toString();
        String blodgroup = tablePashintList.getModel().getValueAt(row, 5).toString();
        String gender = tablePashintList.getModel().getValueAt(row, 6).toString();
        String phathologist = tablePashintList.getModel().getValueAt(row, 7).toString();
        String date = tablePashintList.getModel().getValueAt(row, 8).toString();
        String disease = tablePashintList.getModel().getValueAt(row, 9).toString();
        

      txtppid.setText(id);
        txtppname.setText(name);
        txtppaddresse.setText(address);
        txtppphone.setText(phone);
        txtppage.setText(age);
        comboppblodgrp.setSelectedItem(blodgroup);
        
        
        if (gender.equalsIgnoreCase("Male")) {
            radioppmale.setSelected(rootPaneCheckingEnabled);
        } else if (gender.equalsIgnoreCase("Female")) {
            radoppfemale.setSelected(rootPaneCheckingEnabled);
        }
        comboPhatologist.setSelectedItem(phathologist);
        PashintregstrationDate.setDate(formatStringdateToUtilDate(date));
        comboppdisease.setSelectedItem(disease);
    }//GEN-LAST:event_tablePashintListMouseClicked

    private void btnppnewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnppnewMouseClicked
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btnppnewMouseClicked

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
            java.util.logging.Logger.getLogger(PasantFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PasantFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PasantFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PasantFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FromtPage fromtPage=new FromtPage();
                PasantFrom pasantFrom=new PasantFrom(fromtPage);
                pasantFrom.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser PashintregstrationDate;
    private javax.swing.JButton btnhomepat;
    private javax.swing.JButton btnppadd;
    private javax.swing.JButton btnppdelete;
    private javax.swing.JButton btnppnew;
    private javax.swing.JButton btnppupdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comboPhatologist;
    private javax.swing.JComboBox<String> comboppblodgrp;
    private javax.swing.JComboBox<String> comboppdisease;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton radioppmale;
    private javax.swing.JRadioButton radoppfemale;
    private javax.swing.JTable tablePashintList;
    private javax.swing.JTextArea txtppaddresse;
    private javax.swing.JTextField txtppage;
    private javax.swing.JTextField txtppid;
    private javax.swing.JTextField txtppname;
    private javax.swing.JTextField txtppphone;
    // End of variables declaration//GEN-END:variables
}
