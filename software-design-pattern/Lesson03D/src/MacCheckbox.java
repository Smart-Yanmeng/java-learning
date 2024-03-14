public class MacCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Render a checkbox in macOS style");
    }

    @Override
    public void onClick() {
        System.out.println("Click on a checkbox in macOS style");
    }
}
