
import com.sun.webkit.dom.CounterImpl;
import java.util.Scanner;


public class LogicalOperatorTest {
    
    public static void main (String[] args){
        Scanner input= new Scanner(System.in);
        
//        int nnb=input.nextInt();
//        if (nnb%3==1 && nnb%2==0){
//        System.out.println("Hello");
//        }
//        else{
//        System.out.println("Bye");
//        }
//        int countre=1001;
//        int gauseNumber=(int) (Math.random()*10);
//        System.out.println(gauseNumber);
//        do{
//        System.out.println("Plis enter ur guess number");
//         int userInpute= input.nextInt();  
//        if (gauseNumber==userInpute){
////        int userInpute= input.nextInt(); 
//          System.out.println("You wine");
//          break;
//        }
//        else{
//             System.out.println("Better luck next time");
//                }
//          countre++;
//        }
//       
//        while(countre<=1005);
         int gauseNumber=(int) (Math.random()*10);
         System.out.println(gauseNumber);
         
         for(int i=1; i<=5; i++){
             System.out.println("enter your gass number");
         int user=input.nextInt();
         if(gauseNumber==user){
//         int user= input.nextInt();
             System.out.println("you wine game");
         }
         else {
         System.out.println("baterluck next time");
         }
         }
    }
    
}
