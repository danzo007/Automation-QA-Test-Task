package pecodesoftware.login;

import org.junit.*;
import org.openqa.selenium.support.PageFactory;
import pecodesoftware.Report;
import pecodesoftware.Screenshot;
import pecodesoftware.WebDriverSettings;
import io.github.cdimascio.dotenv.Dotenv;


public class Main extends WebDriverSettings {

    @Test
    public void login(){
        Report report = new Report();
        report.startTest();

        //load Dotenv
        Dotenv dotenv = Dotenv.load();


        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        //open page
        loginPage.open();
        //waiting for all elements
        loginPage.loader();
        //checking all elements are displayed
        loginPage.checkingAllElementsAreAvailable();


        Login login = PageFactory.initElements(driver, Login.class);
        //fill username and password inputs with data from .env file
        login.fillUsername(dotenv.get("USERNAME"));
        login.fillPassword(dotenv.get("PASSWORD"));
        // click on login button
        login.loginButton();
        // wait for fail massage
        login.checkFailMassage();

        FailCheck failCheck = new FailCheck();
        // if the outcome of which will decide whether the test has passed or failed
        if (failCheck.failCheck(login.getFailMassageText())){
            //take screenshot if fail
            Screenshot takeSnapShot = new Screenshot();
            try {
                takeSnapShot.takeSnapShot(driver, "src/test/testResult/test.png");
            } catch (Exception e) {
                e.printStackTrace();
            }
            String pageSource = driver.getPageSource();
            // print page source if fail
            System.out.println(pageSource);
            // report that the test has failed
            report.testResult(false);
            report.endTest();
        }else {
            // report that the test has passed
            report.testResult(true);
            report.endTest();
      }
    }
}
