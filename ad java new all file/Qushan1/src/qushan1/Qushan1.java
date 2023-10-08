
package qushan1;

import java.util.Scanner;


public class Qushan1 {

    
    public static void main(String[] args) {
        Scanner hr= new Scanner(System.in);
        
         int sum=0;
         while(true){
             System.out.println("Enter any Number: ");
             int num=hr.nextInt();
              if (num < 0) {
                break;
            } else if (num > 0) {
                sum += num;
            }
         }
         System.out.println("sum of positiv 8"
                 + "5"
                 + "-3"
                 + " number"+sum);
    }
    
}
