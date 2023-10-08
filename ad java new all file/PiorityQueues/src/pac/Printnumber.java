
package pac;


public class Printnumber implements Runnable{

    private String lastnumber;

    public Printnumber() {
    }

    public Printnumber(String lastnumber) {
        this.lastnumber = lastnumber;
    }

   
    
    
    
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
 System.out.print(i+"  "+this.lastnumber);
 
                 Thread.yield();
            System.out.println("  ");
           
 }
    }
    
}
