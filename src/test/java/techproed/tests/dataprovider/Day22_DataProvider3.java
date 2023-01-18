package techproed.tests.dataprovider;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

public class Day22_DataProvider3 {

    /*
In this method, we will get the data from EXCEL using DATA PROVIDER
The only difference between class 2 and class 3 is the place where we get the data
In class 2, we received the data from the class itself. In this class, we get the data from excel
 */
    HomePage homePage;
    LoginPage loginPage;
    @DataProvider
    public Object[][] customerData(){

        //    TEST DATA. GET DATA FROM EXCEL
//        PATH OF EXCEL SHEET
        String path = "./src/test/java/resources/mysmoketestdata.xlsx";
        //SHEET NAME
        String sheetName = "customer_info";
        //CAL EXCEL UTIL CLASS
        ExcelUtils excelUtils = new ExcelUtils(path, sheetName);
        //USE ONE OF THE EXCEL UTIL METHOD TO RECEIVE THE DATA FROM THE EXCEL
        Object [][] customerCredentials = excelUtils.getDataArrayWithoutFirstRow();
        //TEST DATA
        //Object [][] customerCredentials = {
        //                {"sam.walker@bluerentalcars.com","c!fas_art"},
        //                {"kate.brown@bluerentalcars.com","tad1$Fas"},
        //                {"raj.khan@bluerentalcars.com","v7Hg_va^"},
        //                {"pam.raymond@bluerentalcars.com","Nga^g6!"}
        //        };
        return customerCredentials;
    }

    public void login(){
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
        homePage = new HomePage();
        loginPage = new LoginPage();
        try {
            homePage.homePageLoginLink.click();
        }catch (Exception e){
        }

        try {
            homePage.userID.click();
            homePage.logoutLink.click();
            homePage.OK.click();
            homePage.homePageLoginLink.click();
        }catch (Exception e){

        }


    }

    @Test(dataProvider = "customerData")
    public void customerLoginTest(String username, String password){

        login();
        loginPage.email.sendKeys(username);
        loginPage.password.sendKeys(password);
        loginPage.loginButton.click();
        //Verify if login is successful
        //IF USER ID IS DISPLAYED THEN LOGIN IS SUCCESSFUL
        ReusableMethods.verifyElementDisplayed(homePage.userID);
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
