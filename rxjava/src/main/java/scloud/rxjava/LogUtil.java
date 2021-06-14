package scloud.rxjava;

public class LogUtil {

    public static void log(String message) {
        System.out.println(String.format("[%s] %s", Thread.currentThread().getName(), message));
    }
}
