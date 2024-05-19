package src;

public abstract class Middleware {

    private Middleware next;

    public abstract boolean check(String email, String password);

    public static Middleware link(Middleware first, Middleware... chain) {
        Middleware head = first;
        for (Middleware nextInChain : chain) {
            head.next = nextInChain;
            head = nextInChain;
        }

        return first;
    }

    protected boolean checkNext(String name, String password) {
        if (next == null) {
            return true;
        }

        return next.check(name, password);
    }
}
