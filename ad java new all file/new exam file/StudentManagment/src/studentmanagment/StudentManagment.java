
package studentmanagment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import student.Student;


public class StudentManagment {

    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Student student= new Student();
        
        Student[] students={
        new Student("koli", 30),
        new Student("moli", 19),
        new Student("mili", 38),
        new Student("doli", 30)
        };
        
        FileOutputStream fileOutputStream=new FileOutputStream("kmskms.dat");
        ObjectOutput objectOutput =new ObjectOutputStream(fileOutputStream);
         objectOutput.writeObject(students);
         
         FileInputStream fileInputStream= new FileInputStream("kmskms.dat");
         ObjectInput objectInput =new ObjectInputStream(fileInputStream);
         Student[] newpito=(Student[])objectInput.readObject();
         
         System.out.println(Arrays.toString(newpito));
        }
    
}
