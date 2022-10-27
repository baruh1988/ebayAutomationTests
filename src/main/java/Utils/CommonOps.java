package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Variables {

    @BeforeClass
    @Parameters({"BrowserName", "URL", "Timeout"})
    public void startSession(@Optional("firefox") String BrowserName, @Optional("https://www.ebay.com") String URL, @Optional("5") String Timeout) {
        browserName = BrowserName;
        url = URL;
        timeout = Timeout;
        softAssert = new SoftAssert();
        initWebDriver();
    }

    @BeforeMethod
    @AfterMethod
    public void takeScreenshot() {
        Allure.addAttachment("", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("Initialize web driver")
    public static void initWebDriver() {
        switch (browserName) {
            case "chrome" -> driver = initChromeDriver();
            case "firefox" -> driver = initFirefoxDriver();
            case "edge" -> driver = initEdgeDriver();
            default -> throw new RuntimeException("Invalid browser");
        }
        driver.manage().window().maximize();
        setDriverTimeoutAndWait();
        driver.get(url);
        actions = new Actions(driver);
        ManagePages.initializeWebPages();
    }

    private static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private static WebDriver initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static WebDriver initEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

    private static void setDriverTimeoutAndWait() {
        driver.manage().timeouts().implicitlyWait(Long.parseLong(timeout), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(timeout)));
    }

    @AfterClass
    public void endSession() {
        driver.quit();
    }

}
