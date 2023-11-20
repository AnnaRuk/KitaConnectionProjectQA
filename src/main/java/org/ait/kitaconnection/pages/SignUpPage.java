package org.ait.kitaconnection.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SignUpPage extends BasePage{
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName-input")
    WebElement fName;

    @FindBy(id = "lastName-input")
    WebElement lName;

    @FindBy(id = "lastName-input")
    WebElement userEmail;

    @FindBy(id = "password-input")
    WebElement userPassword;
    
    @FindBy(id = "password-repeat-input")
    WebElement confirmedUserPassword;
    

    public SignUpPage enterPersonalData(String firstName, String lastName,
                                        String email, String password, 
                                        String confirmPassword /*String role*/) {
        type(fName,firstName);
        type(lName,lastName);
        type(userEmail,email);
        type(userPassword,password);
        type(confirmedUserPassword,confirmPassword);
       /* type(chosenRole,role);*/
        
        return this;
    }


   /* @FindBy(????????????)
    WebElement male;

    @FindBy(????????????)
    WebElement female;

    @FindBy(?????????????)
    WebElement other;
    public SignUpPage selectGender(String gender) {
        if (gender.equals("Male")) {
        click(male);
    } else if (gender.equals("Female")) {
        click(female);
    } else {
        click(other);
    }
        return this;
    }*/


    @FindBy(id = "agreeCheck")
    WebElement agreementCheckbox;
    public SignUpPage selectAgreementCheckbox() {
        click(agreementCheckbox);
        return this;
    }

    @FindBy(xpath = "//button[.='Register']")
    WebElement signUpBtn;
    public SignUpPage signUp() {
        click(signUpBtn);
        return this;
    }

    @FindBy(xpath = "//div[.='Registration completed successfully! A registratio']")
    WebElement signUpMessage;
    public HomePage verifySignUpMessageIsPresent(String message) {
        Assert.assertTrue(shouldHaveText(signUpMessage,message,10));
        return new HomePage(driver);
    }

    @FindBy(id = "role-input")
    WebElement chosenRole;
    public SignUpPage selectRole(String role) {
        click(chosenRole);
        chosenRole.sendKeys(role);
        chosenRole.sendKeys(Keys.ENTER);
        return this;
    }

}
