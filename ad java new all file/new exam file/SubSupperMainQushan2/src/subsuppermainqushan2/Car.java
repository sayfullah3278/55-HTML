
package subsuppermainqushan2;


public class Car extends Vehical{

    public Car() {
    }

    public Car(String registrarionNumber, String brand, int year) {
        super(registrarionNumber, brand, year);
    }

    @Override
    public void start() {
        System.out.println("car start "); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stop() {
        System.out.println("car stope"); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
}
