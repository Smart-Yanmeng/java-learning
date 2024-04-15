public class Manual {
    private CarType carType;

    private Engine engine;

    private int seats;

    private TripComputer tripComputer;

    private GPS gps;

    private double fuel = 0;

    public Manual(CarType carType, Engine engine, int seats, TripComputer tripComputer, GPS gps) {
        this.carType = carType;
        this.engine = engine;
        this.seats = seats;
        this.tripComputer = tripComputer;
        this.gps = gps;
    }

    public String print() {
        String info = "";
        info += "=========================\n";
        info += "CarType: " + this.carType + "\n";
        info += "Engine: " + this.engine.getVolume() + "\n";
        info += "Seats: " + this.seats + "\n";
        info += "Mileage: " + this.engine.getMileage() + "\n";
        info += "=========================\n";

        return info;
    }
}
