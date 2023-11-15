package org.ait.kitaconnection.tests;

import org.ait.kitaconnection.data.KindergartensData;
import org.ait.kitaconnection.data.UserData;
import org.ait.kitaconnection.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.ait.kitaconnection.data.UserData.EMAIL;
import static org.ait.kitaconnection.data.UserData.PASSWORD;

public class ManagerAccountPageTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).selectSignIn();
        new SignInPage(driver).signIn(EMAIL, PASSWORD)
                .verifySignOutBtnIsPresent("Sign out");
        new HomePage(driver).selectMyAccManagerLink();
    }

    @Test
    public void fillMyDataForm() {
        new ManagerAccountPage(driver).inputData(UserData.FIRST_NAME,UserData.LAST_NAME, EMAIL,
                        UserData.POSTCODE,UserData.CITY,UserData.ADDRESS)
                .enterBirthDate(UserData.DATE)
                .save();
    }

  /*  @Test
    public void changePasswordInMyDataForm() {
        new ManagerAccountPage(driver).changePassword(UserData.OLD_PASSWORD_FOR_PASS_CHANGE,
                        UserData.PASSWORD,UserData.CONFIRM_PASSWORD)
                .savePass();
    }*/

    @Test
    public void fillMyKindergartenForm() {
        new ManagerAccountPage(driver).inputKindergartenData(KindergartensData.TITLE,KindergartensData.POSTCODE,
                        KindergartensData.CITY,KindergartensData.ADDRESS,KindergartensData.CONTACTS,
                        KindergartensData.CAPACITY,KindergartensData.DESCRIPTION)
                .uploadPicture(KindergartensData.PHOTO_PATH)
                .saveKita();
    }

    @Test
    public void checkBrokenImagesAllKitasPage() {
        new AllKitasPage(driver).verifyLinksInAllKitasPage();
    }

}
