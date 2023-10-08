
package sisu;

import java.io.Serializable;


public class SisuStudent implements Serializable{
    
    String name;
    int age;

    public SisuStudent() {
    }

    public SisuStudent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "SisuStudent{" + "name=" + name + ", age=" + age + '}';
    }
    
    
    
}
