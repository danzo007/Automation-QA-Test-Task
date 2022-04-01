package pecodesoftware.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
    private WebDriver driver;
    private WebDriverWait wait;

    public Login(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }
    @FindBy (xpath = "//input[@type='text']")
    private WebElement usernameInput;

    @FindBy (xpath = "//input[@type='password']")
    private WebElement passwordInput;

    @FindBy (xpath = "//input[@type='submit']")
    private WebElement loginButon;

    private By failSpanMassage = By.xpath("(//span[@class='help-block'])[1]");

    @FindBy (xpath = "(//span[@class='help-block'])[1]")
    private WebElement failMassage;

    public void fillUsername(String username){
        usernameInput.sendKeys(username);
    }

    public void fillPassword(String password){
        passwordInput.sendKeys(password);

    }

    public void loginButton(){
        loginButon.click();
    }
    public void checkFailMassage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(failSpanMassage));
    }

    public String getFailMassageText(){
        String failTextMassage = failMassage.getText();
        return failTextMassage;
    }
}