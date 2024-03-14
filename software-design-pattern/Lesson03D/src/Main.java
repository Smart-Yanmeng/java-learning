public class Main {
    public static void main(String[] args) {
        configure().render();
    }

    public static GUIFactory configure() {
        return switch (System.getProperty("os.name").toLowerCase()) {
            case "mac" -> new MacFactory();
            case "windows 11" -> new WinFactory();
            default -> throw new RuntimeException("No such factory: " + System.getProperty("os.name"));
        };
    }
}
