package scloud.rxjava;

import org.junit.jupiter.api.Test;

public class CompletableHelloTest {

    @Test
    public void test() {
        CompletableHello completableHello = new CompletableHello();
        completableHello.hello();
    }
}
