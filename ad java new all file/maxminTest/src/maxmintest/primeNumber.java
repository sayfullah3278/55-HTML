

package maxmintest;

import java.util.Scanner;


public class primeNumber {
    public static void main(String[] args) {
                Scanner intter= new Scanner (System.in);
                System.out.println("enter an element");
                int usrInpt= intter.nextInt();
                 
                int count=0;
                for(int i=1; i<=usrInpt; i++){
                if(usrInpt %i==0){
                    count+=1;
                }
             }
                if (count==2){
                    System.out.println("This is prim number");
                }
                else{System.out.println("This is not a prim number");
                }
    }
}
