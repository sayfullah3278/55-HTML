
package working21forexam;

import java.util.Scanner;


public class Working21ForExam {

   
    public static void main(String[] args) {
       int[] Newarray=new int [100];
       
       for(int i=0; i<Newarray.length; i++){
       Newarray[i]=(int)(Math.random()*100);
       }
        System.out.println("pl enter ind num");
        Scanner sc=new Scanner(System.in);
        int uin=sc.nextInt();
        
        try {int value=Newarray[uin];
            System.out.println("Value is "+value);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("out of bounds");
        }
    }
    
}
