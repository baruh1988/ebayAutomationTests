package Extensions;

import Utils.CommonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UIActions extends CommonOps {

    @Step("Click web element")
    public static void clickElement(WebElement webElement) {
        webElement.click();
    }

    @Step("Hover over web element")
    public static void hoverOverElement(WebElement webElement) {
        actions.moveToElement(webElement).build().perform();
    }

    @Step("Send keys to element")
    public static void sendKeysToElement(WebElement webElement, String keysToSend) {
        webElement.sendKeys(keysToSend);
    }

    @Step("Send ENTER key to element")
    public static void pressEnter(WebElement webElement) {
        webElement.sendKeys(Keys.ENTER);
    }

    @Step("Scroll to web element")
    public static void scrollToElement(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", webElement);
    }

    @Step("Get text from element")
    public static String getText(WebElement webElement) {
        return webElement.getText();
    }

    @Step("Wait for element to be visible")
    public static void waitForElementVisible(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    @Step("Wait for element to be clickable")
    public static void waitForElementClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    @Step("Click on body")
    public static void clickBody() {
        driver.findElement(By.cssSelector("body")).click();
    }

    @Step("Switch to last tab")
    public static void goToNextTab() {
        driver.getWindowHandles().forEach( tab -> driver.switchTo().window(tab));
    }

    @Step("Close current tab")
    public static void closeTab() {
        driver.close();
    }

}
