/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beens;

import dao.StudentDao;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;
import model.Studenttest;

/**
 *
 * @author user
 */
@ManagedBean
@SessionScoped
public class StudentManageBeans {

   private Studenttest student = new Studenttest();

    public Studenttest getStudent() {
        return student;
    }

    public void setStudent(Studenttest student) {
        this.student = student;
    }

   public void saveStudent(){
       StudentDao dao=new StudentDao();
       boolean status = dao.addStudent(student);
   
       if(status) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Data Saved", ""));
            }
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Data Not Saved", ""));
        }
   
   } 
   
   public List<Studenttest> showAllStudent(){
   StudentDao dao=new StudentDao();
       List<Studenttest> stulist=dao.viewAllStudent();
     return stulist;
   }
    
}
