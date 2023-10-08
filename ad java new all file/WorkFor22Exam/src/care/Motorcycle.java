
package care;

import care.VehicleProp;


public class Motorcycle extends VehicleProp{

    public Motorcycle() {
    }

    public Motorcycle(String registrationNumber, String brand, int year) {
        super(registrationNumber, brand, year);
    }

    @Override
    public void start() {
        System.out.println("Motorcycle engine started"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stop() {
        System.out.println("Motorcycle engine stopped"); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
