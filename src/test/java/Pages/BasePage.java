package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void waitUntilVisibilityElementLocated(By locator) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void waitUntilElementsPresent(By locator) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public void waitUntilElementClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitUntilUrlContains(String urlFraction) {
        wait.until(ExpectedConditions.urlContains(urlFraction));
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public String getText(By locator) {
        return findElement(locator).getText();
    }

    public String getTxt(WebElement element) {
        return element.getText();
    }

    public WebElement typeInto(String inputText, By locator) {
        findElement(locator).sendKeys(inputText);
        return findElement(locator);
    }

    public WebElement click(By locator) {
        WebElement el = findElement(locator);
        el.click();
        return el;
    }

    public boolean isDisplayed(By locator) {
        try {
            return findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isEnabled(By locator) {
        try {
            return findElement(locator).isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void visit(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public boolean pageContainsText(String text) {
        return driver.getPageSource().contains(text);
    }

}
