/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hassat;

import java.util.HashSet;
import java.util.Set;


public class Hassat {

    
    public static void main(String[] args) {
       Set<String> set = new HashSet<>();
       set.add("London");
       set.add("Bangladesh");
       set.add("Amarica");
       set.add("France");
       set.add("Itali");
       set.add("London");
       
       System.out.println(set);
       
       for (String s: set) {
         System.out.print(s.toLowerCase()+ ", ");
    }
    
}}
