package techproed.tests.homeworks;

import org.testng.annotations.Test;
import techproed.pages.Homework01;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Q01 {

    //https://testcenter.techproeducation.com/index.php?page=form-authentication
    //Login the application using page object model

    @Test
    public void test(){

        Driver.getDriver().get(ConfigReader.getProperty("homework01"));
        Homework01 homework01 = new Homework01();
        homework01.userName.sendKeys("techproed");
        homework01.password.sendKeys("SuperSecretPassword ");
        homework01.submitButton.click();
    }

}
