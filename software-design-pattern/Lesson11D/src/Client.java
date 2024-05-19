package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static Server server;

    private static void init() {
        server = new Server();
        server.register("admin", "123");
        server.register("user", "123");
        server.register("York", "York233");

        Middleware middleware = Middleware.link(
                new Throttling(2),
                new UserExists(server),
                new RoleCheck()
        );

        server.setMiddleware(middleware);
    }

    public static void main(String[] args) throws IOException {

        init();

        boolean success;

        do {
            System.out.println("Enter name:");
            String name = reader.readLine();
            System.out.println("Input password:");
            String password = reader.readLine();

            success = server.logIn(name, password);
        } while (!success);
    }
}
