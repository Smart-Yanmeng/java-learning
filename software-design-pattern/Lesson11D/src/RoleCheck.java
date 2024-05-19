package src;

public class RoleCheck extends Middleware {
    @Override
    public boolean check(String name, String password) {
        if (name.equals("admin")) {
            System.out.println("Hello, admin!");
            return true;
        }

        System.out.println("Hello, user!");

        return checkNext(name, password);
    }
}
