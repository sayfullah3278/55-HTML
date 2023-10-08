
package programforrecursion;

import java.util.Scanner;

public class ProgramForRecursion {

   
    public static void main(String[] args) {
        Scanner hi=new Scanner(System.in);
        
        System.out.println("Plise Enter Any number");
        int number= hi.nextInt();
        
        System.out.println("The Factorial of :"+ number+" is "+factorieal(number));
    }
    public  static int factorieal(int number){
    
        
        if (number==1){
        return 1;
        }
        else{
        return number * factorieal(number-1);}
    }
}
