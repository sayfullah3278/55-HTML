
package javaapplication6;

import java.util.Scanner;


public class JavaApplication6 {

  
    public static void main(String[] args) {
        Scanner Int =new Scanner(System.in);
//        
//        char ch = Int.next().charAt(0);
//        
//        if (ch>=(char) 65 && ch<=(char)90){
//            System.out.println("Upper Case");
//            System.out.println((int)ch);
//            System.out.println(Integer.toBinaryString(int) ch) );
//        }

//        System.out.println(Character.highSurrogate(t));
        String originalString = "Hello, World!";
        
        String extractedSubstring = originalString.substring(7);
        
//          System.out.println("Original String: " + originalString);
        System.out.println("Extracted Substring: " + extractedSubstring);
        
    }
    
}
