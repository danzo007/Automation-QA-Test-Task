package pecodesoftware;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Report {
    static ExtentTest test;
    static ExtentReports report;
    public static void startTest()
    {
        report = new ExtentReports("src/test/testResult/ExtentReportResults.html");
        test = report.startTest("login");
    }

    public void testResult(boolean checkResult){
        if(checkResult) {
            test.log(LogStatus.PASS, "Test passed");
        } else {
            test.log(LogStatus.FAIL, "Test failed");
        }
    }
    public static void endTest()
    {
        report.endTest(test);
        report.flush();
    }
}
