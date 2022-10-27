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

public class EbayRegistrationWorkFlow extends CommonOps {

    @Step("Enter first name")
    public static void enterFirstName(String firstName) {
        UIActions.sendKeysToElement(registerPage.getFNameInput(), firstName);
    }

    @Step("Enter last name")
    public static void enterLastName(String lastName) {
        UIActions.sendKeysToElement(registerPage.getLNameInput(), lastName);
    }

    @Step("Enter email")
    public static void enterEmail(String email) {
        UIActions.sendKeysToElement(registerPage.getEmailInput(), email);
    }

    @Step("Enter password")
    public static void enterPassword(String pass) {
        UIActions.sendKeysToElement(registerPage.getPassInput(), pass);
    }

    @Step("Fill registration information")
    public static void fillRegistrationInfo(String fName, String lName, String email, String pass) {
        enterFirstName(fName);
        enterLastName(lName);
        enterEmail(email);
        enterPassword(pass);
    }

    @BeforeMethod
    @AfterMethod
    public void takeScreenshot() {
        Allure.addAttachment("", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

}
