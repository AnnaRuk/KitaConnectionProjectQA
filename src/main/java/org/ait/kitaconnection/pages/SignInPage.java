package org.ait.kitaconnection.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "name-input")
    WebElement userEmailField;

    @FindBy(id = "password-input")
    WebElement passwordField;

    @FindBy(xpath = "//button[.='sigh In']")
    WebElement loginButton;

    public HomePage signIn(String userEmail, String password) {
        type(userEmailField,userEmail);
        type(passwordField, password);
        click(loginButton);

        return new HomePage(driver);
    }

    public SignInPage signInNegative(String wrongEmail, String password) { //TODO
        type(userEmailField,wrongEmail);
        type(passwordField, password);
        click(loginButton);

        return new SignInPage(driver);
    }

    @FindBy(xpath = "//div[.='Incorrect password or email']")
    WebElement errorMessage;
    public SignInPage verifyErrorMessageIsPresent() {
        new SignInPage(driver).isTextPresent(errorMessage,"Incorrect password or email");

        return this;
    }
}
