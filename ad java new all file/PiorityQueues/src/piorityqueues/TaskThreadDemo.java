
package piorityqueues;

import pac.Printnumber;


public class TaskThreadDemo {

    
    public static void main(String[] args) {
        Printnumber pn1=new Printnumber("sabit");
        Printnumber pn2=new Printnumber("limon");
        Printnumber pn3=new Printnumber("rahid");
        Printnumber pn4=new Printnumber("samim");
        
        Thread  t1=new Thread(pn1);
        Thread  t2=new Thread(pn2);
        Thread  t3=new Thread(pn3);
        Thread  t4=new Thread(pn4);
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
        
    }
    
}
