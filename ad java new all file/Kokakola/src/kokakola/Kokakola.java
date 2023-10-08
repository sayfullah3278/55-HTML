
package kokakola;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import sisu.SisuStudent;


public class Kokakola {

   
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
       
        SisuStudent student= new SisuStudent();
        
            SisuStudent [] str={
                new SisuStudent("Kobr", 0),
                new SisuStudent("Kobr", 0),
                new SisuStudent("Kobr", 0),
                new SisuStudent("Kobr", 0),
                new SisuStudent("Kobr", 0),};
            
            FileOutputStream fileOutputStream= new FileOutputStream("studenetew.dat");
            ObjectOutput  objectOutput= new ObjectOutputStream(fileOutputStream);
            
            objectOutput. writeObject(str);
            
            FileInputStream fileInputStream=new FileInputStream("studenetew.dat");
            ObjectInputStream objectInputStream= new ObjectInputStream(fileInputStream);
            
            SisuStudent [] newsisu= (SisuStudent[]) objectInputStream.readObject();
            System.out.println(Arrays.toString(newsisu));
    }
    
}
