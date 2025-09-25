// AirTransport.java
public class AirTransport extends Transportation {
    public AirTransport(String name, int capacity) {
        super(name, capacity);
    }

    @Override
    public void move() {
        System.out.println(getName() + " is flying in the air.");
    }
}



