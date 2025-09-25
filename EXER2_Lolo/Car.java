package car;

public class Car {
    private String brand;
    private String color;
    private String plateNo;
    private String chassisNo;
    private String fuelType;
    private int maxSpeed;
    private int year;
    private double price;

    public Car() {
        this.brand = "Unknown Brand";
        this.color = "No Color";
        this.plateNo = "No Plate Number";
        this.chassisNo = "No Chassis Number Yet!";
        this.fuelType = "Unknown Fuel";
        this.maxSpeed = 0;
        this.year = 0;
        this.price = 0.0;
    }

    public Car(String brand, String color, String plateNo, String chassisNo, 
               String fuelType, int maxSpeed, int year, double price) {
        this.brand = brand;
        this.color = color;
        this.plateNo = plateNo;
        this.chassisNo = chassisNo;
        this.fuelType = fuelType;
        this.maxSpeed = maxSpeed;
        this.year = year;
        this.price = price;
    }

    public void displayInfo() {
        String info = "";
        info += "Brand: " + this.brand;
        info += "\nColor: " + this.color;
        info += "\nPlate No: " + this.plateNo;
        info += "\nChassis No: " + this.chassisNo;
        info += "\nFuel Type: " + this.fuelType;
        info += "\nMax Speed: " + this.maxSpeed + " km/h";
        info += "\nYear: " + this.year;
        info += "\nPrice: $" + this.price;
        System.out.println(info);
    }
}