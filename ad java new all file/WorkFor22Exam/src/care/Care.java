
package care;

import care.VehicleProp;


public class Care extends VehicleProp{

    public Care() {
    }

    public Care(String registrationNumber, String brand, int year) {
        super(registrationNumber, brand, year);
    }

    @Override
    public void start() {
          System.out.println("Car engine started"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stop() {
         System.out.println("Car engine stopped");//To change body of generated methods, choose Tools | Templates.
    }
   

   
  
    
    
    
}
