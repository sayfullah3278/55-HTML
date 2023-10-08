
package qushanans3;


public class Qushanans3 {

   
    public static void main(String[] args) {
        vanical vehicle = new vanical(60, 30000, "Red");
       track truck1 = new track(70, 45000, "Blue", 2500);
        track truck2 = new track(80, 38000, "Green", 1800);

        System.out.println("Vehicle Sale Price: $" + vehicle.getSalePrice());
        System.out.println("Truck 1 Sale Price: $" + truck1.getSalePrice());
        System.out.println("Truck 2 Sale Price: $" + truck2.getSalePrice());
    }
}






