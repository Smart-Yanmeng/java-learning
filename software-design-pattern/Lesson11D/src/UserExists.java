package src;

public class UserExists extends Middleware{

    private final Server server;

    public UserExists(Server server) {
        this.server = server;
    }

    @Override
    public boolean check(String name, String password) {

        if (!server.hasName(name)) {
            System.out.println("This email is not registered!");
            return false;
        }

        if (!server.isValidPassword(name, password)) {
            System.out.println("Wrong password!");
            return false;
        }

        return checkNext(name, password);
    }
}
