
package geomatrickexpression;


public class Circle {
    
    
    private double radius;
    
    //constack tor  creating

    public Circle() {
    }

   
 



    //constack tor  creating
    
     public Circle(double radius) {
        this.radius = radius;
    }

     
     
     
     
    public void setRadius(double r) {
        
        if(r>=1){
                 this.radius = r;
        }
        else{
            System.out.println("pls ent a positive number");
        }
        
//        this.radius = r;
    }

   
    
    
    
    
    public double  gerArea(){
    double area = Math.PI*radius*radius;
    
    return area;
    }
    public double getPerimeter(){
    double perimeter =2*Math.PI*radius;
    
    return perimeter;
    }
}
