package techproed.tests.listeners;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class ListenersTest5 {

    //    This test case FAILS
//    I will link this class to ListenersRetryAnalyzer
//    to run twice cause it fails
//    We will do this using xml files

    @Test
    public void test1() {
        Driver.getDriver().get("https://techproeducation.com/");
        Assert.assertTrue(false);
    }
}
