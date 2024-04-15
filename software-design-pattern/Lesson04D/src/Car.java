public class Car {
    private CarType carType;

    private Engine engine;

    private int seats;

    private TripComputer tripComputer;

    private GPS gps;

    private double fuel = 0;

    public Car(CarType carType, Engine engine, int seats, TripComputer tripComputer, GPS gps) {
        this.carType = carType;
        this.engine = engine;
        this.seats = seats;
        tripComputer.setCar(this);
        this.tripComputer = tripComputer;
        this.gps = gps;
    }

    public double getFuel() {
        return fuel;
    }

    public Engine getEngine() {
        return engine;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public TripComputer getTripComputer() {
        return tripComputer;
    }

    public void setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }

    public GPS getGps() {
        return gps;
    }

    public void setGps(GPS gps) {
        this.gps = gps;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public String test() {
        return "This is a new Car with volume " + this.getEngine().getVolume();
    }
}
