package org.ait.kitaconnection.tests;

import org.ait.kitaconnection.data.KindergartensData;
import org.ait.kitaconnection.data.ManagerData;
import org.ait.kitaconnection.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.ait.kitaconnection.data.ManagerData.EMAIL;
import static org.ait.kitaconnection.data.ManagerData.PASSWORD;

public class ManagerAccountPageTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).selectSignIn();
        new SignInPage(driver).signIn(EMAIL, PASSWORD)
                .verifyMyAccountBtnIsPresent("My Account");
        new HomePage(driver).selectMyAccManagerLink();
    }

    @Test
    public void fillMyDataForm() {
        new ManagerAccountPage(driver).selectMyDataLink()
                .editData()
                .inputData(ManagerData.POSTCODE, ManagerData.CITY, ManagerData.ADDRESS)
                .enterBirthDate(ManagerData.DATE)
                .save();
    }

  /*  @Test
    public void changePasswordInMyDataForm() {
        new ManagerAccountPage(driver).changePassword(UserData.OLD_PASSWORD_FOR_PASS_CHANGE,
                        UserData.PASSWORD,UserData.CONFIRM_PASSWORD)
                .savePass();
    }*/

    @Test
    public void editMyKitaTest() {
        new ManagerAccountPage(driver).selectMyKitaLink()
                .selectEditBtn()
                .editKindergartenData(KindergartensData.TITLE,KindergartensData.ADDRESS,
                        KindergartensData.POSTCODE, KindergartensData.CITY,KindergartensData.CAPACITY,
                        KindergartensData.DESCRIPTION)
                .uploadPicture(KindergartensData.PHOTO_PATH)
                .save();
    }

    @Test
    public void checkBrokenImagesAllKitasPage() {

        new AllKitasPage(driver).verifyLinksInAllKitasPage();
    }



}
