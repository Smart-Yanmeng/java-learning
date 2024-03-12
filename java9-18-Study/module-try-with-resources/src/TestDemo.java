public class TestDemo implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("close...");
    }

    public void exec() {
        System.out.println("exec...");
    }
}
