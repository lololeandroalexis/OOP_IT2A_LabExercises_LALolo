// WaterTransport.java
public class WaterTransport extends Transportation {
    public WaterTransport(String name, int capacity) {
        super(name, capacity);
    }

    @Override
    public void move() {
        System.out.println(getName() + " is sailing on water.");
    }
}



