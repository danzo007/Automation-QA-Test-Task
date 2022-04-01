package pecodesoftware.login;

import org.junit.Assert;
import pecodesoftware.WebDriverSettings;

public class FailCheck extends WebDriverSettings {


        public boolean failCheck(String failMassage){
            if(failMassage.equals("No account found with that username.")){
                Assert.assertEquals(failMassage,"No account found with that username.");
                return true;
            }else {
                return false;
            }
        }

}
