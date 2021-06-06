package sloud.hystrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import scloud.hystrix.HystrixCommandHello;

public class HystrixCommandHelloTest {

    @Test
    public void test() {
        System.out.println(" test thread " + Thread.currentThread().getName());
        HystrixCommandHello hystrixCommandHello = new HystrixCommandHello("netflix");
        String r = hystrixCommandHello.execute();
        Assertions.assertEquals("hello netflix", r);
    }

    @Test
    public void testFallback() {
        HystrixCommandHello hystrixCommandHello = new HystrixCommandHello("netflix", true);
        String r = hystrixCommandHello.execute();
        Assertions.assertEquals("oops netflix", r);
    }
}
