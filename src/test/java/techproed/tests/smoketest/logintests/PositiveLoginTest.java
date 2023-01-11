package techproed.tests.smoketest.logintests;

import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.sql.ResultSet;

public class PositiveLoginTest {

    HomePage homePage;
    LoginPage loginPage;
    @Test
    public void US100201_Admin_Login(){

        //Going blue rental car home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

        //Click on home page login link
        homePage = new HomePage();
        loginPage = new LoginPage();

        homePage.homePageLoginLink.click();

        //Sending credentials and clicking on login button
        loginPage.email.sendKeys("jack@gmail.com");
        loginPage.password.sendKeys("12345");
        loginPage.loginButton.click();

        ReusableMethods.waitFor(3);
        ReusableMethods.verifyElementDisplayed(homePage.userID);

        Driver.closeDriver();
    }
}
