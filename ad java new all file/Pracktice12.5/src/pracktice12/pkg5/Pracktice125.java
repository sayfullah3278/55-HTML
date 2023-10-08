
package pracktice12.pkg5;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Pracktice125 {

  
    public static void main(String[] args) {
        Scanner inp= new Scanner (System.in);
        boolean continueInpt= true;
        
        do{
            try{System.out.println("Enter an integer:");
            int number= inp.nextInt();
            //display the result
                System.out.println(
                        "The number entered is"+number);
                
                continueInpt= false;
                
            }
            catch (InputMismatchException ex){
                System.out.println("Try again. ("+ "Incorrect input: an integar required)");
                inp.nextLine();//Discarb inpt
        }
        }
        while (continueInpt);
    }
    
}
