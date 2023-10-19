package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlatformPage extends BasePage {

    public PlatformPage(){
        this.driver = getDriver();
    }
    protected WebDriver driver;
    protected String currentWindow;

    protected By txtEmail = By.cssSelector("input[id=\"email\"]");
    protected By txtPassword = By.cssSelector("input[id=\"password\"]");
    protected By aknowledgePolicyCheckBox = By.cssSelector(".tick-box");
    protected By btnCreateAccount = By.cssSelector("#submit");
    protected  By registerForm = By.cssSelector(".form-wrap");

    public void fillUp(String email, String password) throws InterruptedException {
        System.out.println("REGISTER WITH EMAIL : " + email);
        scrollIntoElement(registerForm);
        typeIn(txtEmail,email);
        typeIn(txtPassword,password);
        clickElement(aknowledgePolicyCheckBox);
        this.currentWindow = getDriver().getWindowHandle();
        clickElement(btnCreateAccount);
    }

    public String getWindowHandle(){
        return this.currentWindow;
    }

    public String getTitle(){
        return getDriver().getTitle();
    }

}
