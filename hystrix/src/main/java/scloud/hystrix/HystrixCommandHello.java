package scloud.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import scloud.common.LogUtil;

public class HystrixCommandHello extends HystrixCommand<String> {


    private final String name;
    private final boolean exception;

    public HystrixCommandHello(String name) {
        this(name, false);
    }

    public HystrixCommandHello(String name, boolean exception) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
        this.exception = exception;
    }

    @Override
    protected String run() throws Exception {
        LogUtil.log("run");
        if (this.exception) {
            throw new RuntimeException("oops");
        } else {
            return "hello " + this.name;
        }
    }

    @Override
    protected String getFallback() {
        return "oops " + this.name;
    }
}
