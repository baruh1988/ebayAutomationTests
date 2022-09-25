package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EbayRegisterPage {

    @FindBy(css = "#firstname")
    private static WebElement fNameInput;

    @FindBy(css = "#lastname")
    private static WebElement lNameInput;

    @FindBy(css = "#Email")
    private static WebElement emailInput;

    @FindBy(css = "#password")
    private static WebElement passInput;

    @FindBy(css = "#EMAIL_REG_FORM_SUBMIT")
    private static WebElement registerBtn;

    @FindBy(css = "#firstname_err")
    private static WebElement fNameErr;

    @FindBy(css = "#lastname_err")
    private static WebElement lNameErr;

    @FindBy(css = "#Email_err")
    private static WebElement emailErr;

    @FindBy(css = "#password_err")
    private static WebElement passErr;

    public WebElement getFNameInput() {
        return fNameInput;
    }

    public WebElement getLNameInput() {
        return lNameInput;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getPassInput() {
        return passInput;
    }

    public WebElement getRegisterBtn() {
        return registerBtn;
    }

    public WebElement getFNameErr() {
        return fNameErr;
    }

    public WebElement getLNameErr() {
        return lNameErr;
    }

    public WebElement getEmailErr() {
        return emailErr;
    }

    public WebElement getPassErr() {
        return passErr;
    }

}
