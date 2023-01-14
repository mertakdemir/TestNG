package techproed.tests.homeworks;

import com.github.javafaker.Faker;
import jdk.internal.net.http.common.Log;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class LoginScreenErrorMessageTest02 {

    HomePage homePage;
    LoginPage loginPage;
    Faker faker;
    @Test
    public void test(){

        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

        homePage = new HomePage();
        loginPage = new LoginPage();
        faker = new Faker();

        homePage.homePageLoginLink.click();

        ///User should see error message when an invalid email is entered
        loginPage.email.sendKeys(faker.internet().emailAddress());
        loginPage.password.sendKeys("12345");
        loginPage.loginButton.click();

        ReusableMethods.waitFor(1);
        ReusableMethods.verifyElementDisplayed(loginPage.emailErrorMessage);

        Driver.closeDriver();

    }
}
