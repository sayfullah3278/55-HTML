/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package callactioninterface;

import java.util.ArrayList;
import java.util.List;


public class CallactionInterface {

   
    public static void main(String[] args) {
        
        
        List<String> collaction =  new ArrayList<>();
        collaction.add("banana");
        collaction.add("apple");
        collaction.add("mango");
        System.out.println(collaction);
       
       
        collaction.remove("banana");
        System.out.println(collaction);
       
        System.out.println(collaction.contains("apple"));
       
       
        collaction.forEach((element) ->{
            System.out.println(element);
        });
        collaction.clear();
        System.out.println(collaction.toString());
    }
    
}
