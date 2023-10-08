
package ckasswirk2407;

import java.util.Scanner;


public class CkassWirk2407 {

    public static void main(String[] args) {
        
// int data;
//    int sum=0;
//    
    Scanner input =new Scanner(System.in);
//    
//    do{System.out.print
//            ("enter an intager (the input ends if it is 0):");
//    data = input .nextInt();
//    sum+= data;
//    }while (data !=0);
//    System.out.println("This sum is "+ sum);

//  System.out.println("Pls enter item number");
        int userInput = 3;
        double max = 0;
        double min = 99999;

        for (int i = 1; i <=3; i++) {
            System.out.println("Pls enter number");
            double number = input.nextDouble();
           

            if (max<number) {
                max = number;
            }
            if (min > number) {
            min = number;
            }
        }
     
          
        System.out.println( " Maximum is " + (int)max + " Minimum is " + (int)min);
            }
    
}
