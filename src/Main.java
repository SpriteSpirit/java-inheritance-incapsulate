import transport.Bus;
import transport.Car;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
    }


    public static void task1() {
        separator("__");
        System.out.println("▶ TASK 1 ◀");
        separator("〰");

        // 0 object
        Car oka = new Car("Oka",
                "Swallow",
                1965,
                "Russia",
                "Hatchback",
                4
        );
        //oka.setMaxSpeed(70f);
        System.out.println(oka);
        oka.refill();                         // REFILL!
    }

    public static void task2() {
        separator("__");
        System.out.println("▶ TASK 2 ◀");
        separator("〰");

        // 1 object
        Bus maz = new Bus(
                "MAZ",
                "203",
                2010,
                "Russia",
                "Multicolor",
                100f);
        System.out.println(maz);

        separator("✖✖");
        // 2 object
        Bus paz = new Bus(
                "PAZ",
                "4230-01",
                2005,
                "Russia",
                "Grey",
                110f);
        System.out.println(paz);

        separator("✖✖");
        // 3 object
        Bus temsa = new Bus(
                "Temsa",
                "Opalin 9",
                2013,
                "Turkey",
                "Silver",
                142f);
        System.out.println(temsa);
        //temsa.setFuelPercentage(55.4f);
        temsa.refill();                         // REFILL!
    }


    static void separator(String sep) {
        System.out.println(sep.repeat(13));
    }
}