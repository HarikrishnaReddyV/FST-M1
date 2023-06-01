package Activities;

public class Car {
    String color;
    String transmission;
    int make;
    int tyres;
    int doors;

    public Car(int tyres, int doors) {
        this.tyres = tyres;
        this.doors = doors;
    }

    public void displayCharacteristics() {
        System.out.println("Color of the car is : " + this.color);
        System.out.println("Transmission type of the car is " + this.transmission);
        System.out.println("Make of the car is: " + this.make);
        System.out.println("Car has " + this.tyres + " tyres");
        System.out.println("Car has " + this.doors + " doors");


    }

    public void accelerate() {
        System.out.println("Car is moving forward.");
    }

    public void brake() {
        System.out.println("Car has stopped.");
    }
}
