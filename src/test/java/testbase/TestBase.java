package testbase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.CommonMethods;
import utils.Constantz;
import utils.TxtReader;

import java.util.List;

public class TestBase extends CommonMethods {
    public static List<String> list;

    @BeforeMethod
    public void start() {
        list = TxtReader.readData(Constantz.data);
    }

    @AfterMethod
    public void close() {
        TxtReader.close();
    }
}
