public class TripComputer {
    private Car car;

    void showFuelLevel() {
        System.out.println(
                "Fuel level: " + this.getCar().getFuel() + "L"
        );
    }

    void showStatus() {
        System.out.println(
                "Engine status: " + (this.getCar().getEngine().isStarted() ? "started" : "not started")
        );
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
