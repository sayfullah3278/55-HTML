
package maxmintest;

import java.util.Scanner;


public class anatherWayMaxMin {
    public static void main(String[] args) {
         Scanner intter= new Scanner (System.in);
         
         System.out.println("enter item number");
          int n = intter. nextInt();
         
         int max=0, min=999999999;
         int inputNum; int sum=0;
         int avgNum=n;
            while(n>0){
         System.out.println("Enter number");
         inputNum= intter.nextInt();
         sum += inputNum;
         
             if(max<inputNum){
          max = inputNum;
         }
         if (min>inputNum){
             min =inputNum;
         }
         n--;
            }
            avgNum=sum/avgNum;
         System.out.println("max num="+max);
         System.out.println("min num="+min );
         System.out.println("avg num="+(double)avgNum );        
         
    }
}
