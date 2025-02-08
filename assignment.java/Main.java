import java.util.ArrayList;
import java.util.List;

class Car {
    private int id;
    private String make;
    private String model;
    private boolean isAvailable;

    public Car(int id, String make, String model) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.isAvailable = true;
    }

    public int getId() { return id; }
    public boolean isAvailable() { return isAvailable; }
    public void rentCar() { isAvailable = false; }
    public void returnCar() { isAvailable = true; }

    public void displayCar() {
        System.out.println(id + ": " + make + " " + model + " - " + (isAvailable ? " Available" : " Rented"));
    }
}

class Customer {
    private int id;
    private String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
}

class Nasrentals {
    private List<Car> cars;

    public Nasrentals() {
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void showAvailableCars() {
        System.out.println("\n Welcome to Nasrentals - Drive Your Dream! ");
        System.out.println("Available Cars:");
        for (Car car : cars) {
            if (car.isAvailable()) {
                car.displayCar();
            }
        }
    }

    public void rentCar(int carId) {
        for (Car car : cars) {
            if (car.getId() == carId && car.isAvailable()) {
                car.rentCar();
                System.out.println("Car " + carId + " is all yours!!.");
                return;
            }
        }
        System.out.println(" This car is not available as of now.");
    }

    public void returnCar(int carId) {
        for (Car car : cars) {
            if (car.getId() == carId && !car.isAvailable()) {
                car.returnCar();
                System.out.println(" Car " + carId + " returned successfully.");
                return;
            }
        }
        System.out.println(" The car was not found or is already available.");
    }
}

public class Main {
    public static void main(String[] args) {
        Nasrentals agency = new Nasrentals();

        agency.addCar(new Car(1, "Lamborghini", "Urus"));
        agency.addCar(new Car(2, "Mercedes", "S-Class"));
        agency.addCar(new Car(3, "Toyota", "Prado V8"));

      
        agency.showAvailableCars();

        
        System.out.println("\n Renting Car ID 1.");
        agency.rentCar(1);
        agency.showAvailableCars();

        System.out.println("\n Returning Car ID 2");
        agency.returnCar(1);
        agency.showAvailableCars();
    }
}
