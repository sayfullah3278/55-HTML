/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hospitalmanj_fform;

import static hospitalmanj_fform.PasantFrom.formatStringdateToUtilDate;
import java.awt.JobAttributes;
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
public class DigonosisFrom extends javax.swing.JFrame {

    DataBasseconnaction con=new DataBasseconnaction();
    PreparedStatement ps;
    String sql="";
    ResultSet rs;
    
    public DigonosisFrom() {
        initComponents();
        setLocationRelativeTo(null);
        
        getAllroom();
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
            ps.close();
            con.getcom().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DigonosisFrom.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public  void updatepesant(){
     
     
     sql="update appointment set pasant_id=?,pasantname=?,address=?,doctorid=?,doctorname=?,qualification=?,VisitingTime=?,Date=? where contactno=?";
     
        try {
            ps=con.getcom().prepareStatement(sql);
            ps.setString(1, txtpascontact.getText().trim());
            
            ps.setString(2, patientId.getText().trim());
            ps.setInt(3, Integer.parseInt(patientId.getText().trim()));
            ps.setString(4, txtappointAddress.getText().trim());
            ps.setInt(5, Integer.parseInt(combodocid.getSelectedItem().toString()));
            ps.setString(6,txtAppodocName.getText().trim());
            ps.setString(7,comboappointQualification.getSelectedItem().toString());
            ps.setString(8, comboVisitingtime1.getSelectedItem().toString());
            ps.setDate(9, convertUtlToSql(dateappointVisiring.getDate()));
            
            ps.executeUpdate();
            ps.close();
            con.getcom().close();
            
            JOptionPane.showMessageDialog(rootPane,"Pasant appointment update");
           getAllappointment();  
        } catch (SQLException ex) {
            Logger.getLogger(DigonosisFrom.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     
     }
     
     public void reset(){
    patientId.setText(null);
     patientId.setText(null);
     txtpascontact.setText(null);
     txtappointAddress.setText(null);
     combodocid.setSelectedItem(0);
     txtAppodocName.setText(null);
    comboappointQualification.setSelectedItem(0);
     comboVisitingtime1.setSelectedItem(0);
     dateappointVisiring.setDate(null);
     
     }
     
      public void getAllpasant(){
    sql="select name,phone,address from pasantinformation where pasantid=?";
    
        try {
            ps=con.getcom().prepareStatement(sql);
            
            ps.setInt(1, Integer.parseInt(patientId.getText().trim()));
            
            rs=ps.executeQuery();
            
            while(rs.next()){
           
           patientId.setText(rs.getString("name"));
           txtappointAddress.setText(rs.getString("address"));
           txtpascontact.setText(rs.getString("phone"));
           
           
        
        }
            ps.executeQuery();
            ps.close();
            con.getcom().close();
        } catch (SQLException ex) {
            Logger.getLogger(DigonosisFrom.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
      public void getalldoctor(){
      sql="select name,qualifications from doctorinformation where id=?";
      
        try {
            ps=con.getcom().prepareStatement(sql);
            
            ps.setInt(1, Integer.parseInt(combodocid.getSelectedItem().toString()));
            
            rs=ps.executeQuery();
            
            while(rs.next()){
            txtAppodocName.setText(rs.getString("name"));
         comboappointQualification.setSelectedItem(rs.getString("qualifications"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DigonosisFrom.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      
      public void getAlladmition(){
       String[] colums={"pasantid","panantname","gender","age","blodgroup","disease","roomid","roomtype","doctorid","doctorname","admitdate"};
         DefaultTableModel dtm2=new DefaultTableModel();
         dtm2.setColumnIdentifiers(colums);
         
         tblappointment.setModel(dtm2);
         sql="select * from hospitaladmition";
         
        try {
            ps=con.getcom().prepareStatement(sql);
            
            rs=ps.executeQuery();
            
            while(rs.next()){
            int pasid=rs.getInt("pasantid");
            String pasName=rs.getString("panantname");
            String gender=rs.getString("gender");
            String age=rs.getString("age");
            String blodgroup=rs.getString("blodgroup");
            String disease=rs.getString("disease");
            String roomid=rs.getString("roomid");
            String roomtype=rs.getString("roomtype");
            int doctorid=rs.getInt("doctorid");
            String doctorName=rs.getString("doctorname");
            
            Date datee=rs.getDate("admitdate");
            
            dtm2.addRow(new Object[]{pasid,pasName,gender,blodgroup,disease,roomid,roomtype,doctorid,doctorName,datee});
            }
            ps.close();
            con.getcom().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DigonosisFrom.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    
      
      public  void updatadmition(){
      String gender = "";

        if (radiomaleAdmit.isSelected()) {
            gender = "Male";
        } else if (radioFemaledAdmit.isSelected()) {
            gender = "Female";
        }
     
     sql="update hospitaladmition set pasantid=?,panantname=?,gender=?,age=?,blodgroup=?,disease=?,roomid=?,roomNumber=?,doctorid=?,doctorname=?,admitdate=? where id=?";
     
        try {
            ps=con.getcom().prepareStatement(sql);
            
            ps.setInt(1, Integer.parseInt(patientId.getText().trim()));
            ps.setString(2, patientId.getText().trim());
            ps.setString(3, gender);
            ps.setString(4, txtAdmitionage.getText().trim());
            ps.setString(5,comboblodgroup.getSelectedItem().toString());
            ps.setString(6, combodisiseadmit.getSelectedItem().toString());
            ps.setString(7, comboRoomnumber.getSelectedItem().toString());
            ps.setString(8, txtRoomTypeSearch.getSelectedItem().toString());
            ps.setString(9, comboDocidAdmit1.getSelectedItem().toString());
            ps.setString(10,txtdocnameadmit.getText().trim());
            ps.setDate(11, convertUtlToSql(dateAdmitdate.getDate()));

            ps.setInt(5, Integer.parseInt(combodocid.getSelectedItem().toString()));
            
            
            ps.executeUpdate();
            ps.close();
            con.getcom().close();
            
            JOptionPane.showMessageDialog(rootPane,"Pasant admition update");
           getAllappointment();  
        } catch (SQLException ex) {
            Logger.getLogger(DigonosisFrom.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
     public void getAllroom(){
     String[] columnroom={"roomnumber","roomtype","roomprice","statues"};
     
     DefaultTableModel model2=new DefaultTableModel();
     model2.setColumnIdentifiers(columnroom);
     
     tableRoomlist.setModel(model2);
     
     sql="select * from room";
     
        try {
            ps=con.getcom().prepareStatement(sql);
            
            rs=ps.executeQuery();
            
            while(rs.next()){
            int roomnumber=rs.getInt("roomnumber");
            String roomtype=rs.getString("roomtype");
            String roomprice=rs.getString("roomprice");
            String statues=rs.getString("statues");
            
            model2.addRow(new Object[] {roomnumber,roomtype,roomprice,statues});
            }
            rs.close();
            ps.close();
            con.getcom().close();
        } catch (SQLException ex) {
            Logger.getLogger(DigonosisFrom.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     
     }
     
     public void getroomNumber(String roomtype){
    comboRoomnumber.removeAllItems();
    
    sql="select roomnumber,roomprice from room where roomtype=? and statues=?";
     
        try {
            ps=con.getcom().prepareStatement(sql);
            
            ps.setString(1, roomtype);
            ps.setString(2, "unbocked");
            
            ResultSet rs1=ps.executeQuery();
            
            while(rs1.next()){
            int roomnumber=rs1.getInt("roomnumber");
            comboRoomnumber.addItem(roomnumber+"");
            txtRoomPrice.setText(rs1.getString("roomprice"));
                
            }
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
        jbtnroomma = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        BtnDashbord = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        tabepanedigonosis = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtadmitPname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        radiomaleAdmit = new javax.swing.JRadioButton();
        radioFemaledAdmit = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        comboblodgroup = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        comboRoomnumber = new javax.swing.JComboBox<>();
        txtRoomTypeSearch = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtAdmitionage = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtdocnameadmit = new javax.swing.JTextField();
        btnaddAdmition = new javax.swing.JButton();
        btnUpdat = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDoctor = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePasent = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnAdmitSearchdocid = new javax.swing.JButton();
        btnAdmitSearchpid = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        dateAdmitdate = new com.toedter.calendar.JDateChooser();
        combodisiseadmit = new javax.swing.JComboBox<>();
        combopasidAdmit = new javax.swing.JComboBox<>();
        comboDocidAdmit1 = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtpascontact = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        patientId = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtappointAddress = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblappointment = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        txtAppodocName = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        comboVisitingtime1 = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        dateappointVisiring = new com.toedter.calendar.JDateChooser();
        jLabel24 = new javax.swing.JLabel();
        btnappoResat = new javax.swing.JButton();
        btnAppodelet = new javax.swing.JButton();
        btnappoadd = new javax.swing.JButton();
        btnappoupdat = new javax.swing.JButton();
        comboappointQualification = new javax.swing.JComboBox<>();
        btndocidsearch = new javax.swing.JButton();
        btnpasseardh = new javax.swing.JButton();
        combodocid = new javax.swing.JComboBox<>();
        txtpname1 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtbillpsid = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtbillpasname = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        radiobiMale = new javax.swing.JRadioButton();
        radiobilFemale = new javax.swing.JRadioButton();
        jLabel29 = new javax.swing.JLabel();
        combobillBlodgrup = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        txtbillDisease = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        datebillAdmitdate = new com.toedter.calendar.JDateChooser();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtbillDocid = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtbillDocname = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        dateDischarge = new com.toedter.calendar.JDateChooser();
        txtRoomNo = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txtRoomCharge = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txtbillNoOfDays = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txtDocvisit = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        txtbillServischarges = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        txtTotalRoomcharge = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        txtDiscount = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        txtTotalbill = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        txtFinalBill = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        comboPaymentMode = new javax.swing.JComboBox<>();
        jLabel47 = new javax.swing.JLabel();
        dateBillingDate = new com.toedter.calendar.JDateChooser();
        jLabel48 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        tabbillTabil = new javax.swing.JTable();
        jButton11 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        txtRoomType = new javax.swing.JComboBox<>();
        jLabel50 = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        jLabel51 = new javax.swing.JLabel();
        txtRoomPrice = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRoomlist = new javax.swing.JTable();
        txtRoomNumber = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();

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
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, -1));

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
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 147, 38));

        jbtnroomma.setText("Room Management");
        jbtnroomma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnroommaActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnroomma, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 147, 38));

        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton10.setText("HOOM");
        jPanel2.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 90, 30));

        BtnDashbord.setText("Dashboard");
        BtnDashbord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnDashbordMouseClicked(evt);
            }
        });
        jPanel2.add(BtnDashbord, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 150, 40));

        jButton12.setText("Billing Management");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 147, 38));

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

        jLabel5.setText("Pasant Name");
        jPanel9.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 70, 20));
        jPanel9.add(txtadmitPname, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 160, 30));

        jLabel6.setText("Gender");
        jPanel9.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 70, 20));

        buttonGroup2.add(radiomaleAdmit);
        radiomaleAdmit.setText("Male");
        jPanel9.add(radiomaleAdmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        buttonGroup2.add(radioFemaledAdmit);
        radioFemaledAdmit.setText("Female");
        jPanel9.add(radioFemaledAdmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        jLabel7.setText("Blod group");
        jPanel9.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 60, 20));

        comboblodgroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--select--", "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-" }));
        jPanel9.add(comboblodgroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 90, -1));

        jLabel8.setText("Diesise");
        jPanel9.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 50, 20));

        jLabel9.setText("Room No:");
        jPanel9.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 60, 20));

        comboRoomnumber.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Room No:--", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", " " }));
        jPanel9.add(comboRoomnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        txtRoomTypeSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Catagory--", "AC CABIN", "NON AC CABIN", "AC WORD", "NON AC WORD", " " }));
        txtRoomTypeSearch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtRoomTypeSearchItemStateChanged(evt);
            }
        });
        jPanel9.add(txtRoomTypeSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 110, -1));

        jLabel10.setText("Age");
        jPanel9.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 40, 20));
        jPanel9.add(txtAdmitionage, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 110, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Doctor id");
        jPanel9.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 60, 30));

        jLabel12.setText("Doctor Name");
        jPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 80, 20));
        jPanel9.add(txtdocnameadmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 140, 30));

        btnaddAdmition.setText("ADD");
        btnaddAdmition.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnaddAdmitionMouseClicked(evt);
            }
        });
        jPanel9.add(btnaddAdmition, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        btnUpdat.setText("Update");
        btnUpdat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdatMouseClicked(evt);
            }
        });
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

        jPanel9.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 300, 160));

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

        jPanel9.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 300, 160));

        jLabel14.setText("Availabe room");
        jPanel9.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, 80, 20));

        jLabel15.setText("Pasant table");
        jPanel9.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 70, 20));

        btnAdmitSearchdocid.setText("Search");
        btnAdmitSearchdocid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdmitSearchdocidMouseClicked(evt);
            }
        });
        jPanel9.add(btnAdmitSearchdocid, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 90, -1));

        btnAdmitSearchpid.setText("Search");
        btnAdmitSearchpid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdmitSearchpidMouseClicked(evt);
            }
        });
        jPanel9.add(btnAdmitSearchpid, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 90, -1));

        jLabel42.setText("Admit date");
        jPanel9.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 70, 20));
        jPanel9.add(dateAdmitdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 180, -1));

        combodisiseadmit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--select--", " Cardiology ", "Orthopedics", "Urology", "Obstetrics and Gynaecology", "Internal medicine", "Internal medicine", "Neurology", "General surgery", "Physical medicine and rehabilitation", " Medicine" }));
        jPanel9.add(combodisiseadmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 130, 30));

        combopasidAdmit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--selelect--", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", " ", " " }));
        jPanel9.add(combopasidAdmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 100, 20));

        comboDocidAdmit1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--selelect--", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", " ", " " }));
        jPanel9.add(comboDocidAdmit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 110, 30));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
        );

        tabepanedigonosis.addTab("Admition", jPanel5);

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setText("Pasant name");
        jPanel10.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 80, 30));
        jPanel10.add(txtpascontact, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 150, -1));

        jLabel17.setText("Contact no:");
        jPanel10.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 70, 20));
        jPanel10.add(patientId, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 150, -1));

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

        jPanel10.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 630, 90));

        jLabel19.setText("Doctor id");
        jPanel10.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 60, 20));
        jPanel10.add(txtAppodocName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 150, -1));

        jLabel20.setText("Doctor Name");
        jPanel10.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 80, -1));

        jLabel21.setText("Qualification");
        jPanel10.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 80, 20));

        jLabel22.setText("Visiting time");
        jPanel10.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 80, 20));

        comboVisitingtime1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chos Time", "09:00am to 12:00pm", "12:00pm  to  03:00pm", "03:00 pm to 06:00pm", "05:00pm to 10:00pm", " ", " " }));
        jPanel10.add(comboVisitingtime1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 150, -1));

        jLabel23.setText("Visiting Date");
        jPanel10.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 70, 20));
        jPanel10.add(dateappointVisiring, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 150, -1));

        jLabel24.setText("Pasant id");
        jPanel10.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 70, 30));

        btnappoResat.setText("New");
        btnappoResat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnappoResatMouseClicked(evt);
            }
        });
        jPanel10.add(btnappoResat, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 110, -1));

        btnAppodelet.setText("Delet");
        btnAppodelet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAppodeletMouseClicked(evt);
            }
        });
        btnAppodelet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAppodeletActionPerformed(evt);
            }
        });
        jPanel10.add(btnAppodelet, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 110, -1));

        btnappoadd.setText("ADD Appointment");
        btnappoadd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnappoaddMouseClicked(evt);
            }
        });
        jPanel10.add(btnappoadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 110, -1));

        btnappoupdat.setText("Update");
        btnappoupdat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnappoupdatMouseClicked(evt);
            }
        });
        jPanel10.add(btnappoupdat, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 110, -1));

        comboappointQualification.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--selact--", " Cardiology ", "Orthopedics", "Urology", "Obstetrics and Gynaecology", "Internal medicine", "Internal medicine", "Neurology", "General surgery", "Physical medicine and rehabilitation", " " }));
        jPanel10.add(comboappointQualification, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 150, 30));

        btndocidsearch.setText("search");
        btndocidsearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btndocidsearchMouseClicked(evt);
            }
        });
        jPanel10.add(btndocidsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 80, -1));

        btnpasseardh.setText("search");
        btnpasseardh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnpasseardhMouseClicked(evt);
            }
        });
        jPanel10.add(btnpasseardh, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 80, -1));

        combodocid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--selelect--", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", " ", " " }));
        jPanel10.add(combodocid, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 150, -1));
        jPanel10.add(txtpname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 150, -1));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
        );

        tabepanedigonosis.addTab("Doc Appointment", jPanel6);

        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setText("Parient Info");
        jPanel12.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 20));

        jLabel26.setText("Patient ID");
        jPanel12.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 60, -1));
        jPanel12.add(txtbillpsid, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 130, 30));

        jLabel27.setText("Gender");
        jPanel12.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 50, -1));
        jPanel12.add(txtbillpasname, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 130, 30));

        jLabel28.setText("Patient Name");
        jPanel12.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 80, -1));

        buttonGroup3.add(radiobiMale);
        radiobiMale.setText("Male");
        jPanel12.add(radiobiMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        buttonGroup3.add(radiobilFemale);
        radiobilFemale.setText("Female");
        jPanel12.add(radiobilFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, -1));

        jLabel29.setText("Blood Group");
        jPanel12.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 70, 20));

        combobillBlodgrup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel12.add(combobillBlodgrup, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 90, -1));

        jLabel30.setText("Disease");
        jPanel12.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 60, 20));
        jPanel12.add(txtbillDisease, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 130, 20));

        jLabel31.setText("Admit Date");
        jPanel12.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 70, -1));
        jPanel12.add(datebillAdmitdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 120, -1));

        jLabel32.setText("Room No:");
        jPanel12.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 70, 30));

        jLabel33.setText("Doctor ID");
        jPanel12.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 60, -1));
        jPanel12.add(txtbillDocid, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 130, -1));

        jLabel34.setText("Doctor Name");
        jPanel12.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 80, 20));
        jPanel12.add(txtbillDocname, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 130, -1));

        jLabel35.setText("Discharge Date");
        jPanel12.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 80, -1));
        jPanel12.add(dateDischarge, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 130, -1));
        jPanel12.add(txtRoomNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 90, 30));

        jPanel11.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 350));

        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setText("Payment Details");
        jPanel13.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, -1));

        jLabel37.setText("Room Charges");
        jPanel13.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 90, -1));
        jPanel13.add(txtRoomCharge, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 100, 20));

        jLabel38.setText("No. of Days");
        jPanel13.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 70, -1));
        jPanel13.add(txtbillNoOfDays, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        jLabel39.setText("Service Charges");
        jPanel13.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 90, -1));
        jPanel13.add(txtDocvisit, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 100, -1));

        jLabel40.setText("Doctor visit");
        jPanel13.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 70, -1));
        jPanel13.add(txtbillServischarges, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 100, -1));

        jLabel41.setText("Total room charges");
        jPanel13.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 110, -1));
        jPanel13.add(txtTotalRoomcharge, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 70, -1));

        jLabel43.setText("Discount");
        jPanel13.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 50, -1));
        jPanel13.add(txtDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 70, -1));

        jLabel44.setText("Total Charges");
        jPanel13.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 80, -1));
        jPanel13.add(txtTotalbill, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 100, -1));

        jLabel45.setText("Payment Mode Details");
        jPanel13.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 130, -1));
        jPanel13.add(txtFinalBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 160, 20));

        jLabel46.setText("Payment Mode");
        jPanel13.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 90, -1));

        comboPaymentMode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel13.add(comboPaymentMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 80, -1));

        jLabel47.setText("Billing Date");
        jPanel13.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 70, -1));
        jPanel13.add(dateBillingDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 110, -1));

        jLabel48.setText("Bill No:");
        jPanel13.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 50, -1));
        jPanel13.add(jTextField28, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 150, -1));

        jPanel11.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 390, 230));

        jButton4.setText("Add");
        jPanel11.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, -1, -1));

        jButton5.setText("Update");
        jPanel11.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, -1, -1));

        jButton8.setText("New");
        jPanel11.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, -1, -1));

        jButton9.setText("Hoom");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, -1, -1));

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

        tabbillTabil.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(tabbillTabil);

        jPanel11.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 400, 170));

        jButton11.setText("search");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 120, -1));

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

        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel49.setText("Room");
        jPanel14.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 60, 30));

        txtRoomType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Catagory--", "AC CABIN", "NoN AC CABIN", "AC WORD", "NON AC WORD" }));
        jPanel14.add(txtRoomType, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 130, 150, 30));

        jLabel50.setText("Room Type");
        jPanel14.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 80, 30));

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        jPanel14.add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 90, 30));

        jLabel51.setText("Room Price");
        jPanel14.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));
        jPanel14.add(txtRoomPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 182, 120, 30));

        tableRoomlist.setModel(new javax.swing.table.DefaultTableModel(
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
        tableRoomlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableRoomlistMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableRoomlist);

        jPanel14.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 640, 100));
        jPanel14.add(txtRoomNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 150, 30));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabepanedigonosis.addTab("Room", jPanel8);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 499, Short.MAX_VALUE)
        );

        tabepanedigonosis.addTab("tab6", jPanel15);

        jPanel3.add(tabepanedigonosis, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 530));

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        tabepanedigonosis.setSelectedIndex(0);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void btnAppodeletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAppodeletActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAppodeletActionPerformed

    private void btnappoaddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnappoaddMouseClicked
        // TODO add your handling code here:
       sql="insert into appointment (pasant_id,pasantname,address,contactno,doctorid,doctorname,qualification,visitingtime,date)values(?,?,?,?,?,?,?,?,?)";
//        sql="select  pasntinformation.pasantid ,pasntinformation.name,pasntinformation.assres,doctorinformation.id,"
//                + "doctorinformation.name from pasntinformation inner join doctorinformation on pasntinformation gender=doctorinformation gender where qualifications=?";
        String[] colums={"pasant_id","pasantname","contactno","address","doctorid","doctorname","qualification","visitingtime","date"};
         DefaultTableModel dtm1=new DefaultTableModel();
         dtm1.setColumnIdentifiers(colums);
         
         tblappointment.setModel(dtm1);
//
     
        try {
            ps=con.getcom().prepareStatement(sql);
            ps.setString(1, txtpascontact.getText().trim());

            ps.setString(2, patientId.getText().trim());
            ps.setString(3, patientId.getText().trim());

            ps.setString(4, txtappointAddress.getText().trim());
            ps.setString(5, combodocid.getSelectedItem().toString());
            ps.setString(6, txtAppodocName.getText().trim());
            ps.setString(7, comboappointQualification.getSelectedItem().toString());
            
            ps.setString(8,comboVisitingtime1.getSelectedItem().toString());
            ps.setDate(9,convertUtlToSql( dateappointVisiring.getDate()));
            
            
             ps.executeUpdate();
             getAllappointment();
            
//            while(rs.next()){
//            int pasid=rs.getInt("pasant_id");
//            String pasName=rs.getString("pasantname");
//           String pascontactno=rs.getString("contactno");
//            String pasaddress=rs.getString("address");
//            int doctorid=rs.getInt("doctorid");
//            String doctorName=rs.getString("doctorname");
//            String docqualification=rs.getString("qualification");
//            String docvisitingtime=rs.getString("Visitingtime");
//            Date datee=rs.getDate("date");
//            
//            ps.executeUpdate();
//            ps.close();
//            con.getcom().close();
//            JOptionPane.showMessageDialog(rootPane,"Add AppointMent");
//            getAllappointment();
//            
//           dtm1.addRow(new Object[]{pasid,pasName,pascontactno,pasaddress,doctorid,doctorName,docqualification,docvisitingtime,datee});
//
//            }  
            JOptionPane.showMessageDialog(rootPane, "Appointment crieated");
        } catch (SQLException ex) {
            Logger.getLogger(DigonosisFrom.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(rootPane, "No Appointment crieat");

        }
    }//GEN-LAST:event_btnappoaddMouseClicked

    private void btnappoupdatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnappoupdatMouseClicked
        // TODO add your handling code here:
        updatepesant();
    }//GEN-LAST:event_btnappoupdatMouseClicked

    private void btnappoResatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnappoResatMouseClicked
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btnappoResatMouseClicked

    private void btnAppodeletMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAppodeletMouseClicked
        // TODO add your handling code here:
         sql="delete from appointment where pasant_id=?";
       
       
        try {
            ps=con.getcom().prepareStatement(sql);
             
            ps.setInt(1,Integer.parseInt(patientId.getText()));
            
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
        
       patientId.setText(pasid);
        patientId.setText(psname);
        txtpascontact.setText(pscontact);
        txtappointAddress.setText(psaddress);
        combodocid.setSelectedItem(docid);
        txtAppodocName.setText(docname);
        comboappointQualification.setSelectedItem(docqualificarion);
        comboVisitingtime1.setSelectedItem(visitingtime);
    }//GEN-LAST:event_tblappointmentMouseClicked

    private void btndocidsearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndocidsearchMouseClicked
        // TODO add your handling code here:
        getalldoctor();
    }//GEN-LAST:event_btndocidsearchMouseClicked

    private void btnpasseardhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpasseardhMouseClicked
        // TODO add your handling code here:
        
        getAllpasant();
    }//GEN-LAST:event_btnpasseardhMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnAdmitSearchpidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdmitSearchpidMouseClicked
        // TODO add your handling code here:
        
        
        
         sql="select name,gender,age,blodgroup,disease from pasantinformation where pasantid=?";
      
        try {
            ps=con.getcom().prepareStatement(sql);
            
            ps.setInt(1, Integer.parseInt(combopasidAdmit.getSelectedItem().toString()));
            
            rs=ps.executeQuery();
            
            while(rs.next()){
           txtadmitPname.setText(rs.getString("name"));
                if (rs.getString("gender").equals("Male")) {
             // Set the "Male" radio button as selected
                 radiomaleAdmit.setSelected(true);
         } else if (rs.getString("gender").equals("Female")) {
            // Set the "Female" radio button as selected
          radioFemaledAdmit.setSelected(true);
        }
          txtAdmitionage.setText(rs.getString("age"));
          comboblodgroup.setSelectedItem(rs.getString("blodgroup"));
          combodisiseadmit.setSelectedItem(rs.getString("disease"));
         
            }
        } catch (SQLException ex) {
            Logger.getLogger(DigonosisFrom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdmitSearchpidMouseClicked

    private void btnAdmitSearchdocidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdmitSearchdocidMouseClicked
        // TODO add your handling code here:
                sql="select name from doctorinformation where id=?";
      
        try {
            ps=con.getcom().prepareStatement(sql);
            
            ps.setInt(1, Integer.parseInt(comboDocidAdmit1.getSelectedItem().toString()));
            
            rs=ps.executeQuery();
            
            while(rs.next()){
            txtdocnameadmit.setText(rs.getString("name"));
         
            }
        } catch (SQLException ex) {
            Logger.getLogger(DigonosisFrom.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        search();

    }//GEN-LAST:event_btnAdmitSearchdocidMouseClicked

    private void btnaddAdmitionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnaddAdmitionMouseClicked
        // TODO add your handling code here:
       
        
//         sql="insert into appointment (pasant_id,pasantname,address,contactno,doctorid,doctorname,qualification,visitingtime,date)values(?,?,?,?,?,?,?,?,?)"; 
        
         sql="insert into   hospitaladmition (pasantid,panantname,gender,age,blodgroup,disease,roomid,roomtype,doctorid,doctorname,admitdate)values(?,?,?,?,?,?,?,?,?,?,?)";
         
         String gender = "";

        if (radiomaleAdmit.isSelected()) {
            gender = "Male";
        } else if (radioFemaledAdmit.isSelected()) {
            gender = "Female";
        }
        try {
            

            
            ps=con.getcom().prepareStatement(sql);
            ps.setInt(1,Integer.parseInt(combopasidAdmit.getSelectedItem().toString()));
            ps.setString(2, txtadmitPname.getText().trim());
            ps.setString(3, gender);
            ps.setString(4, txtAdmitionage.getText().trim());
            ps.setString(5, comboblodgroup.getSelectedItem().toString());
            ps.setString(6, combodisiseadmit.getSelectedItem().toString());
            ps.setString(7, comboRoomnumber.getSelectedItem().toString());
            ps.setString(8, txtRoomTypeSearch.getSelectedItem().toString());
            ps.setInt(9, comboDocidAdmit1.getSelectedIndex());

            ps.setString(10, txtdocnameadmit.getText().trim());
            
            ps.setDate(11,convertUtlToSql( dateAdmitdate.getDate()));
            ps.executeUpdate();
            
             ps.close();
            con.getcom().close();
            getAlladmition();
            JOptionPane.showMessageDialog(rootPane, "Admition complit");
        } catch (SQLException ex) {
            Logger.getLogger(DigonosisFrom.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Admition has not complit");
        }
    }//GEN-LAST:event_btnaddAdmitionMouseClicked

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        sql="insert into room (roomnumber,roomtype,roomprice,statues) values(?,?,?,?)";
        
        
         
        try {
            ps=con.getcom().prepareStatement(sql);
            ps.setString(1, txtRoomNumber.getText().trim());
            ps.setString(2, txtRoomType.getSelectedItem().toString());
            ps.setDouble(3, Double.parseDouble(txtRoomPrice.getText().trim()));
            ps.setString(4, "unbocked");
            
            
            ps.executeUpdate();
             ps.close();
             con.getcom().close();
             
             JOptionPane.showMessageDialog(rootPane, "Data Saved");
             
        } catch (SQLException ex) {
            Logger.getLogger(DigonosisFrom.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
           
            
            
        
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        
        sql="select * from room where roomtype=? and roomnumber=?";
        
        
        
        try {
            ps=con.getcom().prepareCall(sql);
            
            ps.setString(1, comboRoomnumber.getSelectedItem().toString());
            ps.setString(2, txtRoomTypeSearch.getSelectedItem().toString());
            rs=ps.executeQuery();
           while(rs.next()){
              txtRoomNo.setText(rs.getString("roomNumber"));
            
            
                
            }
                JOptionPane.showMessageDialog(rootPane, "Room is not Available ");
            
        } catch (SQLException ex) {
            Logger.getLogger(DigonosisFrom.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton11ActionPerformed

    private void BtnDashbordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnDashbordMouseClicked
        // TODO add your handling code here:
        tabepanedigonosis.setSelectedIndex(0);
    }//GEN-LAST:event_BtnDashbordMouseClicked

    private void btnUpdatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdatMouseClicked
        // TODO add your handling code here:
        updatadmition();
    }//GEN-LAST:event_btnUpdatMouseClicked

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        tabepanedigonosis.setSelectedIndex(3);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jbtnroommaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnroommaActionPerformed
        // TODO add your handling code here:
        tabepanedigonosis.setSelectedIndex(4);
    }//GEN-LAST:event_jbtnroommaActionPerformed

    private void tableRoomlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableRoomlistMouseClicked
        // TODO add your handling code here:
         int row = tableRoomlist.getSelectedRow();

        String roomnumber = tableRoomlist.getModel().getValueAt(row, 0).toString();
        String roomtype = tableRoomlist.getModel().getValueAt(row, 1).toString();
        String roomprice = tableRoomlist.getModel().getValueAt(row, 2).toString();
        
        

      txtRoomNumber.setText(roomnumber);
        txtRoomType.setSelectedItem(roomtype);
        txtRoomPrice.setText(roomprice);
       
        
        
    }//GEN-LAST:event_tableRoomlistMouseClicked

    private void txtRoomTypeSearchItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtRoomTypeSearchItemStateChanged
        // TODO add your handling code here:
        String roomtype= txtRoomTypeSearch.getSelectedItem().toString();
        
        getroomNumber( roomtype);
        
        
        
    }//GEN-LAST:event_txtRoomTypeSearchItemStateChanged

//    public void search(){
//        sql="select * from room where roomnumber=? and roomtype=?";
//        
//        
//        
//        try {
//            ps=con.getcom().prepareCall(sql);
//            
//            ps.setString(1, comboRoomnumber.getSelectedItem().toString());
//            ps.setString(2, txtRoomTypeSearch.getSelectedItem().toString());
//            rs=ps.executeQuery();
//            if(rs.next()){
//                JOptionPane.showMessageDialog(rootPane, "Room Available ");
//            }
//            else{
//                JOptionPane.showMessageDialog(rootPane, "Room is not Available ");
//            }
//                
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(DigonosisFrom.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    
    
     
    
    
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
    private javax.swing.JButton BtnDashbord;
    private javax.swing.JButton btnAdmitSearchdocid;
    private javax.swing.JButton btnAdmitSearchpid;
    private javax.swing.JButton btnAppodelet;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnUpdat;
    private javax.swing.JButton btnaddAdmition;
    private javax.swing.JButton btnappoResat;
    private javax.swing.JButton btnappoadd;
    private javax.swing.JButton btnappoupdat;
    private javax.swing.JButton btndocidsearch;
    private javax.swing.JButton btnpasseardh;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> comboDocidAdmit1;
    private javax.swing.JComboBox<String> comboPaymentMode;
    private javax.swing.JComboBox<String> comboRoomnumber;
    private javax.swing.JComboBox<String> comboVisitingtime1;
    private javax.swing.JComboBox<String> comboappointQualification;
    private javax.swing.JComboBox<String> combobillBlodgrup;
    private javax.swing.JComboBox<String> comboblodgroup;
    private javax.swing.JComboBox<String> combodisiseadmit;
    private javax.swing.JComboBox<String> combodocid;
    private javax.swing.JComboBox<String> combopasidAdmit;
    private com.toedter.calendar.JDateChooser dateAdmitdate;
    private com.toedter.calendar.JDateChooser dateBillingDate;
    private com.toedter.calendar.JDateChooser dateDischarge;
    private com.toedter.calendar.JDateChooser dateappointVisiring;
    private com.toedter.calendar.JDateChooser datebillAdmitdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
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
    private javax.swing.JTextField jTextField28;
    private javax.swing.JButton jbtnroomma;
    private javax.swing.JTextField patientId;
    private javax.swing.JRadioButton radioFemaledAdmit;
    private javax.swing.JRadioButton radiobiMale;
    private javax.swing.JRadioButton radiobilFemale;
    private javax.swing.JRadioButton radiomaleAdmit;
    private javax.swing.JTable tabbillTabil;
    private javax.swing.JTabbedPane tabepanedigonosis;
    private javax.swing.JTable tableDoctor;
    private javax.swing.JTable tablePasent;
    private javax.swing.JTable tableRoomlist;
    private javax.swing.JTable tblappointment;
    private javax.swing.JTextField txtAdmitionage;
    private javax.swing.JTextField txtAppodocName;
    private javax.swing.JTextField txtDiscount;
    private javax.swing.JTextField txtDocvisit;
    private javax.swing.JTextField txtFinalBill;
    private javax.swing.JTextField txtRoomCharge;
    private javax.swing.JTextField txtRoomNo;
    private javax.swing.JTextField txtRoomNumber;
    private javax.swing.JTextField txtRoomPrice;
    private javax.swing.JComboBox<String> txtRoomType;
    private javax.swing.JComboBox<String> txtRoomTypeSearch;
    private javax.swing.JTextField txtTotalRoomcharge;
    private javax.swing.JTextField txtTotalbill;
    private javax.swing.JTextField txtadmitPname;
    private javax.swing.JTextArea txtappointAddress;
    private javax.swing.JTextField txtbillDisease;
    private javax.swing.JTextField txtbillDocid;
    private javax.swing.JTextField txtbillDocname;
    private javax.swing.JTextField txtbillNoOfDays;
    private javax.swing.JTextField txtbillServischarges;
    private javax.swing.JTextField txtbillpasname;
    private javax.swing.JTextField txtbillpsid;
    private javax.swing.JTextField txtdocnameadmit;
    private javax.swing.JTextField txtpascontact;
    private javax.swing.JTextField txtpname1;
    // End of variables declaration//GEN-END:variables
}
