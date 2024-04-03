package src;

public final class Singleton {

    private static Singleton instance;

    public int value;

    Singleton(int value) {
        this.value = value;
    }

    public static Singleton getInstance(int value) {
        synchronized (Singleton.class) {
            if (instance == null) instance = new Singleton(value);
        }

        return instance;
    }
}
