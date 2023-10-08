
package tableconnaction;

import com.mysql.cj.xdevapi.DbDoc;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utlpakg.Dbcon;


public class Tableconnaction {

  
    public static void main(String[] args) {
   
        Dbcon con=new Dbcon();
        String sql="insert into students(id,name,age)values(?,?,?)";
        
        try {
            PreparedStatement ps= con.getcon().prepareStatement(sql);
            
            ps.setInt(1, 1);
            ps.setString(2, "hobbi");
            ps.setInt(3, 21);
            
            ps.executeUpdate();
            
            System.out.println("ok");
        } catch (SQLException ex) {
            Logger.getLogger(Tableconnaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
