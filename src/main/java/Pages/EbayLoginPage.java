package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EbayLoginPage {

    @FindBy(css = "#userid")
    public static WebElement userInput;

    @FindBy(css = "#signin-continue-btn")
    public static WebElement continueBtn;

    @FindBy(css = "#errormsg")
    public static WebElement errMsg;

    @FindBy(css = "#pass")
    public static WebElement passInput;

    @FindBy(css = "#sgnBt")
    public static WebElement signBtn;

    public WebElement getUserInput() {
        return userInput;
    }

    public WebElement getContinueBtn() {
        return continueBtn;
    }

    public WebElement getErrMsg() {
        return errMsg;
    }

    public WebElement getPassInput() {
        return passInput;
    }

    public WebElement getSignBtn() {
        return signBtn;
    }

}
