package org.ait.kitaconnection.tests;

import org.ait.kitaconnection.data.UserData;
import org.ait.kitaconnection.pages.HomePage;
import org.ait.kitaconnection.pages.SignUpPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpPageTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).selectSignUp();
    }

    @Test
    public void fillSignUpForm() {
        new SignUpPage(driver).enterPersonalData(UserData.FIRST_NAME,UserData.LAST_NAME,
                UserData.EMAIL,UserData.PASSWORD,UserData.CONFIRM_PASSWORD)
                //.selectGender(UserData.GENDER)
                .selectRole(UserData.ROLE)
                .selectAgreementCheckbox()
                .signUp()
                .verifySignOutBtnIsPresent("Sign Out");
    }


}
