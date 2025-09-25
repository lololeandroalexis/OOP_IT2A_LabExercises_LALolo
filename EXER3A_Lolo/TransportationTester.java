// TransportationTester.java
public class TransportationTester {
    public static void main(String[] args) {
        // Air Transport
        Helicopter helicopter = new Helicopter(5);
        Airplane airplane = new Airplane(150);
        SpaceShuttle shuttle = new SpaceShuttle(7);

        // Land Transport
        Truck truck = new Truck(3);
        SUV suv = new SUV(7);
        Tricycle tricycle = new Tricycle(2);
        Motorcycle motorcycle = new Motorcycle(2);
        Kariton kariton = new Kariton(1);

        // Water Transport
        Boat boat = new Boat(20);
        Submarine submarine = new Submarine(30);

        // Testing move() method
        helicopter.move();
        airplane.move();
        shuttle.move();

        truck.move();
        suv.move();
        tricycle.move();
        motorcycle.move();
        kariton.move();

        boat.move();
        submarine.move();
    }
}