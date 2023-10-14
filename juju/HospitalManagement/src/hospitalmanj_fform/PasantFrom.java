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
    
    
    
    
   private FromtPage fromtPage;
    public PasantFrom(FromtPage fromtPage) {
        initComponents();
        this.fromtPage=fromtPage;
        
        
         
        setLocationRelativeTo(null);
        getaPashant();
        
    }
    
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
   public  void getaPashant(){
    String[] colums={"pasantid","name","address","phone","age","blodgroup","gender","Phathologist","date","disise"};
         DefaultTableModel mdt=new DefaultTableModel();
         mdt.setColumnIdentifiers(colums);
         
         tblepasantpa.setModel(mdt);
         sql="select * from test01.pasantinformation";
         
        try {
            ps=con.getcom().prepareStatement(sql);
            
            rs=ps.executeQuery();
            
            while(rs.next()){
            int pasid=rs.getInt("pasantid");
            String pasName=rs.getString("name");
             String pasaddress=rs.getString("address");
            String pascontactno=rs.getString("phone");
            String age=rs.getString("age");
            String blodgroup=rs.getString("blodgroup");
            String gendere=rs.getString("gender");
            String phathologist=rs.getString("Phathologist");
            Date datee=rs.getDate("date");
            String disise=rs.getString("disise");
            
             mdt.addRow(new Object[]{pasid,pasName,pascontactno,pasaddress,pascontactno,age,blodgroup,gendere,phathologist,datee,disise});
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DigonosisFrom.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
   }
    
    public  void updatepesant(){
         String gender = "";

        if (radioButton1male.isSelected()) {
            gender = "Male";
        } else if (radioFemale.isSelected()) {
            gender = "Female";
        }

     sql="update pasantinformation set name=?,address=?,phone=?,age=?,blodgroup=?,gender=?,Phathologist,date=?,disise=? where pasantid=?";

      
        try {
            ps=con.getcom().prepareStatement(sql);
            
            ps.setString(1,txtpname.getText().trim());
            ps.setString(2, txtpaddress.getText().trim());
            ps.setString(3, txtpphone.getText().trim());
            ps.setString(4,txtpage .getText().trim());
           
            ps.setString(5, comboblod.getSelectedItem().toString());
            ps.setString(6,gender);
            ps.setString(7, combopathologist.getSelectedItem().toString());
            ps.setDate(8, convertUtlToSql(datepregdate.getDate()));
            ps.setString(9, comboDisise.getSelectedItem().toString());
            
            
        
            ps.executeUpdate();
            ps.close();
            con.getcom().close();

            JOptionPane.showMessageDialog(rootPane,"Pasant appointment update");
           getaPashant();  

        } catch (SQLException ex) {
            Logger.getLogger(PasantFrom.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    public void reset() {
        txtpid.setText(null);
        txtpname.setText(null);
        txtpaddress.setText(null);
        txtpage.setText(null);
        comboblod.setSelectedItem(0);
        buttonGroup1.clearSelection();
        combopathologist.setSelectedItem(0);
        datepregdate.setDate(null);
        comboDisise.setSelectedItem(0);
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
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtpphone = new javax.swing.JTextField();
        txtpid = new javax.swing.JTextField();
        comboblod = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtpname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtpaddress = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        radioButton1male = new javax.swing.JRadioButton();
        radioFemale = new javax.swing.JRadioButton();
        btnupdat = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnremove = new javax.swing.JButton();
        btnadd = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtpage = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        datepregdate = new com.toedter.calendar.JDateChooser();
        combopathologist = new javax.swing.JComboBox<>();
        comboDisise = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblepasantpa = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btnhomepat = new javax.swing.JButton();

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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Manage Paitnes");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 940, 40));

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
        jPanel3.add(txtpphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 6, 190, 33));
        jPanel3.add(txtpid, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 6, 190, 35));

        comboblod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Blod Group", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" }));
        jPanel3.add(comboblod, new org.netbeans.lib.awtextra.AbsoluteConstraints(843, 6, 91, 27));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Name");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 47, 59, 33));
        jPanel3.add(txtpname, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 47, 190, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("AGE");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 47, 80, 33));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Pathologist");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 89, -1, 33));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Addresse");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 75, -1));

        txtpaddress.setColumns(20);
        txtpaddress.setRows(5);
        jScrollPane1.setViewportView(txtpaddress);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 190, 53));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Gander");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 47, -1, 35));

        buttonGroup1.add(radioButton1male);
        radioButton1male.setText("Male");
        jPanel3.add(radioButton1male, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 55, 58, -1));

        buttonGroup1.add(radioFemale);
        radioFemale.setText("Female");
        jPanel3.add(radioFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 55, -1, -1));

        btnupdat.setText("UPDATE");
        btnupdat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnupdat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnupdatMouseClicked(evt);
            }
        });
        jPanel3.add(btnupdat, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 246, -1, 41));

        btndelete.setText("DELETE");
        btndelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btndelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btndeleteMouseClicked(evt);
            }
        });
        jPanel3.add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(386, 246, -1, 41));

        btnremove.setText("REMOVE");
        btnremove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnremove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnremoveMouseClicked(evt);
            }
        });
        jPanel3.add(btnremove, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 246, -1, 41));

        btnadd.setText("ADD");
        btnadd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnadd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnaddMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnaddMouseEntered(evt);
            }
        });
        jPanel3.add(btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 246, -1, 41));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Disease");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 70, 30));
        jPanel3.add(txtpage, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 190, 35));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Ragistrasion date");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 120, 30));
        jPanel3.add(datepregdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 180, 30));

        combopathologist.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(combopathologist, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, 170, 30));

        comboDisise.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(comboDisise, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 190, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 940, 280));

        tblepasantpa.setModel(new javax.swing.table.DefaultTableModel(
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
        tblepasantpa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblepasantpaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblepasantpa);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 940, 180));

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

    private void btnaddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnaddMouseClicked
        // TODO add your handling code here:
        String gender = "";

        if (radioButton1male.isSelected()) {
            gender = "Male";
        } else if (radioFemale.isSelected()) {
            gender = "Female";
        }
        
        
        
        sql="insert into test01.pasantinformation (name,address,phone,age,blodgroup,gender,Phathologist,date,disise)values(?,?,?,?,?,?,?,?,?)";

        
        try {
            ps=con.getcom().prepareStatement(sql);
            
            ps.setString(1, txtpname.getText().trim());
            ps.setString(2, txtpaddress.getText().trim());
            ps.setString(3, txtpphone.getText().trim());
            ps.setString(4, txtpage.getText().trim());
            ps.setString(5, comboblod.getSelectedItem().toString());
            ps.setString(6, gender);
            ps.setString(7, combopathologist.getSelectedItem().toString());
            ps.setDate(8,convertUtlToSql(datepregdate.getDate()));
            ps.setString(9,comboDisise.getSelectedItem().toString());

            ps.executeUpdate();
            ps.close();
            con.getcom().close();
            JOptionPane.showMessageDialog(rootPane,"Add Pasant");
            getaPashant();

        } catch (SQLException ex) {
            Logger.getLogger(DigonosisFrom.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane,"dont add any pasant");

        }
            
    }//GEN-LAST:event_btnaddMouseClicked

    private void btndeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndeleteMouseClicked
        // TODO add your handling code here:
         sql = "delete from pasantinformation where pasantid=?";

        try {
            ps = con.getcom().prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(txtpid.getText().trim()));
            ps.executeUpdate();
            ps.close();
            con.getcom().close();
            JOptionPane.showMessageDialog(rootPane, "data delete");
            getaPashant();
        } catch (SQLException ex) {
            Logger.getLogger(DoctorInformation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btndeleteMouseClicked

    private void btnupdatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnupdatMouseClicked
        // TODO add your handling code here:
        updatepesant();
    }//GEN-LAST:event_btnupdatMouseClicked

    private void btnremoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnremoveMouseClicked
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btnremoveMouseClicked

    private void tblepasantpaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblepasantpaMouseClicked
        // TODO add your handling code here:       
      int row = tblepasantpa.getSelectedRow();

        String id = tblepasantpa.getModel().getValueAt(row, 0).toString();
        String name = tblepasantpa.getModel().getValueAt(row, 1).toString();
        String addrs = tblepasantpa.getModel().getValueAt(row, 2).toString();
        String phone = tblepasantpa.getModel().getValueAt(row, 3).toString();
        String age=tblepasantpa.getModel().getValueAt(row, 4).toString();
        String blodgroup=tblepasantpa.getModel().getValueAt(row, 5).toString();
        String gender = tblepasantpa.getModel().getValueAt(row, 6).toString();
        String phathologist = tblepasantpa.getModel().getValueAt(row, 7).toString();

        String date = tblepasantpa.getModel().getValueAt(row, 8).toString();
        String disise = tblepasantpa.getModel().getValueAt(row, 9).toString();

        txtpid.setText(id);
        txtpname.setText(name);
        txtpaddress.setText(addrs);
        txtpphone.setText(phone);
        txtpage.setText(id);
        comboblod.setSelectedItem(blodgroup);
        
         if (gender.equalsIgnoreCase("Male")) {
            radioButton1male.setSelected(rootPaneCheckingEnabled);
        } else if (gender.equalsIgnoreCase("Female")) {
            radioFemale.setSelected(rootPaneCheckingEnabled);
            combopathologist.setSelectedItem(phathologist);
            datepregdate.setDate(formatStringdateToUtilDate(date));
            comboDisise.setSelectedItem(disise);
        
        
       
        }
        

    }//GEN-LAST:event_tblepasantpaMouseClicked

    private void btnaddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnaddMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnaddMouseEntered

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
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnhomepat;
    private javax.swing.JButton btnremove;
    private javax.swing.JButton btnupdat;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comboDisise;
    private javax.swing.JComboBox<String> comboblod;
    private javax.swing.JComboBox<String> combopathologist;
    private com.toedter.calendar.JDateChooser datepregdate;
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
    private javax.swing.JRadioButton radioButton1male;
    private javax.swing.JRadioButton radioFemale;
    private javax.swing.JTable tblepasantpa;
    private javax.swing.JTextArea txtpaddress;
    private javax.swing.JTextField txtpage;
    private javax.swing.JTextField txtpid;
    private javax.swing.JTextField txtpname;
    private javax.swing.JTextField txtpphone;
    // End of variables declaration//GEN-END:variables
}
