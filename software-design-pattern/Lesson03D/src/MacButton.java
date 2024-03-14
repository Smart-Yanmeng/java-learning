public class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("Render a button in macOS style");
    }

    @Override
    public void onClick() {
        System.out.println("Click on a button in macOS style");
    }
}
