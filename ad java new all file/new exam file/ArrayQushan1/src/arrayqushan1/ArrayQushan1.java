
package arrayqushan1;

import java.util.Scanner;


public class ArrayQushan1 {

   
    public static void main(String[] args) {
        int[] Array = new int [100];
        
        for(int i=0; i<Array.length; i++){
          Array[i]= (int)(Math.random()*100);
        }
        
        System.out.println("plis enter endex number:");
        Scanner jr=new Scanner (System.in);
        int usin=jr.nextInt();
        
        try { int val=Array[usin];
            System.out.println("valu is "+val);
        }
        
        catch(Exception r){
                    System.out.println(r);
        }
    }
    
}
