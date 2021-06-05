package sloud.hystrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HystrixCommandUsageTest {

    @Test
    public void test() {
        Assertions.assertEquals(2+2, 1+3);
    }
}
