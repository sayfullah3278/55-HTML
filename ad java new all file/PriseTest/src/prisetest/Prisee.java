
package prisetest;

import java.util.Scanner;


public class Prisee {

   
    public static void main(String[] args) {
       Price price=new Price();
        Scanner fbi=new Scanner(System.in);
        
        System.out.println("Inter UnitPrice :");
        double unitePrice= fbi.nextDouble();
        
        System.out.println("Inter Quentaty :");
        double quentaty= fbi.nextDouble();
        
        double actualPrice=0.0;
       
        
        price .setQuantity(quentaty);
        price .setUnitPrice(unitePrice);
        
        double tootalPrice= price.CalculatTootalprice();
         double discount=0.0;
         
         if(tootalPrice>=100){
         discount=tootalPrice*.05;
         actualPrice=tootalPrice-discount;
         }
         else{
         actualPrice= tootalPrice; }
         System.out.println("you hav to pay"+Math.round(actualPrice)+"\nDiscount amount is"+discount);
         System.out.println("Thanks, stay with us");
         
    }
    
}
