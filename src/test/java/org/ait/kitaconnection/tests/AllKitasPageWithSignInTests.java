package org.ait.kitaconnection.tests;

import org.ait.kitaconnection.data.KindergartensData;
import org.ait.kitaconnection.data.ManagerData;
import org.ait.kitaconnection.data.UserData;
import org.ait.kitaconnection.pages.AllKitasPage;
import org.ait.kitaconnection.pages.HomePage;
import org.ait.kitaconnection.pages.SignInPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AllKitasPageWithSignInTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).selectSignIn();
       // new HomePage(driver).verifySignOutBtnIsPresent("Sign out");
        new SignInPage(driver).signIn(UserData.EMAIL, UserData.PASSWORD);
        new HomePage(driver).selectAllKindergartens();
    }

    @FindBy(id = "kTableContainer")
    WebElement kindergartensListTitle;
    @Test
    public void kitasListWithSignInTest() {
        new HomePage(driver).selectAllKindergartens();

        new AllKitasPage(driver).verifyKitaTitleIsPresent();
    }

    @Test
    public void allCitiesBtnTest() {
        new AllKitasPage(driver).selectCity(KindergartensData.CITY)
                .verifyListIsDisplayed(KindergartensData.CITY);
    }

    @Test
    public void openKitaInfo() {
        new HomePage(driver).selectAllKindergartens();
        new AllKitasPage(driver).selectKita()
                .verifyKitaInfoIsPresent(KindergartensData.TITLE);
    }

    @Test
    public void checkBrokenImagesAllKitasPage() {
        new AllKitasPage(driver).verifyLinksInAllKitasPage();
    }
}
