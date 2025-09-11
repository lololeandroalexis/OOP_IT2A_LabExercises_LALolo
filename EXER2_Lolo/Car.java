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


class CarTester {
    public static void main(String[] args) {
        Car c1 = new Car("Toyota", "Yellow", "KAW12345", "AB123", "Gasoline", 180, 2020, 25000);
        Car c2 = new Car("Honda", "Red", "SYA7890", "CD456", "Diesel", 200, 2019, 22000);
        Car c3 = new Car("Ford", "Blue", "AKO081206", "EF789", "Gasoline", 280, 2021, 30000);
        Car c4 = new Car("Rolls Royce", "Black", "ANAKO123", "7", "PULA", 250, 2022, 55000);
        Car c5 = new Car("Mercedes", "White", "LAO4546", "IJ345", "GREEN", 300, 2021, 60000);
        Car c6 = new Car("TOYOTA MK4 SUPRA", "Silver", "OPAW321", "KL678", "Green", 399, 2018, 20000);
        Car c7 = new Car("Mclarren", "Black", "WEW53576", "DISCAYA69", "Crudo", 280, 2016, 35000);
        Car c8 = new Car("Suzuki Mini Van", "Purple", "YNW6769", "OP234", "Diesel", 330, 2010, 65000);
        Car c9 = new Car("FORD", "Black", "AKP123", "QRY260", "Special", 210, 2020, 28000);
        Car c10 = new Car("Toyota AE86", "white", "JPN7", "JPN7", "Special", 400, 2014, 27000);

        c1.displayInfo();
        c2.displayInfo();
        c3.displayInfo();
        c4.displayInfo();
        c5.displayInfo();
        c6.displayInfo();
        c7.displayInfo();
        c8.displayInfo();
        c9.displayInfo();
        c10.displayInfo();
    }
}