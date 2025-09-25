package cartest;

import car.Car;

public class CarTester {
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
                System.out.println("-----------------------------------");
        c2.displayInfo();
                System.out.println("-----------------------------------");
        c3.displayInfo();
                System.out.println("-----------------------------------");
        c4.displayInfo();
                System.out.println("-----------------------------------");
        c5.displayInfo();
                System.out.println("-----------------------------------");
        c6.displayInfo();
        System.out.println("-----------------------------------");
        c7.displayInfo();
        System.out.println("-----------------------------------");
        c8.displayInfo();
        System.out.println("-----------------------------------");
        c9.displayInfo();
        System.out.println("-----------------------------------");
        c10.displayInfo();
        System.out.println("-----------------------------------");
    }
}