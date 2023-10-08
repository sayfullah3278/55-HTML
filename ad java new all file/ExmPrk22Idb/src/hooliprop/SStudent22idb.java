
package hooliprop;

import java.io.Serializable;


public class SStudent22idb implements Serializable{
    String name;
    int age;

    public SStudent22idb() {
    }

    public SStudent22idb(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return "SStudent22idb{" + "name=" + name + ", age=" + age + '}';
    }

   
    
}
