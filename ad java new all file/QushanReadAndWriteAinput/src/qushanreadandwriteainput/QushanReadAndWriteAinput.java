
package qushanreadandwriteainput;

import Studata.StudentDiscription;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;


public class QushanReadAndWriteAinput {

    private static Object fiefdg;

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        StudentDiscription sd=new StudentDiscription();
        
        StudentDiscription [] studen={
            
            new StudentDiscription("sabit", 88, "pubna"),
            new StudentDiscription("Limon", 1, "Faridpur"),
            new StudentDiscription("hasib", 38, "bhfrg")};
            
        
        FileOutputStream fileOutputStream=new FileOutputStream("fiefdg.dat");
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(studen);
        
        FileInputStream fileInputStream=new FileInputStream("fiefdg.dat");
        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
        
        
        StudentDiscription [] dddd=(StudentDiscription []) objectInputStream.readObject();
        System.out.println(Arrays.toString(dddd));
        
    }
    
}
