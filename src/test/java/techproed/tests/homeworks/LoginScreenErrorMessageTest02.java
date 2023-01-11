package techproed.tests.homeworks;

import com.github.javafaker.Faker;
import jdk.internal.net.http.common.Log;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class LoginScreenErrorMessageTest02 {

    //Name:
    //Login screen error messages
    //Description:
    //User should see error message when an invalid email is entered
    //Acceptance Criteria:
    //As admin or customer, I should be able to see error message, when I do not provide a complete valid email address in email address box
    //Error Message: email must be a valid email
    //When I enter a valid email domain, then I should not see the error message
    //https://email-verify.my-addr.com/list-of-most-popular-email-domains.php
    HomePage homePage;
    LoginPage loginPage;
    Faker faker;
    @Test
    public void test(){

        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

        homePage = new HomePage();
        loginPage = new LoginPage();
        faker = new Faker();


    }
}
