package component;

import org.springframework.stereotype.Component;

@Component("testComponent")
public class TestComponent {

    public void Test() {

        System.out.println("TestComponent");
    }
}
