package org.ait.kitaconnection.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@id='signInBtn']")
    WebElement signInLink;
    public SignInPage selectSignIn() {
        click(signInLink);
        return new SignInPage(driver);
    }

    @FindBy(id = "signOutBtn")
    WebElement signOut;
    @FindBy(id = "myAccountBtn")
    WebElement myAccountBtn;
    public HomePage verifyMyAccountBtnIsPresent(String myAccount) {
        Assert.assertTrue(shouldHaveText(myAccountBtn,myAccount,10));
        return this;
    }


    @FindBy(id = "allKitasBtn")
    WebElement allKindergartensLink;
    public AllKitasPage selectAllKindergartens() {
        click(allKindergartensLink);
        return new AllKitasPage(driver);
    }

    @FindBy(id = "myAccountBtn")
    WebElement myAccLink;
    public UserAccountPage selectMyAccLink() {
        click(myAccLink);
        return new UserAccountPage(driver);
    }

    public ManagerAccountPage selectMyAccManagerLink() {
        click(myAccLink);
        return new ManagerAccountPage(driver);
    }

    @FindBy(xpath = "//a[.='Sign Out']")
    WebElement signOutBtn;
    public SignInPage signOut() {
        click(signOutBtn);
        new SignInPage(driver).isTextPresent(signInLink,"Sign In");
        return new SignInPage(driver);
    }

    @FindBy(id = "voucherBtn")
    WebElement voucherBtn;
    public HomePage selectAboutVoucherBtn() {
        click(voucherBtn);
        return this;
    }

    @FindBy(id = "voucherTextContainer")
    WebElement voucherInfo;
    public HomePage verifyInfoIsPresent() {
        Assert.assertTrue(shouldHaveText(voucherInfo,
                "If you want your child to go to a day care center or day care center, " +
                        "you will need a day care center voucher. You can redeem the voucher at " +
                        "a Berlin daycare center or day care center of your choice if there is a place" +
                        " available for your child there. The daycare voucher is used to determine your child`s " +
                        "care needs. How many hours a day your child can be looked after depends, among other " +
                        "things, on their age: From your child`s first birthday, the voucher is valid for at" +
                        " least part-time care (more than 5 to 7 hours a day), without the need being checked. " +
                        "In the first year of life, you must demonstrate a need for care for your child. " +
                        "Longer care times for your child are possible if you go to work, study or are in" +
                        " training and therefore cannot look after your child yourself. The need must arise " +
                        "from your family situation or be necessary for educational or social reasons. " +
                        "Please note that your youth welfare office may require proof of the accuracy of your " +
                        "information. Attach a copy of the relevant evidence to your application. For a daycare " +
                        "center, you conclude the care contract directly with the daycare center or the provider." +
                        " In child day care, you usually make initial contact with the child day care person. " +
                        "The contract is then concluded with the responsible youth welfare office. If there are " +
                        "any changes in your family or work situation between registration and the conclusion of " +
                        "a care contract for your child, you must inform the youth welfare office immediately.",10));
        return this;
    }

    @FindBy(id = "aboutBtn")
    WebElement aboutBtn;
    public HomePage selectAboutUsBtn() {
        click(aboutBtn);
        return this;
    }

    @FindBy(id = "aboutWContainer")
    WebElement aboutUsContainer;
    public HomePage verifyAboutUsInfoIsPresent() {
        Assert.assertTrue(isTextPresent(aboutUsContainer,
                "Kita-Connection is a site for those who want to quickly find " +
                        "a kindergarten for their child or find new children for their kindergarten. " +
                        "The site has a simple user-friendly interface. It will be useful to both parents" +
                        " and kindergarten managers and will help them quickly get into communication. " +
                        "The user can quickly find a kindergarten for his/her children according to the " +
                        "criteria he/she needs and quickly submit a request to be added to the waiting list." +
                        "The user can also communicate with the kindergarten manager using the site tools. " +
                        "The manager also can simply" +
                        " track user requests and negotiate with parents using the site."));
        return this;
    }

    @FindBy(id = "faqBtn")
    WebElement faqBtn;
    public HomePage selectFAQBtn() {
        click(faqBtn);
        return this;
    }

    @FindBy(id = "FAQTitle")
    WebElement FAQTitle;
    public HomePage verifyFAQIsPresent() {
        Assert.assertTrue(isTextPresent(FAQTitle, "Frequently Asked Questions"));
        return this;
    }

    @FindBy(id = "contactBtn")
    WebElement contactBtn;
    public HomePage selectContactUsBtn() {
        click(contactBtn);
        return this;
    }

    @FindBy (id = "contactTitle")
    WebElement contactTitle;
    public HomePage verifyContactInfoIsPresent() {
        Assert.assertTrue(isTextPresent(contactTitle,"How You can contact us"));
        return this;
    }

    public HomePage verifyLinksOnFooter() {

        List<WebElement> links = driver.findElements(By.tagName("a"));

        System.out.println("Total number of links on the page: " + links.size());

        for (int i = 0; i < links.size(); i++) {
            WebElement link = links.get(i);
            String linkUrl = link.getAttribute("href");

            System.out.println("URL of link " + (i + 1) + " is " + linkUrl);
            verifyLinks(linkUrl);
        }

        return this;
    }
}
