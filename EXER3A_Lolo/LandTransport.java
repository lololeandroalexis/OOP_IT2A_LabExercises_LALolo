// LandTransport.java
public class LandTransport extends Transportation {
    public LandTransport(String name, int capacity) {
        super(name, capacity);
    }

    @Override
    public void move() {
        System.out.println(getName() + " is driving on land.");
    }
}