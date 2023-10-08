
package user.insart;

import java.util.Scanner;


public class UserInsart {

    
    public static void main(String[] args) {
//        Scanner sc=new Scanner (System.in);
        
//        int sum=0;
        
//        for(int i=1; i<=5; i++){
//        int number=sc.nextInt();
//        sum+= number;
//        }
//        System.out.println(sum);

Scanner sc=new Scanner(System.in);
System.out.println("plis ent elements numger");
int user =sc.nextInt();
 int sum=0;
for (int i=1; i<=user; i++){
int number=sc.nextInt();
sum+= number;
}
System.out.println(sum);
    }
    
}
