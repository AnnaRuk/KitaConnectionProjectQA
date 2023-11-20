package org.ait.kitaconnection.tests;

import org.ait.kitaconnection.data.ChildrensData;
import org.ait.kitaconnection.data.UserData;
import org.ait.kitaconnection.pages.AllKitasPage;
import org.ait.kitaconnection.pages.HomePage;
import org.ait.kitaconnection.pages.SignInPage;
import org.ait.kitaconnection.pages.UserAccountPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.ait.kitaconnection.data.UserData.EMAIL;
import static org.ait.kitaconnection.data.UserData.PASSWORD;

public class UserAccountPageTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).selectSignIn();
        new SignInPage(driver).signIn(EMAIL, PASSWORD)
                .verifySignOutBtnIsPresent("Sign out");
        new HomePage(driver).selectMyAccLink();
    }

    @Test
    public void fillMyDataForm() {
        new UserAccountPage(driver).selectMyDataLink()
                .selectMyDataLink()
                .editData()
                .inputData(/*UserData.FIRST_NAME,UserData.LAST_NAME, EMAIL,*/
                        UserData.POSTCODE,UserData.CITY,UserData.ADDRESS,UserData.PHONE)
                .chooseGender(UserData.GENDER)
                .enterBirthDate("12.11.1980")
                .enterBirthDate(UserData.DATE)
                .save();
    }

   /* @Test
    public void changePasswordInMyDataForm() {
        new UserAccountPage(driver).changePassword(UserData.OLD_PASSWORD_FOR_PASS_CHANGE,
                UserData.PASSWORD,UserData.CONFIRM_PASSWORD)
                .savePass();
    }*/

    @Test
    public void fillMyChildrenForm() {
        new UserAccountPage(driver).selectMyChildrenLink()
                .addChildLink()

                .inputChildrenData(ChildrensData.FIRST_NAME,ChildrensData.LAST_NAME)
                .enterChildrensBirthDate(ChildrensData.DATE)
                .chooseGender(ChildrensData.GENDER)
                //.addOneMoreChild() TODO ???????????
                .saveData();
    }

    @Test
    public void correctChildrensData() {
        new UserAccountPage(driver).selectMyChildrenLink()
                .addChildLink()
                .selectEditBtn()
                .enterEditedData()
                .saveChanges();
    }

    @Test
    public void findKindergartenTest() {
        new UserAccountPage(driver).selectKindergartensBtn()
                .selectKindergartensList()
        .allCitiesField("Berlin");
        //Assert.assertTrue(); TODO ???????????
    }

    @Test
    public void openKindergartenPage() {
        new UserAccountPage(driver).selectKindergartensBtn()
                .selectKindergartensList()
                .selectKindergarten()
                .verifyKitaTitleIsPresent("Kita F.A.I.R.play");
    }

   /* @Test
    public void myFavoritesTest() {
        new UserAccountPage(driver).selectKindergartensBtn()
                .selectMyFavoritesLink()
                .verifyFavoritesListIsPresent("My Favorites");
    }*/

    @Test
    public void checkBrokenImagesAllKitasPage() {
        new AllKitasPage(driver).verifyLinksInAllKitasPage();
    }
}


