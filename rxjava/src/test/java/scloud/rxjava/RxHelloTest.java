package scloud.rxjava;

import org.junit.jupiter.api.Test;

public class RxHelloTest {

    @Test
    public void createObTest() {
        RxHello rxHello = new RxHello();
        rxHello.createOb();
    }

    @Test
    public void deferObTest() {
        RxHello rxHello = new RxHello();
        rxHello.deferOb();
    }

    @Test
    public void windowTest() throws Exception {
        RxHello rxHello = new RxHello();
        rxHello.window();
    }
}
