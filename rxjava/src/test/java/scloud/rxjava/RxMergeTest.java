package scloud.rxjava;

import org.junit.jupiter.api.Test;

public class RxMergeTest {

    @Test
    public void test() {
        RxMerge rxMerge = new RxMerge();
        rxMerge.merge();
        /**
         * [Thread-3] one
         * [Thread-4] four
         * [Thread-4] five
         * [Thread-4] six
         * [Thread-3] two
         * [Thread-3] three
         */
    }
}
