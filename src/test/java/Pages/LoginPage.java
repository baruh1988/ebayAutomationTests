package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    private By userNameInputLocator;
    private By passwordInputLocator;
    private By errorMsgSelector;
    private By continueBtnSelector;
    private By signInBtnSelector;
    private By userNameHiMsg;
    private String errorMsg;

    public LoginPage(WebDriver driver) {
        super(driver, new WebDriverWait(driver, Duration.ofSeconds(5)));
        initBys();
    }

    public void initBys() {
        userNameInputLocator = By.cssSelector("#userid");
        passwordInputLocator = By.cssSelector("#pass");
        errorMsgSelector = By.cssSelector("#errormsg");
        continueBtnSelector = By.cssSelector("#signin-continue-btn");
        signInBtnSelector = By.cssSelector("#sgnBt");
        userNameHiMsg = By.cssSelector("#gh-ug");
        errorMsg = "Oops, that's not a match.";
    }

    public By getUserNameInputLocator() {
        return userNameInputLocator;
    }

    public By getPasswordInputLocator() {
        return passwordInputLocator;
    }

    public By getErrorMsgSelector() {
        return errorMsgSelector;
    }

    public By getContinueBtnSelector() {
        return continueBtnSelector;
    }

    public By getSignInBtnSelector() {
        return signInBtnSelector;
    }

    public By getUserNameHiMsg() {
        return userNameHiMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public String enterValues(String uName, String pass) {
        visit("https://signin.ebay.com/ws/eBayISAPI.dll?SignIn&ru=https%3A%2F%2Fwww.ebay.com%2F");
        typeInto(uName, userNameInputLocator);
        if (isEnabled(continueBtnSelector)) {
            click(continueBtnSelector);
        }
        if (!checkErrMsg().equals(""))
            return checkErrMsg();
        waitUntilElementClickable(passwordInputLocator);
        typeInto(pass, passwordInputLocator);
        if (isEnabled(signInBtnSelector)) {
            click(signInBtnSelector);
        }
        if (!checkErrMsg().equals(""))
            return checkErrMsg();
        waitUntilElementsPresent(userNameHiMsg);
        return getText(userNameHiMsg);
    }

    private String checkErrMsg() {
        if (isDisplayed(errorMsgSelector))
            return getText(errorMsgSelector);
        else return "";
    }

}
