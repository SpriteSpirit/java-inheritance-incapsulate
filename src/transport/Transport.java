package transport;

public abstract class Transport {
    protected String brand;
    protected String model;
    protected final int year;
    protected final String country;
    protected String color;
    protected float maxSpeed;
    protected float fuelPercentage;

    // constructors                                     --------------------------------------------*********
    public Transport(int year, String country) {
        this.year = year;
        this.country = country;
        this.fuelPercentage = 0.0f;
    }

    public Transport(String brand, String model, int year, String country) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.country = country;
        this.fuelPercentage = 0.0f;
    }

    public Transport(String brand, String model, int year, String country, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.country = country;
        this.color = color;
        this.fuelPercentage = 0.0f;
    }

    public Transport(String brand, String model, int year, String country, String color, float maxSpeed) {
        this.year = year > 0 ? year : 2000;
        this.country = country != null && !country.isBlank() ? country : "No country";
        this.fuelPercentage = 0.0f;

        setBrand(brand);
        setModel(model);
        setColor(color);
        setMaxSpeed(maxSpeed);
    }

    // abstract methods                                 --------------------------------------------*********
    public abstract void refill();

    // getters and setters                              --------------------------------------------*********
    public String getBrand() {
        return brand;
    }

    protected void setBrand(String brand) {
        this.brand = brand != null && !brand.isBlank() ? brand : "No brand";
    }

    public String getModel() {
        return model;
    }

    protected void setModel(String model) {
        this.model = model != null && !model.isBlank() ? model : "No model";
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color != null && !color.isBlank() ? color : "No color";
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    protected void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed > 0 ? maxSpeed : 60;
    }

    protected final void setFuelPercentage(float fuel) {
        if (fuel < 0 || fuel > 100) {
            throw new IllegalArgumentException("Invalid fuel percentage");
        }
        // Проверяем, что значение fuel является дробным числом. ЗАЧЕМ это проверять?
        if (!String.valueOf(fuel).matches("^\\d+(\\.\\d+)?$")) {
            throw new IllegalArgumentException("Invalid fuel percentage format");
        }
        this.fuelPercentage = fuel;
    }
    public float getFuelPercentage() {
        return fuelPercentage;
    }

    // toString()                                           --------------------------------------------*********
    @Override
    public String toString() {
        return String.format("Type: %s%n" + "Brand: %s%n" + "Model: %s%n" + "Year: %s%n" + "Country: %s%n" + "Body color: %s%n" + "Max speed: %s", getClass().getName(), brand, model, year, country, color, maxSpeed);
    }
}
