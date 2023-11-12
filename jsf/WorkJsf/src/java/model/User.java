package model;
// Generated 11-Nov-2023 11:12:28 by Hibernate Tools 4.3.1



/**
 * User generated by hbm2java
 */
public class User  implements java.io.Serializable {


     private String uid;
     private String fullName;
     private String userName;
     private String password;
     private String email;

    public User() {
    }

	
    public User(String uid) {
        this.uid = uid;
    }
    public User(String uid, String fullName, String userName, String password, String email) {
       this.uid = uid;
       this.fullName = fullName;
       this.userName = userName;
       this.password = password;
       this.email = email;
    }
   
    public String getUid() {
        return this.uid;
    }
    
    public void setUid(String uid) {
        this.uid = uid;
    }
    public String getFullName() {
        return this.fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }




}

