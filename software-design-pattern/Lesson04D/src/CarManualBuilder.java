public class CarManualBuilder implements Builder {
    private CarType carType;

    private Engine engine;

    private int seats;

    private TripComputer tripComputer;

    private GPS gps;

    @Override
    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }

    @Override
    public void setGPS(GPS gps) {
        this.gps = gps;
    }

    Manual getResult() {
        return new Manual(carType, engine, seats, tripComputer, gps);
    }
}
