package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage extends BasePage {

    private By firstNameInputSelector;
    private By lastNameInputSelector;
    private By emailInputSelector;
    private By passwordInputSelector;
    private By createAccountBtnSelector;
    private By firstNameErrSelector;
    private By lastNameErrSelector;
    private By emailErrSelector;
    private By passwordErrSelector;

    /* Errors:
        Please enter your first name
        Please enter your last name
        Please enter your email address.
        Email address should be at least 6 characters.
        Email address is invalid. Please enter a valid email address.
        Your email address is already registered with eBay. Need help with your password?
        Please enter a password.
        At least 8 characters.
        A number or symbol.
        At least 1 letter.
        At least 1 letter, a number or symbol, at least 8 characters.
     */

    public RegistrationPage(WebDriver driver) {
        super(driver, new WebDriverWait(driver, Duration.ofSeconds(5)));
        initBys();
    }

    public void initBys() {
        firstNameInputSelector = By.cssSelector("#firstname");
        lastNameInputSelector = By.cssSelector("#lastname");
        emailInputSelector = By.cssSelector("#Email");
        passwordInputSelector = By.cssSelector("#password");
        createAccountBtnSelector = By.cssSelector("#EMAIL_REG_FORM_SUBMIT");
        firstNameErrSelector = By.cssSelector("#firstname_err");
        lastNameErrSelector = By.cssSelector("#lastname_err");
        emailErrSelector = By.cssSelector("#Email_err");
        passwordErrSelector = By.cssSelector("#password_err");
    }

    public By getFirstNameInputSelector() {
        return firstNameInputSelector;
    }

    public By getLastNameInputSelector() {
        return lastNameInputSelector;
    }

    public By getEmailInputSelector() {
        return emailInputSelector;
    }

    public By getPasswordInputSelector() {
        return passwordInputSelector;
    }

    public By getCreateAccountBtnSelector() {
        return createAccountBtnSelector;
    }

    public By getFirstNameErrSelector() {
        return firstNameErrSelector;
    }

    public By getLastNameErrSelector() {
        return lastNameErrSelector;
    }

    public By getEmailErrSelector() {
        return emailErrSelector;
    }

    public By getPasswordErrSelector() {
        return passwordErrSelector;
    }

    public void enterValues(String fName, String lName, String email, String pass) {
        visit("https://signup.ebay.com/pa/crte?mkcid=1&mkrid=711-53200-19255-0&campid=5337590775&customid=&toolid=10001");
        typeInto(fName, firstNameInputSelector);
        typeInto(lName, lastNameInputSelector);
        typeInto(email, emailInputSelector);
        typeInto(pass, passwordInputSelector);
        //click(By.cssSelector("body"));
    }

    public String getActualErrorMsg() {
        click(By.cssSelector("body"));
        if (isDisplayed(firstNameErrSelector)) {
            return getText(firstNameErrSelector);
        } else if (isDisplayed(lastNameErrSelector)) {
            return getText(lastNameErrSelector);
        } else if (isDisplayed(emailErrSelector)) {
            return getText(emailErrSelector);
        } else if (isDisplayed(passwordErrSelector)) {
            return getText(passwordErrSelector);
        }
        return "";
    }

}
