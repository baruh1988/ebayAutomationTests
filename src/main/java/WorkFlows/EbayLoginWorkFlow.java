package WorkFlows;

import Extensions.UIActions;
import Utils.CommonOps;
import io.qameta.allure.Step;

public class EbayLoginWorkFlow extends CommonOps {

    @Step("Enter user name")
    public static void enterUserName(String userName) {
        UIActions.sendKeysToElement(loginPage.getUserInput(), userName);
        UIActions.waitForElementClickable(loginPage.getContinueBtn());
        UIActions.clickElement(loginPage.getContinueBtn());
    }

    @Step("Enter password")
    public static void enterPassword(String pass) {
        UIActions.waitForElementVisible(loginPage.getPassInput());
        UIActions.sendKeysToElement(loginPage.getPassInput(), pass);
        UIActions.waitForElementClickable(loginPage.getSignBtn());
        UIActions.clickElement(loginPage.getSignBtn());
    }

    @Step("Login to ebay")
    public static void loginToEbay(String userName, String pass) {
        goToLoginPage();
        enterUserName(userName);
        enterPassword(pass);
    }

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

}
