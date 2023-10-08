
package subsuppermainqushan2;

public class Motorcical extends Vehical{

    public Motorcical() {
    }

    public Motorcical(String registrarionNumber, String brand, int year) {
        super(registrarionNumber, brand, year);
    }

    @Override
    public void start() {
        System.out.println("Motorcycle engine started"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stop() {
        System.out.println("Motorcycle engine stooped"); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
