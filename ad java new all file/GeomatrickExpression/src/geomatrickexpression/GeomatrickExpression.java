
package geomatrickexpression;

import java.util.Scanner;


public class GeomatrickExpression {

    
    public static void main(String[] args) {
        Scanner k=new Scanner (System.in);
        
        
      
        System.out.println("plis entr radious");
        double radius=k.nextInt();
        
         Circle c= new Circle();  
         
                c.setRadius(radius);
      
        System.out.println("Area"+ c.gerArea());
        System.out.println("perimeter"+ c.getPerimeter());
        
        
    }
    
}
