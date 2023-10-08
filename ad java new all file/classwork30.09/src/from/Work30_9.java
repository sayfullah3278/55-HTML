/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package from;

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
 * @author user
 */
public class Work30_9 extends javax.swing.JFrame {

    String sql="";
    PreparedStatement ps;
    ResultSet rs;
    Ddconnaction con=new Ddconnaction();
    /**
     * Creates new form Work30_9
     */
    public Work30_9() {
        initComponents();
         getallStu();
         
    }
    
     public Date convert(java.util.Date utilDate) {

        if (utilDate != null) {
            return new java.sql.Date(utilDate.getTime());
        }

        return null;
    }
     
     public java.util.Date convUtlDt(String date){
     
         SimpleDateFormat dateformt= new SimpleDateFormat("yyyy-MM-dd");
         
        try {
            return dateformt.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(Work30_9.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
     }
     
     public void getallStu(){
     
         String[] columns={"ID","Name","Age","Gender","Date"};
         DefaultTableModel modeli= new DefaultTableModel();
          modeli.setColumnIdentifiers(columns);
         tabtab.setModel(modeli);
         
         sql="select * from stucentinfoin";
         
        try {
            ps=con.getConn().prepareStatement(sql);
            
            rs=ps.executeQuery();
            
            while(rs.next()){
            int ID=rs.getInt("idstucentinfoin");
            String Name=rs.getString("name");
            String Age=rs.getString("age");
            String Gender=rs.getString("gender");
            Date date=rs.getDate("date");
            
            
            modeli.addRow(new Object[]{ID,Name,Age,Gender,date});
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Work30_9.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
     }
     
     public void updatStu(){
     String gender="";
     
     if(radioMale.isSelected()){
     gender="Male";
     }else if(RadioFemale.isSelected()){
     gender="Female";
     }
     sql="update stucentinfoin set name=?,age=?,gender=?,date=? where idstucentinfoin=?";
     
        try {
            ps=con.getConn().prepareStatement(sql);
            
            ps.setString(1, txtname.getText().trim());
            ps.setString(2, txtage.getText().trim());
            ps.setString(3, gender);
            ps.setDate(4, convert(datedate.getDate()));
            ps.setInt(5, Integer.parseInt(txtid.getText().trim()));
            
            ps.executeUpdate();
            ps.close();
            con.getConn().close();
            
            JOptionPane.showMessageDialog(rootPane, "Data updated");
            getallStu();
        } catch (SQLException ex) {
            Logger.getLogger(Work30_9.class.getName()).log(Level.SEVERE, null, ex);
        }
     }

     private  void resat(){
     
         txtid.setText(null);
         txtname.setText(null);
         txtage.setText(null);
         buttonGroup1.clearSelection();
         datedate.setDate(null);
         
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        RadioFemale = new javax.swing.JRadioButton();
        radioMale = new javax.swing.JRadioButton();
        txtage = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        datedate = new com.toedter.calendar.JDateChooser();
        btnsave = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btncleare = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabtab = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Wlcome to my Project");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, -1, 950, 70));

        jLabel2.setText("Date");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 80, 30));

        jLabel3.setText("ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 90, 30));

        jLabel4.setText("Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 80, 30));

        jLabel5.setText("Age");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 80, 30));

        jLabel6.setText("Gender");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 80, 30));

        buttonGroup1.add(RadioFemale);
        RadioFemale.setText("Female");
        getContentPane().add(RadioFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, -1, -1));

        buttonGroup1.add(radioMale);
        radioMale.setText("Male");
        getContentPane().add(radioMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, -1, -1));
        getContentPane().add(txtage, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 310, -1));
        getContentPane().add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 310, -1));
        getContentPane().add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 310, -1));
        getContentPane().add(datedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 310, 30));

        btnsave.setText("save");
        btnsave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsaveMouseClicked(evt);
            }
        });
        getContentPane().add(btnsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 150, 40));

        btndelete.setText("Delete");
        btndelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btndeleteMouseClicked(evt);
            }
        });
        getContentPane().add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 180, 40));

        btnupdate.setText("Update");
        btnupdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnupdateMouseClicked(evt);
            }
        });
        getContentPane().add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 130, 40));

        btncleare.setText("Cleare");
        btncleare.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncleareMouseClicked(evt);
            }
        });
        getContentPane().add(btncleare, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, 190, 50));

        tabtab.setModel(new javax.swing.table.DefaultTableModel(
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
        tabtab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabtabMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabtab);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 87, 410, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsaveMouseClicked
        // TODO add your handling code here:
        sql="insert into stucentinfoin(name,age,gender,date)values(?,?,?,?)";
        
        String gender="";
        
        if(radioMale.isSelected()){
        gender="Male";
        
        }else if(RadioFemale.isSelected()){
        gender="Female";
        }
        
        try {
            ps= con.getConn().prepareStatement(sql);
            ps.setString(1, txtname.getText().trim());
            ps.setString(2, txtage.getText().trim());
            ps.setString(3,gender);
            ps.setDate(4, convert(datedate.getDate()));
            
            ps.executeUpdate();
            ps.close();
            con.getConn().close();
           JOptionPane.showMessageDialog(rootPane, "data saved");
            getallStu();
        } catch (SQLException ex) {
            Logger.getLogger(Work30_9.class.getName()).log(Level.SEVERE, null, ex);
                   JOptionPane.showMessageDialog(rootPane, "data not save");

        }
        
    }//GEN-LAST:event_btnsaveMouseClicked

    private void btnupdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnupdateMouseClicked
        // TODO add your handling code here:
        updatStu();
    }//GEN-LAST:event_btnupdateMouseClicked

    private void tabtabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabtabMouseClicked
        // TODO add your handling code here:
        int row=tabtab.getSelectedRow();
        
        String id=tabtab.getModel().getValueAt(row, 0).toString();
        String name=tabtab.getModel().getValueAt(row, 1).toString();
        String age=tabtab.getModel().getValueAt(row, 2).toString();
        String gender=tabtab.getModel().getValueAt(row, 3).toString();
        String date=tabtab.getModel().getValueAt(row, 4).toString();
        
        txtid.setText(id);
        txtname.setText(name);
        txtage.setText(age);
        if(gender.equalsIgnoreCase("Male")){
        radioMale.setSelected(rootPaneCheckingEnabled);
        }
        else if(gender.equalsIgnoreCase("Female")){
        RadioFemale.setSelected(rootPaneCheckingEnabled);
        }
        datedate.setDate(convUtlDt(date));
        
    }//GEN-LAST:event_tabtabMouseClicked

    private void btndeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndeleteMouseClicked
        // TODO add your handling code here:
        sql="delete from stucentinfoin where idstucentinfoin=?";
        
        try {
            ps=con.getConn().prepareStatement(sql);
             
            ps.setInt(1,Integer.parseInt(txtid.getText().trim()));
            ps.executeUpdate();
            ps.close();
            con.getConn().close();
            
            JOptionPane.showMessageDialog(rootPane,"data delete");
            
            getallStu();
        } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(rootPane,"data is not delete");

            Logger.getLogger(Work30_9.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }//GEN-LAST:event_btndeleteMouseClicked

    private void btncleareMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncleareMouseClicked
        // TODO add your handling code here:
        resat();
    }//GEN-LAST:event_btncleareMouseClicked

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
            java.util.logging.Logger.getLogger(Work30_9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Work30_9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Work30_9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Work30_9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Work30_9().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RadioFemale;
    private javax.swing.JButton btncleare;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnupdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser datedate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radioMale;
    private javax.swing.JTable tabtab;
    private javax.swing.JTextField txtage;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables
}
