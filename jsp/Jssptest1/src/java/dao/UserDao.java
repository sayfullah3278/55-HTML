/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mysql.cj.protocol.Resultset;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;
import util.DbCon;


public class UserDao {
   public static int saveUaer(User u) throws ClassNotFoundException, SQLException{
       
       int status=0;
         
         String sql="insert into user(fullName, userName, password, email)values(?,?,?,?)";
         
         PreparedStatement ps=DbCon.getCon().prepareStatement(sql);
         
         
        ps.setString(1, u.getUid());
        ps.setString(2, u.getFullName());
        ps.setString(3, u.getUserName());
        ps.setString(4, u.getPassword());
        ps.setString(5, u.getEmail());
        
        status=ps.executeUpdate();
        System.out.println(status);
         
        ps.close();
        DbCon.getCon().close();
         return status;
     }
   
   public  static List<User> login(String username, String password ) throws ClassNotFoundException, SQLException{
   
       List<User> usl=new ArrayList<>();
       
       String sql="select * from user ";
       
       PreparedStatement ps=DbCon.getCon().prepareStatement(sql);
       
       ResultSet rs= ps.executeQuery();
       
       while(rs.next()){
       User u=new User(
       
               rs.getString("uid"),
               rs.getString("fullName"),
               rs.getString("userName"),
               rs.getString("password"),
               rs.getString("email")
               
       );
       usl.add(u);
       }
       rs.close();
       ps.close();
       DbCon.getCon().close();
       return usl;
       
   }
   
   public static int login(User u) throws ClassNotFoundException, SQLException {
        int status = 0;

        String sql = "select * from user where userName=? and password=?";

        PreparedStatement ps = DbCon.getCon().prepareStatement(sql);

        ps.setString(1, u.getUserName());
        ps.setString(2, u.getPassword());

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            status = 1;

        }

        return status;   
    
    }
   
   }

