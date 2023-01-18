package techproed.tests.listeners;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import techproed.utilities.Driver;

//USE @LISTENER ANNOTATION TO CONNECT TEST CLASS TO THE LISTENERS
//techproed.utilities.Listeners.class --> PATH OPF LISTENERS UTILITY
@Listeners(techproed.utilities.Listeners.class)
public class ListenersTest1 {

    @Test
    public void test1(){
        System.out.println("Test Case 1 PASSED");
        Assert.assertTrue(true);
    }

    @Test
    public void test2(){
        System.out.println("Test Case 2 FAILED");
        Assert.assertTrue(false);
    }

    @Test
    public void test3(){
        System.out.println("Test Case 3 SKIPPED");
        throw new SkipException("SKIP THIS TEST CASE");
    }

    @Test
    public void test4(){
        System.out.println("Test Case 4 NO SUCH ELEMENT EXCEPTION");
        Driver.getDriver().get("https://www.techproeducation.com/");
        Driver.getDriver().findElement(By.xpath("aldjfaldf"));//NO SUCH ELEMENT EXCEPTION
    }
}
