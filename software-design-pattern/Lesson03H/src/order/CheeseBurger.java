package order;

public class CheeseBurger implements Hamburg {
    @Override
    public void render() {
        System.out.println("This is a CheeseBurger in KFC.");
    }
}
