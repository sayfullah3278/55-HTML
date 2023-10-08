
package modelc.newpackage;


public class Studdennt {
    private int rooll;
    private String name;
    private String email;

    public Studdennt() {
    }

    public Studdennt(int rooll, String name, String email) {
        this.rooll = rooll;
        this.name = name;
        this.email = email;
    }

    public int getRooll() {
        return rooll;
    }

    public void setRooll(int rooll) {
        this.rooll = rooll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Studdennt{" + "rooll=" + rooll + ", name=" + name + ", email=" + email + '}';
    }
    
    
}
