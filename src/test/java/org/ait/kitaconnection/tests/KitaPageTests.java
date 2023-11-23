package org.ait.kitaconnection.tests;

import org.ait.kitaconnection.data.ChildrensData;
import org.ait.kitaconnection.data.KindergartensData;
import org.ait.kitaconnection.data.UserData;
import org.ait.kitaconnection.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KitaPageTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).selectSignIn();
        new SignInPage(driver).signIn(UserData.EMAIL, UserData.PASSWORD);
        new HomePage(driver).selectMyAccLink();
        new UserAccountPage(driver).selectKindergartensBtn()
                .selectKindergartensList()
                .selectKindergarten();

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
                .sendRequest();

    }

    /*@Test
    public void sendMessageTest() {
        new KitaPage(driver).sendAMessage("hello")
                .verifyMessageIsInDialogues();
    }*/
}
