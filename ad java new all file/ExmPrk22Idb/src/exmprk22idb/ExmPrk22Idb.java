
package exmprk22idb;

import com.sun.corba.se.impl.io.IIOPInputStream;
import hooliprop.SStudent22idb;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Arrays;


public class ExmPrk22Idb {

    private static Object SStudents;

   
    public static void main(String[] args) throws IOException, ClassNotFoundException{
//        SStudent22idb ss=new SStudent22idb();
        
       SStudent22idb [] st={
           new SStudent22idb("sabit", 27),
           new SStudent22idb("kms", 21),
           new SStudent22idb("limon", 29),
           new SStudent22idb("fatama", 28),
       };
       
        FileOutputStream fileOutputStream=new FileOutputStream("SStudents.dat");
        ObjectOutput objectOutput=new ObjectOutputStream(fileOutputStream);
        
        objectOutput.writeObject(st);
        
        FileInputStream fileInputStream= new FileInputStream("SStudents.dat");
        ObjectInputStream objectInputStream= new ObjectInputStream(fileInputStream);
        
        SStudent22idb[]  newStudent=(SStudent22idb[]) objectInputStream.readObject();
        System.out.println(Arrays.toString(newStudent));
        
    }
    
}
