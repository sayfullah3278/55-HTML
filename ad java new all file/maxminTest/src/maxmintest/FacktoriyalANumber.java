
package maxmintest;

import java.util.Scanner;


public class FacktoriyalANumber {
    public static void main(String[] args) {
                Scanner inter= new Scanner (System.in);
                int fact=1;
                  int num=0;
                System.out.println("plis enter num");
              
                num= inter.nextInt();
                
                for( int i=1; i<=num; i++){
                fact=fact*i;
                }
                System.out.println("factorial of " +num + "  is "+fact);
    }
}
