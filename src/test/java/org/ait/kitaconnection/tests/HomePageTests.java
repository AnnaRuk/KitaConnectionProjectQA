package org.ait.kitaconnection.tests;

import org.ait.kitaconnection.pages.AllKitasPage;
import org.ait.kitaconnection.pages.HomePage;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{

    @Test
    public void checkBrokenImagesAllKitasPage() {

        new AllKitasPage(driver).verifyLinksInAllKitasPage();
    }

    @Test
    public void aboutVoucherTest() {
        new HomePage(driver).selectAboutVoucherBtn()
                .verifyInfoIsPresent();
    }

    @Test
    public void aboutUsTest() {
        new HomePage(driver).selectAboutUsBtn()
                .verifyAboutUsInfoIsPresent();
    }

    @Test
    public void FAQBtnTest() {
        new HomePage(driver).selectFAQBtn()
                .verifyFAQIsPresent();
    }

    @Test
    public void contactUsBtnTest() {
        new HomePage(driver).selectContactUsBtn()
                .verifyContactInfoIsPresent();
    }

    @Test
    public void checkBrokenLinks() {
        new HomePage(driver).verifyLinksOnFooter();
    }


}
