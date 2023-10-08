
package workfor22exam;

import care.Care;
import care.Motorcycle;
import care.VehicleProp;


public class WorkFor22Exam {

   
    public static void main(String[] args) {
        VehicleProp car= new Care("3256987526", "Lambar Ginne", 2022);
        VehicleProp motobik= new Motorcycle("5289664565985558", "Royyal and File", 2016);
        
        
        car.printDetails();
        motobik.printDetails();
        
        car.start();
        motobik.start();
        
        car.stop();
        motobik.stop();
    }
    
}
