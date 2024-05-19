package src;

import java.util.HashMap;
import java.util.Map;

public class Server {

    private final Map<String, String> users = new HashMap<>();

    private Middleware middleware;

    public void setMiddleware(Middleware middleware) {
        this.middleware = middleware;
    }

    public boolean logIn(String name, String password) {
        if (middleware.check(name, password)) {
            System.out.println("Authorization have been successful!");

            return true;
        }

        return false;
    }

    public void register(String name, String password) {
        users.put(name, password);
    }

    public boolean hasName(String name) {
        return users.containsKey(name);
    }

    public boolean isValidPassword(String name, String password) {
        return users.get(name).equals(password);
    }
}
