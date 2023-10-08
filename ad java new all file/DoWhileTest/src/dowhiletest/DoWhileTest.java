
package dowhiletest;

import java.util.Scanner;


public class DoWhileTest {

   
    public static void main(String[] args) {
//        Grattings g= new Greattings();
        Scanner sp= new Scanner(System.in);

        DoMath dm=new DoMath();
        
//        System.out.println("enter 1st number");
//        int n1 =sp.nextInt();
//        
//           System.out.println("enter 2nd number");
//        int n2 =sp.nextInt();
//        
//        System.out.println(dm.doMathes(n1, n2));
//        String grattings=g. grat(name);
        System.out.println("enter number");
        int  n1= sp. nextInt();
        
        System.out.println(dm.prinNumber(n1));
        
//        System.out.println("hillo godogle");
//        String n2= sp. next();
//        
//        System.out.println(dm.grat("n1","n2"));
    }
    
}
