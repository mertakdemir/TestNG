package techproed.tests.listeners;

import jdk.internal.net.http.common.Log;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.Driver;

public class ListenersTest4 {

    HomePage homePage;
    LoginPage loginPage;

    @Test(retryAnalyzer = techproed.utilities.ListenersRetry.class)
    public void test1(){

        Driver.getDriver().get("https://www.techproeducation.com/");
        Assert.assertTrue(false);
    }
}
