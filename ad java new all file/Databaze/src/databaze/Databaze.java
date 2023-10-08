
package databaze;

import floorish.Dbcoone;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Databaze {

   
    public static void main(String[] args) {
 
        Dbcoone gt=new Dbcoone();
        
        String sql="insert into studentesser(rool,name,age)values(?,?,?)";
        
        try {
            PreparedStatement rt=gt.getcon().prepareStatement(sql);
            rt.setInt(1, 3);
            rt.setString(2, "rahat");
            rt.setInt(3, 032);
            
            rt.executeUpdate();
            
            System.out.println("okkk");
        } catch (SQLException ex) {
            Logger.getLogger(Databaze.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
    
}
