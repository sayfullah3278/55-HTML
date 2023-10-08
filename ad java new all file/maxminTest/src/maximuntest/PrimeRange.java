
package maximuntest;

import java.util.Scanner;


public class PrimeRange {
    public static void main(String[] args) {
         Scanner s = new Scanner(System.in);
        int s1, s2;
        
         System.out.println ("Enter the lower limit :"); 
         s1 = s.nextInt();
         System.out.println ("Enter the upper limit :"); 
         s2 = s.nextInt();
         System.out.println ("The prime numbers in between the entered limits are :");
         for(int i = s1; i <= s2; i++)
         {int count=0;
             for(int j = 1; j <= i; j++)
             {
                 if(i % j == 0){
                      count += 1;
                     }
              
    }
              if (count==2){
                    System.out.println(i);
              
}

}
    }
}
