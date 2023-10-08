
package qushanans3;


public class track extends vanical{
  
    int weight;

    track(int speed, double regularPrice, String color, int weight) {
        super(speed, regularPrice, color);
        this.weight = weight;
    }

     @Override
    double getSalePrice() {
        if (weight > 2000) {
            return super.getSalePrice() * 0.9; // 10% discount
        } else {
            return super.getSalePrice();
        }
    }

    
    
}
