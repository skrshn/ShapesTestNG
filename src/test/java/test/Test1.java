package test;

import org.testng.annotations.Test;
import testbase.TestBase;

public class Test1 extends TestBase {

    @Test
    public static void test1() {
        printMap(sortMap(putIntoAMap(list)));
    }
}
