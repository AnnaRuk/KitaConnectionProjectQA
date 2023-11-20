package org.ait.kitaconnection.tests;

import org.ait.kitaconnection.data.KindergartensData;
import org.ait.kitaconnection.pages.AllKitasPage;
import org.ait.kitaconnection.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AllKitasPageWithoutSignInTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).selectAllKindergartens();
    }

    @FindBy(id = "kListTitle")
    WebElement kindergartensListTitle;
    @Test
    public void kitasListWithoutSignInTest() {
        new AllKitasPage(driver).isTextPresent(kindergartensListTitle,"Kindergartens");
    }



    @Test
    public void chooseCityBtnTest() {
        new AllKitasPage(driver).selectCity(KindergartensData.CITY)
                .verifyListIsDisplayed(KindergartensData.CITY);
    }

    @Test
    public void openKitaInfo() {
        new AllKitasPage(driver).selectKita()
                .verifyKitaInfoIsPresent(KindergartensData.TITLE);
    }

    @Test
    public void checkBrokenImagesAllKitasPage() {
        new AllKitasPage(driver).verifyLinksInAllKitasPage();
    }
}
