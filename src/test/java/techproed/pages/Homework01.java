package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class Homework01 {

    public Homework01(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "exampleInputEmail1")
    public WebElement userName;

    @FindBy(id = "exampleInputPassword1")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;
}
