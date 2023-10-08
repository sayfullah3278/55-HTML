
package StackObject.newpackage;

import java.util.Comparator;
import java.util.PriorityQueue;


public class Stack {
     PriorityQueue<stacklemeny> queue=new PriorityQueue<>(10,new Comparator<stacklemeny>(){
         @Override
         public int compare(stacklemeny o1, stacklemeny o2) {
             return 1;
         }
         
     });
     int order=1;
     
     public void push(int val){
     StackElement  element = new StackElement();
         queue.add(element);
     }
      public Integer pop(){
    if(queue.isEmpty()){
        System.out.println("Stack Underflow");
        return null;
    }
    return queue.poll().value;
}
}