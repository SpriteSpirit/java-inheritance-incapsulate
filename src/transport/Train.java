package transport;

public class Train extends Transport{

    // constructors                                     --------------------------------------------*********
    public Train(int year, String country) {
        super(year, country);
    }

    public Train(String brand, String model, int year, String country) {
        super(brand, model, year, country);
    }

    public Train(String brand, String model, int year, String country, String color) {
        super(brand, model, year, country, color);
    }

    public Train(String brand, String model, int year, String country, String color, float maxSpeed) {
        super(brand, model, year, country, color, maxSpeed);
    }

    @Override
    public void refill() {
        System.out.printf("Refueling a %s with diesel%n", getBrand());
        setFuelPercentage(100f);
        System.out.printf("Fuel percentage set to: %.2f%%%n", getFuelPercentage());
    }

}
