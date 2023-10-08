/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package from;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Dbcoon {
    private Connection con =null;
    private String url ="jdbc:mysql://localhost:3306/test01";
    private String userName ="root";
    private String password ="1234";
    private String driver ="com.mysql.cj.jdbc.Driver";
    
    
    public Connection getconne(){
    
        try {
            Class.forName(driver);
            
            con=DriverManager.getConnection(url,userName,password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dbcoon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Dbcoon.class.getName()).log(Level.SEVERE, null, ex);
        }
    return con;
    }
}


