public class WinCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Render a checkbox in Windows style");
    }

    @Override
    public void onClick() {
        System.out.println("Click on a checkbox in Windows style");
    }
}
