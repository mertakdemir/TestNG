package techproed.tests.excelautomation;

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
        homePage.homePageLoginLink.click();
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


    }
}
