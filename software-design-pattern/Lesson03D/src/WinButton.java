public class WinButton implements Button {
    @Override
    public void render() {
        System.out.println("Render a button in Windows style");
    }

    @Override
    public void onClick() {
        System.out.println("Click on a button in Windows style");
    }
}
