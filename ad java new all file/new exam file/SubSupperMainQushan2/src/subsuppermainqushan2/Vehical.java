
package subsuppermainqushan2;

public abstract class Vehical {
    String registrarionNumber;
    String brand;
    int year;

    public Vehical() {
    }

    public Vehical(String registrarionNumber, String brand, int year) {
        this.registrarionNumber = registrarionNumber;
        this.brand = brand;
        this.year = year;
    }

    public String getRegistrarionNumber() {
        return registrarionNumber;
    }

    public void setRegistrarionNumber(String registrarionNumber) {
        this.registrarionNumber = registrarionNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
        
        
    }
    
    public abstract void start();
    public abstract void stop();
    
}
