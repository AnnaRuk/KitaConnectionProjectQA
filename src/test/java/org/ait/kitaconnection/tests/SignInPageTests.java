package org.ait.kitaconnection.tests;

import org.ait.kitaconnection.pages.HomePage;
import org.ait.kitaconnection.pages.SignInPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.ait.kitaconnection.data.ManagerData.*;

public class SignInPageTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).selectSignIn();

    }

    @Test
    public void signInPositiveTest() {
        new SignInPage(driver).signIn(EMAIL,PASSWORD)
                .verifyMyAccountBtnIsPresent("My Account");

    }

    @Test
    public void signInWithWrongEmailNegativeTest() {
        new SignInPage(driver).signInNegative(WRONG_EMAIL,PASSWORD)
                .verifyErrorMessageIsPresent();
    }

    @Test
    public void signOutPositiveTest() {
        new SignInPage(driver).signIn(EMAIL,PASSWORD)
                .verifyMyAccountBtnIsPresent("My Account")
                .signOut();
    }
}
