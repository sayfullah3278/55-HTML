
package primenumber;

import java.util.Scanner;


public class PrimeNumber {

   
    public static void main(String[] args) {
        Scanner nm= new Scanner (System.in);
        
        System.out.println("emter number :");
        
        int num=nm.nextInt();
        int count=0;
        
        for(int i=1; i<=num; i++){
        if(num%i==0){
               count=count+1;
        }
        }
        if(count==2){
             System.out.println("prim number");   
        }
        else{
            System.out.println("not a prim number");
        }
    }
    
}
