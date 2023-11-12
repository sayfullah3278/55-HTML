/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import model.Studenttest;
import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.DbCon;
import util.NewHibernateUtil;




public class StudentDao {
    
    
    public boolean addStudent(Studenttest s) {
        
        Transaction t = null;

        Session session = NewHibernateUtil.getSessionFactory().openSession();

        try {
            t = session.beginTransaction();
            session.save(s);            
            t.commit();
           
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            t.rollback();
        }
        finally{
        
            session.close();
        }
        
        return false;
    }

    public void deleteStudent(int id) {
        Transaction t = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();

        try {
            t = session.beginTransaction();
            Studenttest stud = (Studenttest) session.load(Studenttest.class, new Integer(id));
            session.delete(stud);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Studenttest> getbyID(int id) {

       Studenttest student = new Studenttest();
        List<Studenttest> sList = new ArrayList<Studenttest>();

        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();

        try {
            trans = session.beginTransaction();

            Query query = session.createQuery("from Student where id= :id");
            query.setInteger("id", id);
            student = (Studenttest) query.uniqueResult();
            sList = query.list();

            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sList;
    }
    
    public List<Studenttest> viewAllStudent()
    {
      SessionFactory factory = NewHibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<Studenttest> stuList = session.createQuery("SELECT s FROM Studenttest s").list();
        
        stuList.toString();        
   
        return stuList;
    }
    
    
    public void updateStudent(Studenttest student)
    {
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            session.update(student);
            trans.commit();
        }
        catch(Exception e)
        {
            e.printStackTrace();  
        }
        
    }

//    public boolean addStudent(Studenttest student) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }


}
