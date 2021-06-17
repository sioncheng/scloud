package scloud.rxjava;

import org.junit.jupiter.api.Test;

public class RxSchedulerTest {

    @Test
    public void test() {
        RxSchedulerHello rxSchedulerHello = new RxSchedulerHello();
        rxSchedulerHello.execute();
    }
}
