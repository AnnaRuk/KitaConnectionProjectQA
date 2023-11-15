package org.ait.kitaconnection.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[.='Sign In']")
    WebElement signInLink;
    public SignInPage selectSignIn() {
        click(signInLink);
        return new SignInPage(driver);
    }

    @FindBy(id = "signOutBtn")
    WebElement signOut;
    public HomePage verifySignOutBtnIsPresent(String signOutBtn) {
        Assert.assertTrue(shouldHaveText(signOut,signOutBtn,10));
        return this;
    }

    @FindBy(xpath = "//a[.='Sign Up']")
    WebElement signUpLink;
    public SignUpPage selectSignUp() {
        click(signUpLink);
        return new SignUpPage(driver);
    }

    @FindBy(id = "allKitasBtn")
    WebElement allKindergartensLink;
    public AllKitasPage selectAllKindergartens() {
        click(allKindergartensLink);
        return new AllKitasPage(driver);
    }

    @FindBy(id = "myAccountBtn")
    WebElement myAccLink;
    public UserAccountPage selectMyAccLink() {
        click(myAccLink);
        return new UserAccountPage(driver);
    }

    public ManagerAccountPage selectMyAccManagerLink() {
        click(myAccLink);
        return new ManagerAccountPage(driver);
    }

    @FindBy(xpath = "//a[.='Sign Out']")
    WebElement signOutBtn;
    public SignInPage signOut() {
        click(signOutBtn);
        new SignInPage(driver).isTextPresent(signInLink,"Sign In");
        return new SignInPage(driver);
    }
}
