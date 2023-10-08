
package Studata;

import java.io.Serializable;


public class StudentDiscription implements Serializable{
    
    private String sname;
    private int srole;
    private String saddress;

    public StudentDiscription() {
    }

    public StudentDiscription(String sname, int srole, String saddress) {
        this.sname = sname;
        this.srole = srole;
        this.saddress = saddress;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSrole() {
        return srole;
    }

    public void setSrole(int srole) {
        this.srole = srole;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    @Override
    public String toString() {
        return "StudentDiscription{" + "sname=" + sname + ", srole=" + srole + ", saddress=" + saddress + '}';
    }
    
    

}
