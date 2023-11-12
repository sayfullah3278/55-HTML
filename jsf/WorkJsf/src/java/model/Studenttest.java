package model;
// Generated 11-Nov-2023 11:12:28 by Hibernate Tools 4.3.1

import dao.StudentDao;





public class Studenttest  implements java.io.Serializable {


     private Integer id;
     private String givenName;
     private String lastName;
     private String gender;
     private String subject;

    public Studenttest() {
    }

    public Studenttest(String givenName, String lastName, String gender, String subject) {
       this.givenName = givenName;
       this.lastName = lastName;
       this.gender = gender;
       this.subject = subject;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getGivenName() {
        return this.givenName;
    }
    
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getSubject() {
        return this.subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    StudentDao dao=new StudentDao();




}


