package scloud.rxjava;

import org.junit.jupiter.api.Test;

public class LimitedSubscriberTest {

    @Test
    public void test() {
        LimitedSubscriber limitedSubscriber = new LimitedSubscriber();
        limitedSubscriber.execute(10);
    }
}
