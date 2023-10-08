
package tryetoread.a.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class TryeToReadAFile {

    
    public static void main(String[] args) throws FileNotFoundException{
        
        File file =new File("C:\\Users\\user\\Desktop\\trest.txt");
        Scanner read=new Scanner (file);
//        printWriter pw = new printWriter(file);
       
//        pw println("hool  dava ");
//        
//        pw.close();

           
           
        if (file.length()>0){
            String tenWords=" ";
           int count=1;
           
            while(read.hasNext()){
            String word= read.next();
            
           
            tenWords+=word+" ";
            count++;
            
             if(count==10){
                System.out.println(tenWords);
                    count=1;
                    tenWords= "";
            }
//            System.out.println(read.nextLine());
        }}
        else{
            System.out.println("File is emty");
        }
        read.close();
    }
    
}
