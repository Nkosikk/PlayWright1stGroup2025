package ExtentReport;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Calendar;
import java.util.Date;

public class ExtentReportLister implements ITestListener {

    private static final String OUTPUT_FOLDER = "target/ExtentReports/";
    private static final String FILE_NAME = "ExtentReport.html";

    private static ExtentReports extent = init();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private static ExtentReports extentReports;


    public static ExtentReports init() {
        Path path = Path.of(OUTPUT_FOLDER);
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (Exception e) {
                throw new RuntimeException("Failed to create output directory: " + OUTPUT_FOLDER, e);
            }
        }
        extentReports = new ExtentReports();
        ExtentSparkReporter reporter = new ExtentSparkReporter(OUTPUT_FOLDER + FILE_NAME);
        reporter.config().setReportName("Swag Labs Automation Test Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
        extentReports.setSystemInfo("User Name", System.getProperty("user.name"));

        return extentReports;
    }

    public synchronized void onStart(ITestContext context) {
        if (extent != null) {
            extent.flush();
            test.remove();
        }
    }

    public synchronized void onFinish(ITestContext context) {
        if (extent != null) {
            extent.flush();
        }
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        String qualifiedName = result.getMethod().getQualifiedName();
        int last = qualifiedName.lastIndexOf(".");
        int mid = qualifiedName.substring(0, last).lastIndexOf(".");
        String className = qualifiedName.substring(mid + 1, last);
        System.out.println(methodName + "Started! ");
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
        extentTest.assignCategory(result.getTestContext().getSuite().getName());

        extentTest.assignCategory(className);
        test.set(extentTest);
        test.get().getModel().setStartTime(getTime(result.getStartMillis()));
    }

    public synchronized void onTestSuccess(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " Passed!");
        test.get().pass("Test passed");
//        test.get().pass(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());

        test.get().getModel().setEndTime(getTime(result.getEndMillis()));
    }

    public synchronized void onTestFailure(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " Failed!");
//        test.get().fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
        test.get().getModel().setEndTime(getTime(result.getEndMillis()));
    }

    public synchronized void onTestSkipped(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " Skipped!");
//        test.get().skip(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
        test.get().getModel().setEndTime(getTime(result.getEndMillis()));
    }

    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " Failed but within success percentage!");
        test.get().fail(result.getThrowable());
        test.get().getModel().setEndTime(result.getTestContext().getEndDate());
    }

    private Date getTime(long mills) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(mills);
        return calendar.getTime();
    }


    public static void flush() {
        if (extent != null) {
            extent.flush();
        }
    }
}
