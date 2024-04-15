public class Engine {
    private final double volume;

    private double mileage;

    private boolean started;

    public Engine(double volume, double mileage) {
        this.volume = volume;
        this.mileage = mileage;
    }

    void run(double speed) {
        if (started) {
            this.mileage += speed;
        }
    }

    public double getVolume() {
        return volume;
    }

    public double getMileage() {
        return mileage;
    }

    public boolean isStarted() {
        return started;
    }
}
