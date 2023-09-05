package transport;

import java.time.LocalDate;

public class Car extends Transport {
    public static class Key {
        private final boolean remoteStart;
        private final boolean keylessAccess;

        // constructors                                     --------------------------------------------*********
        public Key(boolean remoteStart, boolean keylessAccess) {
            this.remoteStart = remoteStart;
            this.keylessAccess = keylessAccess;
        }

        public boolean isRemoteStart() {
            return remoteStart;
        }

        public boolean isKeylessAccess() {
            return keylessAccess;
        }

        // toString()                                           --------------------------------------------*********
        @Override
        public String toString() {
            return String.format("%n" +
                            "Remote start: %s%n" +
                            "Keyless access: %s",
                    remoteStart ? "On" : "Off",
                    keylessAccess ? "On" : "Off");
        }
    }

    // class transport.Car fields                                           --------------------------------------------*********
    private float engineVolume;
    private String transmission;
    private final String carcaseType;
    private String registrationNumber;
    private final int seats;
    private boolean isWinterTires;
    private Key key;

    // constructors transport.Car class                                    --------------------------------------------*********
    public Car(String brand, String model, int year, String country, String carcaseType, int seats) {
        super(brand, model, year, country);

        this.carcaseType = carcaseType;
        this.seats = seats;
        this.isWinterTires = checkTires(LocalDate.now().getMonthValue());

        setEngineVolume(engineVolume);
        setColor(color);
        setMaxSpeed(maxSpeed);
        setTransmission(transmission);
        setRegistrationNumber(registrationNumber);
        setKey(key);
    }

    public Car(String brand, String model, float engineVolume, int year, String country, String color, String transmission, String carcaseType, String registrationNumber, int seats, Key key) {
        super(brand, model, year, country, color);

        this.carcaseType = (carcaseType != null && !carcaseType.isEmpty() && !carcaseType.isBlank()) ? carcaseType : "Sedan";
        this.seats = Math.max(seats, 0);
        this.isWinterTires = checkTires(LocalDate.now().getMonthValue());

        setRegistrationNumber(registrationNumber);
        setEngineVolume(engineVolume);
        setColor(color);
        setMaxSpeed(maxSpeed);
        setTransmission(transmission);
        setKey(key);
    }

    // getters and setters                                       --------------------------------------------*********
    public String getCarcaseType() {
        return carcaseType;
    }

    public int getSeats() {
        return seats;
    }

    public float getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(float engineVolume) {
        this.engineVolume = (engineVolume > 0) ? engineVolume : 1.5f;
    }

    @Override
    public void refill() {
        System.out.printf("Refueling a %s with gasoline or diesel or charged%n", getBrand());
        setFuelPercentage(100f);
        System.out.printf("Fuel percentage set to: %.2f%%%n", getFuelPercentage());
    }

    public void setColor(String color) {
        this.color = (color != null && !color.isEmpty()) ? color : "White";
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = (transmission != null &&
                !transmission.isEmpty() &&
                !transmission.isBlank() &&
                !transmission.equals("Unknown")) ?
                transmission : "Manual";
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = (registrationNumber != null &&
                !registrationNumber.isEmpty() &&
                !registrationNumber.isBlank()) ?
                registrationNumber : "A 0000 AA RU";
    }

    private boolean checkTires(int month) {
        isWinterTires = month < 5 || month > 9;
        return isWinterTires;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        if (key == null) {
            key = new Key(false, false);
        }
        this.key = key;
    }

    // toString()                                           --------------------------------------------*********
    @Override
    public String toString() {
        return String.format(
                "Type: %s%n" +
                        "Brand: %s%n" +
                        "Model: %s%n" +
                        "Engine volume: %.1f%n" +
                        "Color: %s%nYear: %d%n" +
                        "Country: %s%n" +
                        "Transmission: %s%n" +
                        "Carcase type: %s%n" +
                        "Registration number: %s%n" +
                        "Seats: %d%n" +
                        "Tires: %s%n" +
                        "Key: %s",
                getClass().getName(),
                getBrand(), getModel(),
                engineVolume, getColor(),
                getYear(), getCountry(), transmission,
                carcaseType, registrationNumber,
                seats, (isWinterTires ? "winter" : "summer"),
                key);
    }
}
