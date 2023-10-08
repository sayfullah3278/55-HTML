
package maxmintest;

import java.util.Scanner;


public class MaxminTest {

   
    public static void main(String[] args) {
        Scanner intter= new Scanner (System.in);
        
        System.out.println("plis enter 1st num:");
            int num1 =intter.nextInt();
        System.out.println("plis enter 2nd num:");
            int num2= intter.nextInt();
        System.out.println("plis enter 3rd num:");
            int num3= intter.nextInt();
         int maxNum=0, minNim=0;   
        
         if(num1>num2 && num1>num3){
             maxNum=num1;
         }   
         else if(num2>num1 && num2>num3){
             maxNum=num2;
         }   
         else{
             maxNum=num3;
         }   
         
         
         if(num1<num2 && num1<num3){
             minNim=num1;
         }   
         else if(num2<num1 && num2<num3){
              minNim=num2;
         }   
         else{
             maxNum=num3;
         }   
         
        System.out.println("max number"+maxNum);
        System.out.println("max number"+minNim);
            
        
    }
    
}
