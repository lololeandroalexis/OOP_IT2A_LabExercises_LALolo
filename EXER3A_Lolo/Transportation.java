// Transportation.java
public class Transportation {
    private String name;
    private int capacity;

    public Transportation(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public void move() {
        System.out.println(name + " is moving...");
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
}