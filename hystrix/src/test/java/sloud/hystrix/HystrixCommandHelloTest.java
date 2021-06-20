package sloud.hystrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import scloud.common.LogUtil;
import scloud.hystrix.HystrixCommandHello;

public class HystrixCommandHelloTest {

    @Test
    public void test() {
        LogUtil.log("test");
        HystrixCommandHello hystrixCommandHello = new HystrixCommandHello("netflix");
        String r = hystrixCommandHello.execute();
        Assertions.assertEquals("hello netflix", r);
    }

    @Test
    public void testFallback() {
        LogUtil.log("test fallback");
        HystrixCommandHello hystrixCommandHello = new HystrixCommandHello("netflix", true);
        String r = hystrixCommandHello.execute();
        Assertions.assertEquals("oops netflix", r);
    }
}
