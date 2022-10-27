package WorkFlows;

import Extensions.UIActions;
import Utils.CommonOps;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.ByteArrayInputStream;

public class EbayHomePageWorkFlow extends CommonOps {

    @Step("Go to registration page")
    public static void goToRegistrationPage() {
        UIActions.clickElement(homePage.getRegisterLink());
    }

    @Step("Go to login page")
    public static void goToLoginPage() {
        UIActions.clickElement(homePage.getSignInLink());
    }

    @Step("Go to home page")
    public static void goToHomePage() {
        UIActions.clickElement(homePage.getLogo());
    }

    @Step("Go to cart page")
    public static void goToCartPage() {
        UIActions.clickElement(homePage.getCartLink());
    }

    @BeforeMethod
    @AfterMethod
    public void takeScreenshot() {
        Allure.addAttachment("", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

}
