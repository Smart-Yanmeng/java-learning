package order;

public class BigMac implements Hamburg {
    @Override
    public void render() {
        System.out.println("This is a Hamburg in McD.");
    }
}
