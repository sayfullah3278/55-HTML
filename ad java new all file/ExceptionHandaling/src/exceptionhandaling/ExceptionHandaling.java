
package exceptionhandaling;

import java.util.Arrays;
import java.util.Scanner;


public class ExceptionHandaling {

    public static void main(String[] args) {
        int [] myArray=new int [100];
        
        for(int i=0; i<myArray.length; i++){
          myArray[i]=(int)(Math.random()*100);
        }
        System.out.println(Arrays.toString(myArray));
        Scanner bmw=new Scanner(System.in);
        int userInput  = bmw.nextInt();
        
        try {
            int value= myArray[userInput];
            
            System.out.println("valu is "+ value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }
    
}
