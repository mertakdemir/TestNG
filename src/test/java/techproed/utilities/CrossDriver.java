package techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class CrossDriver {

    private CrossDriver(){

    }

    //Driver.getDriver(); -> driver
    private static WebDriver driver;
    //getDriver() is used to instantiate the driver object

    public static WebDriver getDriver(String browser){

        browser = (browser == null) ? ConfigReader.getProperty("browser") : browser;

        if (driver==null){
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
            }


            //Note = Selenium 4.5
            //driver = WebDriverManager.chromedriver().create();

        }
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

        return driver;
    }

    //If driver is already being used(pointing an object)
    //Then quit the driver
    public static void closeDriver(){
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
