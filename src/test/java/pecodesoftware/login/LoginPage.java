package pecodesoftware.login;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;


public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By loginButonBy = By.xpath("//input[@type='submit']");
    private By passwordInputBy = By.xpath("//input[@type='password']");
    private By usernameInputBy = By.xpath("//input[@type='text']");

    @FindBy(xpath = "//input[@type='text']")
    private WebElement usernameInput;

    @FindBy (xpath = "//input[@type='password']")
    private WebElement passwordInput;

    @FindBy (xpath = "//input[@type='submit']")
    private WebElement loginButon;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }
    public void open(){
        driver.get("https://www.pecodesoftware.com/qa-portal/registerlogin/registerlogin.php");
    }

    public void loader(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButonBy));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInputBy));
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInputBy));
    }
    public void checkingAllElementsAreAvailable(){
        Assert.assertEquals(true, loginButon.isDisplayed());
        Assert.assertEquals(true, passwordInput.isDisplayed());
        Assert.assertEquals(true, usernameInput.isDisplayed());
    }

}
