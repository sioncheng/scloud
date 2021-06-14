package scloud.rxjava;

import org.junit.jupiter.api.Test;

public class ObserverTest {

    @Test
    public void test() {
        ObserverHello observer = new ObserverHello();
        observer.execute();
    }
}
