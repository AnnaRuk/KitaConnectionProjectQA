package org.ait.kitaconnection.tests;

import org.ait.kitaconnection.data.ChildrensData;
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
    public void goBackBtnTest() {
        new KitaPage(driver).selectGoBackBtn();
    }

    @Test
    public void addToFavoritesBtnTest() {
        new KitaPage(driver).addKitaToFavorites()
                .verifyRemoveBtnIsPresent("Remove from Favorites");
    }

    @Test
    public void removeFromFavoritesBtnTest() {
        new KitaPage(driver).removeFromFavorites()
                .verifyAddToFavoritesBtnIsPresent("Add to Favorites");
    }

    @Test
    public void sendRequestTest() {
        new KitaPage(driver).chooseAKidBtn(ChildrensData.FIRST_NAME)
                .sendRequest()
                .verifyRequestIsInRequestsList(); //TODO check requests in MyRequests
    }

    @Test
    public void sendMessageTest() {
        new KitaPage(driver).sendAMessage("hello")
                .verifyMessageIsInDialogues();


    }
}
