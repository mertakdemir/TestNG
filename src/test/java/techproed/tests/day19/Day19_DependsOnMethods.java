package techproed.tests.day19;

import org.testng.annotations.Test;

public class Day19_DependsOnMethods {

    @Test
    public void homePage(){
        System.out.println("I am on the home page");
    }

    @Test
    public void searchPage(){
        System.out.println("I am on the search page");
    }

    //dependsOnMethods = "searchPage"   -> connecting checkOutPage to searchPage
    //search page will execute right before checkOutPage
    //If searchPage PASS -> execute checkOutPage
    //If searchPage FAIL -> SKIP checkOutPage

    @Test(dependsOnMethods = "searchPage")
    public void checkOutPage(){
        System.out.println("I am on the checkout page");
    }
}
