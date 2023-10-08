
package qushan2;

import java.util.Scanner;

public class Qushan2 {

    public static void main(String[] args) {
        int number = 5;
        long factorial = 1;

        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        System.out.println("facktorial of number 5  :"+factorial);
    }
    
}
