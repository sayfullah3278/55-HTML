
package hasan;


public class Student implements Comparable<Student>{
  
    int rollNo;
    String  name;

    public Student() {
    }

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" + "rollNo=" + rollNo + ", name=" + name + '}';
    }
   
    int getRoll(){
    return rollNo;
    }

    @Override
    public int compareTo(Student o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
    
}
