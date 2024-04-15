public class Director {
    void constructCityCar(Builder builder) {
        builder.setCarType(CarType.CITY_CAR);
        builder.setSeats(4);
        builder.setEngine(new Engine(2.0, 0));
        builder.setTripComputer(new TripComputer());
        builder.setGPS(new GPS("Toyota GPS Module 1.0"));
    }

    void constructSportsCar(Builder builder) {
        builder.setCarType(CarType.SPORTS_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine(3.0, 0));
        builder.setTripComputer(new TripComputer());
        builder.setGPS(new GPS("Lexus GPS Module 2.0"));
    }

    void constructSUV(Builder builder) {
        builder.setCarType(CarType.SUV);
        builder.setSeats(6);
        builder.setEngine(new Engine(5.0, 0));
        builder.setTripComputer(new TripComputer());
        builder.setGPS(new GPS("Jeep GPS Module 3.0"));
    }
}
