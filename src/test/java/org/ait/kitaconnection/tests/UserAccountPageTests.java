package org.ait.kitaconnection.tests;

import org.ait.kitaconnection.data.ChildrensData;
import org.ait.kitaconnection.data.ManagerData;
import org.ait.kitaconnection.data.UserData;
import org.ait.kitaconnection.pages.AllKitasPage;
import org.ait.kitaconnection.pages.HomePage;
import org.ait.kitaconnection.pages.SignInPage;
import org.ait.kitaconnection.pages.UserAccountPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.ait.kitaconnection.data.ManagerData.EMAIL;
import static org.ait.kitaconnection.data.ManagerData.PASSWORD;

public class UserAccountPageTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).selectSignIn();
        new SignInPage(driver).signIn(UserData.EMAIL, UserData.PASSWORD);
        new HomePage(driver).selectMyAccLink();
    }

    @Test
    public void fillMyDataForm() {
        new UserAccountPage(driver).selectMyDataLink()
                .editData()
                .inputData(UserData.POSTCODE, UserData.CITY, UserData.ADDRESS, UserData.PHONE)
                .chooseGender(ManagerData.GENDER)
                .save();
    }



    @Test
    public void fillMyChildrenForm() {
        new UserAccountPage(driver).selectMyChildrenLink()
                .addChildLink()

                .inputChildrenData(ChildrensData.FIRST_NAME,ChildrensData.LAST_NAME)
                .enterChildrensBirthDate(ChildrensData.DATE)
                .chooseGender(ChildrensData.GENDER)
                .saveData();
    }

    @Test
    public void correctChildrensData() {
        new UserAccountPage(driver).selectMyChildrenLink()
                .selectEditBtn()
                .enterEditedData()
                .saveChanges();
    }

    @Test
    public void findKindergartenTest() {
        new UserAccountPage(driver).selectKindergartensBtn()
                .selectKindergartensList()
                .allCitiesField("Berlin")
                .verifyChosenCityIsPresent("Berlin");
    }

    @Test
    public void openKindergartenPage() {
        new UserAccountPage(driver).selectKindergartensBtn()
                .selectKindergartensList()
                .selectKindergarten()
                .verifyKitaTitleIsPresent("Kita im BMEL");
    }



    @Test
    public void checkBrokenImagesAllKitasPage() {
        new AllKitasPage(driver).verifyLinksInAllKitasPage();
    }
}


