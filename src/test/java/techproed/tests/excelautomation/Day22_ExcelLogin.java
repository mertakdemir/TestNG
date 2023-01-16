package techproed.tests.excelautomation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.util.List;
import java.util.Map;

public class Day22_ExcelLogin {

    HomePage homePage;
    LoginPage loginPage;
    ExcelUtils excelUtils;
    //will store excel data
    List<Map<String,String>> allTestData;

    //1. Create a login method
    public void login(){
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
        homePage = new HomePage();
        loginPage = new LoginPage();
        ReusableMethods.waitFor(3);
        try {
            homePage.homePageLoginLink.click();
        }catch (Exception e){
        }

        try {
            ReusableMethods.waitFor(1);
            homePage.userID.click();
            ReusableMethods.waitFor(1);
            homePage.logoutLink.click();
            ReusableMethods.waitFor(1);
            homePage.OK.click();
            ReusableMethods.waitFor(1);
            homePage.homePageLoginLink.click();
            ReusableMethods.waitFor(1);
        }catch (Exception e){

        }

        ReusableMethods.waitFor(3);

    }

    @Test
    public void customerLoginTest(){

        String path = "./src/test/java/resources/mysmoketestdata.xlsx";
        String sheetName = "customer_info";
        excelUtils = new ExcelUtils(path, sheetName);
        // getDataList() method returns all excel data
        //we stored that data in allTestData variable
        allTestData = excelUtils.getDataList();
        System.out.println(allTestData);
        for (Map<String,String> eachData : allTestData){
            //Takes us to the login page
            login();
            loginPage.email.sendKeys(eachData.get("username"));
            ReusableMethods.waitFor(1);
            loginPage.password.sendKeys(eachData.get("password"));
            loginPage.loginButton.click();
            ReusableMethods.waitFor(1);
            //Verify if login is successful
            //IF USER ID IS DISPLAYED THEN LOGIN IS SUCCESSFUL
            ReusableMethods.verifyElementDisplayed(homePage.userID);


        }

    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
