package org.ait.kitaconnection.tests;

import org.ait.kitaconnection.data.KindergartensData;
import org.ait.kitaconnection.pages.AllKitasPage;
import org.ait.kitaconnection.pages.HomePage;
import org.ait.kitaconnection.pages.KitaPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KitaPageTest extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).selectAllKindergartens();
        new AllKitasPage(driver).selectKita()
                .verifyKitaInfoIsPresent(KindergartensData.TITLE);
    }

    @Test
    public void goBackLinkTest() {
        new KitaPage(driver).selectGoBackBtn();
    }
}
