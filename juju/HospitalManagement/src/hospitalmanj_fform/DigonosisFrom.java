/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hospitalmanj_fform;

import com.mysql.cj.util.Util;
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
 * @author SAIFULLAH
 */
public class DigonosisFrom extends javax.swing.JFrame {

    DataBasseconnaction con=new DataBasseconnaction();
    PreparedStatement ps;
    String sql="";
    ResultSet rs;
    
    public DigonosisFrom() {
        initComponents();
        setLocationRelativeTo(null);
//        getAllappointment();
        //updatepesant();
//        resate();
        
    }
    
     public  java.sql.Date convertUtlToSql(java.util.Date utilDate){
        if(utilDate!=null){
        return new java.sql.Date(utilDate.getTime());
        }
    return null;
    }
     public  void getAllappointment(){
     String[] colums={"pasant_id","pasantname","contactno","address","doctorid","doctorname","qualification","visitingtime","date"};
         DefaultTableModel dtm=new DefaultTableModel();
         dtm.setColumnIdentifiers(colums);
         
         tblappointment.setModel(dtm);
         sql="select * from appointment";
         
        try {
            ps=con.getcom().prepareStatement(sql);
            
            rs=ps.executeQuery();
            
            while(rs.next()){
            int pasid=rs.getInt("pasant_id");
            String pasName=rs.getString("pasantname");
            String pascontactno=rs.getString("contactno");
            String pasaddress=rs.getString("address");
            int doctorid=rs.getInt("doctorid");
            String doctorName=rs.getString("doctorname");
            String docqualification=rs.getString("qualification");
            String docvisitingtime=rs.getString("Visitingtime");
            Date datee=rs.getDate("date");
            
             dtm.addRow(new Object[]{pasid,pasName,pascontactno,pasaddress,doctorid,doctorName,docqualification,docvisitingtime,datee});
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DigonosisFrom.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public  void updatepesant(){


     sql="update appointment set pasantname=?,address=?,doctorid=?,doctorname=?,qualification=?,VisitingTime=?,Date=? where contactno=?";

        try {
            ps=con.getcom().prepareStatement(sql);

           // ps.setInt(1, Integer.parseInt(txtPid.getText().trim()));
            ps.setString(1, txtpname.getText().trim());
            
            ps.setString(2, txtappointAddress.getText().trim());
            ps.setInt(3, Integer.parseInt(txtappoDocid.getText().trim()));
            ps.setString(4,txtAppodocName.getText().trim());
            ps.setString(5,comboQulification.getSelectedItem().toString());
            ps.setString(6, comboVisitingtime.getSelectedItem().toString());
            ps.setDate(7,convertUtlToSql(dateappointVisiring.getDate()));
            
            ps.setString(8, txtpascontact.getText().trim());

            ps.executeUpdate();
            ps.close();
            con.getcom().close();

            JOptionPane.showMessageDialog(rootPane,"Pasant appointment update");
           getAllappointment();  
        } catch (SQLException ex) {
            Logger.getLogger(DigonosisFrom.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
        
   public void resate(){
     txtPid.setText(null);
     txtpname.setText(null);
     txtpascontact.setText(null);
     txtappointAddress.setText(null);
     txtappoDocid.setText(null);
     txtAppodocName.setText(null);
     comboQulification.setSelectedItem(null);
     comboVisitingtime.setSelectedItem(0);
     dateappointVisiring.setDate(null);

     }
   
    public void getAllpasant(){
    sql="select pasantid,name,assress from pasantinformation where phone=?";
    
        try {
            ps=con.getcom().prepareStatement(sql);
            
            ps.setString(1, txtpascontact.getText());
            
            rs=ps.executeQuery();
            
            while(rs.next()){
           txtPid.setText(rs.getString("pasantid"));
           txtpname.setText(rs.getString("name"));
           txtappointAddress.setText(rs.getString("address"));
        
        }
            ps.executeQuery();
            ps.close();
            con.getcom().close();
        } catch (SQLException ex) {
            Logger.getLogger(DigonosisFrom.class.getName()).log(Level.SEVERE, null, ex);
        }
    
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        tabepanedigonosis = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        radiomaled = new javax.swing.JRadioButton();
        radioFemaled = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnadd = new javax.swing.JButton();
        btnUpdat = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDoctor = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePasent = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtpascontact = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtpname = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtappointAddress = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblappointment = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        txtAppodocName = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtappoDocid = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        comboVisitingtime = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        dateappointVisiring = new com.toedter.calendar.JDateChooser();
        jLabel24 = new javax.swing.JLabel();
        txtPid = new javax.swing.JTextField();
        btnappoResat = new javax.swing.JButton();
        btnAppodelet = new javax.swing.JButton();
        btnappoadd = new javax.swing.JButton();
        btnappoupdat = new javax.swing.JButton();
        comboQulification = new javax.swing.JComboBox<>();
        btnsearch = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel29 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel32 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jPanel13 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel47 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jLabel48 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 231, 250));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Hospital Management System");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Digonosis Management");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, -1));

        jPanel2.setBackground(new java.awt.Color(255, 249, 245));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Doctor ApointMent");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 147, 38));

        jButton2.setText("Admition");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 147, 38));

        jButton3.setText("Billing Management");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 147, 38));

        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton10.setText("HOOM");
        jPanel2.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 120, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 180, 580));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/fontpage.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabepanedigonosis.addTab("tab1", jPanel4);

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Pasant id");
        jPanel9.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 20));
        jPanel9.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 100, 20));

        jLabel5.setText("Pasant Name");
        jPanel9.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 70, 20));
        jPanel9.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 110, 20));

        jLabel6.setText("Gender");
        jPanel9.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 70, 20));

        buttonGroup2.add(radiomaled);
        radiomaled.setText("Male");
        jPanel9.add(radiomaled, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        buttonGroup2.add(radioFemaled);
        radioFemaled.setText("Female");
        jPanel9.add(radioFemaled, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        jLabel7.setText("Blod group");
        jPanel9.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 60, 20));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--select--", "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-" }));
        jPanel9.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 90, -1));

        jLabel8.setText("Diesise");
        jPanel9.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 50, 20));
        jPanel9.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 100, -1));

        jLabel9.setText("Room No:");
        jPanel9.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 60, 20));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Room No:--", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", " " }));
        jPanel9.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Catagory--", "AC CABIN", "NON AC CABIN", "AC WORD", "NON AC WORD", " " }));
        jPanel9.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 110, -1));

        jLabel10.setText("Age");
        jPanel9.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 40, 20));
        jPanel9.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 110, 20));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Doctor id");
        jPanel9.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 60, 30));
        jPanel9.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 90, 30));

        jLabel12.setText("Doctor Name");
        jPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 80, 20));
        jPanel9.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 140, 20));

        jLabel13.setText("Remarks");
        jPanel9.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 50, 20));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel9.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 170, 50));

        btnadd.setText("ADD");
        jPanel9.add(btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        btnUpdat.setText("Update");
        jPanel9.add(btnUpdat, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, -1, -1));

        jButton6.setText("Delete");
        jPanel9.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, -1, -1));

        jButton7.setText("New");
        jPanel9.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, -1, -1));

        tableDoctor.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tableDoctor);

        jPanel9.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 300, 160));

        tablePasent.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tablePasent);

        jPanel9.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 300, 160));

        jLabel14.setText("Doctor table");
        jPanel9.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 70, 20));

        jLabel15.setText("Pasant table");
        jPanel9.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 70, 20));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
        );

        tabepanedigonosis.addTab("Admition", jPanel5);

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setText("Pasant name");
        jPanel10.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 80, 30));
        jPanel10.add(txtpascontact, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 120, -1));

        jLabel17.setText("Phone No:");
        jPanel10.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 70, 20));
        jPanel10.add(txtpname, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 150, -1));

        jLabel18.setText("Address");
        jPanel10.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 60, -1));

        txtappointAddress.setColumns(20);
        txtappointAddress.setRows(5);
        jScrollPane4.setViewportView(txtappointAddress);

        jPanel10.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 150, 50));

        tblappointment.setModel(new javax.swing.table.DefaultTableModel(
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
        tblappointment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblappointmentMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblappointment);

        jPanel10.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 300, 240));

        jLabel19.setText("Doctor id");
        jPanel10.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 60, 20));
        jPanel10.add(txtAppodocName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 150, -1));

        jLabel20.setText("Doctor Name");
        jPanel10.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 80, -1));
        jPanel10.add(txtappoDocid, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 150, -1));

        jLabel21.setText("Qualification");
        jPanel10.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 80, 20));

        jLabel22.setText("Visiting time");
        jPanel10.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 80, 20));

        comboVisitingtime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chos Time", "09:00am to 12:00pm", "12:00pm  to  03:00pm", "03:00 pm to 06:00pm", "05:00pm to 10:00pm", " ", " " }));
        jPanel10.add(comboVisitingtime, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 150, -1));

        jLabel23.setText("Visiting Date");
        jPanel10.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 70, 20));
        jPanel10.add(dateappointVisiring, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 150, -1));

        jLabel24.setText("Pasant id");
        jPanel10.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 70, 30));
        jPanel10.add(txtPid, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 150, -1));

        btnappoResat.setText("New");
        btnappoResat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnappoResatMouseClicked(evt);
            }
        });
        jPanel10.add(btnappoResat, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 110, -1));

        btnAppodelet.setText("Delet");
        btnAppodelet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAppodeletMouseClicked(evt);
            }
        });
        jPanel10.add(btnAppodelet, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 110, -1));

        btnappoadd.setText("ADD Appointment");
        btnappoadd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnappoaddMouseClicked(evt);
            }
        });
        jPanel10.add(btnappoadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 110, -1));

        btnappoupdat.setText("Update");
        btnappoupdat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnappoupdatMouseClicked(evt);
            }
        });
        jPanel10.add(btnappoupdat, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 110, -1));

        comboQulification.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Select--", "Cardiologist", "Internal medicine", "General practitioner", "Endocrinology", "Urology", "Otorhinolaryngology", "Neurology", "Eaye", "Ophthalmology", "Radiologist", "Dermatologist" }));
        jPanel10.add(comboQulification, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 150, -1));

        btnsearch.setText("search");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });
        jPanel10.add(btnsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 60, -1));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
        );

        tabepanedigonosis.addTab("Doc Appointment", jPanel6);

        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setText("Parient Info");
        jPanel12.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 20));

        jLabel26.setText("Patient ID");
        jPanel12.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 60, -1));
        jPanel12.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 130, 30));

        jLabel27.setText("Gender");
        jPanel12.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 50, -1));
        jPanel12.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 130, 30));

        jLabel28.setText("Patient Name");
        jPanel12.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 80, -1));

        buttonGroup3.add(jRadioButton1);
        jRadioButton1.setText("Male");
        jPanel12.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        buttonGroup3.add(jRadioButton2);
        jRadioButton2.setText("Female");
        jPanel12.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, -1));

        jLabel29.setText("Blood Group");
        jPanel12.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 70, 20));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel12.add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 90, -1));

        jLabel30.setText("Disease");
        jPanel12.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 60, 20));
        jPanel12.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 130, -1));

        jLabel31.setText("Admit Date");
        jPanel12.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 70, -1));
        jPanel12.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 120, -1));

        jLabel32.setText("Room No:");
        jPanel12.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 70, 30));
        jPanel12.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 130, -1));

        jLabel33.setText("Doctor ID");
        jPanel12.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 60, -1));
        jPanel12.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 130, -1));

        jLabel34.setText("Doctor Name");
        jPanel12.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 80, 20));
        jPanel12.add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 130, -1));

        jLabel35.setText("Discharge Date");
        jPanel12.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 80, -1));
        jPanel12.add(jDateChooser3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 130, -1));

        jPanel11.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 350));

        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setText("Payment Details");
        jPanel13.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, -1));

        jLabel37.setText("Room Charges");
        jPanel13.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 90, -1));
        jPanel13.add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 100, 20));

        jLabel38.setText("No. of Days");
        jPanel13.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 70, -1));
        jPanel13.add(jTextField20, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        jLabel39.setText("Service Charges");
        jPanel13.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 90, -1));
        jPanel13.add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 100, -1));

        jLabel40.setText("Doctor visit");
        jPanel13.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 70, -1));
        jPanel13.add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 100, -1));

        jLabel41.setText("Total room charges");
        jPanel13.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 110, -1));
        jPanel13.add(jTextField23, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 70, -1));

        jLabel43.setText("Discount");
        jPanel13.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 50, -1));
        jPanel13.add(jTextField26, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 70, -1));

        jLabel44.setText("Total Charges");
        jPanel13.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 80, -1));
        jPanel13.add(jTextField25, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 100, -1));

        jLabel45.setText("Payment Mode Details");
        jPanel13.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 130, -1));
        jPanel13.add(jTextField27, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 160, 20));

        jLabel46.setText("Payment Mode");
        jPanel13.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 90, -1));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel13.add(jComboBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 80, -1));

        jLabel47.setText("Billing Date");
        jPanel13.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 70, -1));
        jPanel13.add(jDateChooser4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 110, -1));

        jLabel48.setText("Bill No:");
        jPanel13.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 50, -1));
        jPanel13.add(jTextField28, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 150, -1));

        jPanel11.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 390, 230));

        jButton4.setText("Add");
        jPanel11.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));

        jButton5.setText("Update");
        jPanel11.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, -1, -1));

        jButton8.setText("New");
        jPanel11.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, -1));

        jButton9.setText("Hoom");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, -1, -1));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(jTable3);

        jPanel11.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 510, 410, 170));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(jTable4);

        jPanel11.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 410, 170));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabepanedigonosis.addTab("Billing", jPanel7);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 499, Short.MAX_VALUE)
        );

        tabepanedigonosis.addTab("tab5", jPanel8);

        jPanel3.add(tabepanedigonosis, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 530));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 640, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        tabepanedigonosis.setSelectedIndex(1);
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
         tabepanedigonosis.setSelectedIndex(2);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        tabepanedigonosis.setSelectedIndex(3);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        tabepanedigonosis.setSelectedIndex(0);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void btnappoaddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnappoaddMouseClicked
        // TODO add your handling code here:
         sql="insert into appointment (pasantname,contactno,address,doctorid,doctorname,qualification,visitingtime,date)values(?,?,?,?,?,?,?,?)";

        
        try {
            ps=con.getcom().prepareStatement(sql);
            
            ps.setString(1, txtpname.getText().trim());
            ps.setString(2, txtpascontact.getText().trim());
            ps.setString(3, txtappointAddress.getText().trim());
            ps.setString(4, txtappoDocid.getText().trim());
            ps.setString(5, txtAppodocName.getText().trim());
            ps.setString(6, comboQulification.getSelectedItem().toString());
            ps.setString(7,comboVisitingtime.getSelectedItem().toString());
            ps.setDate(8,convertUtlToSql(dateappointVisiring.getDate()));

            ps.executeUpdate();
            ps.close();
            con.getcom().close();
            JOptionPane.showMessageDialog(rootPane,"Add AppointMent");
            getAllappointment();

        } catch (SQLException ex) {
            Logger.getLogger(DigonosisFrom.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane,"no AppointMent Added");

        }
            
        
    }//GEN-LAST:event_btnappoaddMouseClicked

    private void btnappoupdatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnappoupdatMouseClicked
        // TODO add your handling code here:
         updatepesant();
         
    }//GEN-LAST:event_btnappoupdatMouseClicked

    private void btnappoResatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnappoResatMouseClicked
        // TODO add your handling code here:
        resate();
    }//GEN-LAST:event_btnappoResatMouseClicked

    private void btnAppodeletMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAppodeletMouseClicked
        // TODO add your handling code here:
       sql="delete from appointment where pasant_id=?";
       
        try {
            ps=con.getcom().prepareStatement(sql);
            
            ps.setInt(1,Integer.parseInt(txtPid.getText().trim()));
            
            ps.executeUpdate();
            ps.close();
            con.getcom().close();
            
            JOptionPane.showMessageDialog(rootPane,"delate data");
            getAllappointment();
        } catch (SQLException ex) {
            Logger.getLogger(DigonosisFrom.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane,"delate data");

        }
        
    }//GEN-LAST:event_btnAppodeletMouseClicked

    private void tblappointmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblappointmentMouseClicked
        // TODO add your handling code here:
         int row=tblappointment.getSelectedRow();
        
        String pasid=tblappointment.getModel().getValueAt(row, 0).toString();
        String psname=tblappointment.getModel().getValueAt(row, 1).toString();
        String pscontact=tblappointment.getModel().getValueAt(row, 2).toString();
        String psaddress=tblappointment.getModel().getValueAt(row, 3).toString();
        String docid=tblappointment.getModel().getValueAt(row, 4).toString();
        String docname=tblappointment.getModel().getValueAt(row, 5).toString();
        String docqualificarion=tblappointment.getModel().getValueAt(row, 6).toString();
        String visitingtime=tblappointment.getModel().getValueAt(row, 7).toString();
        String appoDate=tblappointment.getModel().getValueAt(row, 8).toString();
        
        txtPid.setText(pasid);
        txtpname.setText(psname);
        txtpascontact.setText(pscontact);
        txtappointAddress.setText(psaddress);
        txtappoDocid.setText(docid);
        txtAppodocName.setText(docname);
        comboQulification.setSelectedItem(docqualificarion);
        comboVisitingtime.setSelectedItem(visitingtime);
        
    }//GEN-LAST:event_tblappointmentMouseClicked

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        // TODO add your handling code here:
        getAllpasant();
    }//GEN-LAST:event_btnsearchActionPerformed

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
            java.util.logging.Logger.getLogger(DigonosisFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DigonosisFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DigonosisFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DigonosisFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DigonosisFrom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAppodelet;
    private javax.swing.JButton btnUpdat;
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnappoResat;
    private javax.swing.JButton btnappoadd;
    private javax.swing.JButton btnappoupdat;
    private javax.swing.JButton btnsearch;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> comboQulification;
    private javax.swing.JComboBox<String> comboVisitingtime;
    private com.toedter.calendar.JDateChooser dateappointVisiring;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JRadioButton radioFemaled;
    private javax.swing.JRadioButton radiomaled;
    private javax.swing.JTabbedPane tabepanedigonosis;
    private javax.swing.JTable tableDoctor;
    private javax.swing.JTable tablePasent;
    private javax.swing.JTable tblappointment;
    private javax.swing.JTextField txtAppodocName;
    private javax.swing.JTextField txtPid;
    private javax.swing.JTextField txtappoDocid;
    private javax.swing.JTextArea txtappointAddress;
    private javax.swing.JTextField txtpascontact;
    private javax.swing.JTextField txtpname;
    // End of variables declaration//GEN-END:variables
}
