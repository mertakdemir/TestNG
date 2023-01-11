package techproed.tests.homeworks;

import com.github.javafaker.Faker;
import jdk.nashorn.internal.runtime.regexp.joni.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class LoginScreenErrorMessageTest01 {



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

        //As admin or customer, I should be able to see error message,
        //when I provide a correct email address BUT incorrect password in a pop-up window
        loginPage.email.sendKeys("jack@gmail.com");
        loginPage.password.sendKeys(faker.internet().password());
        loginPage.loginButton.click();

        ReusableMethods.verifyElementDisplayed(loginPage.errorMessage);

        Driver.closeDriver();

    }
}
