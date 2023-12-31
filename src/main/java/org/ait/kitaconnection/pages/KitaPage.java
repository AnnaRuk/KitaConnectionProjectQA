package org.ait.kitaconnection.pages;

import org.ait.kitaconnection.data.ChildrensData;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class KitaPage extends BasePage{

    public KitaPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "kTitle")
    WebElement title;
    public KitaPage verifyKitaTitleIsPresent(String kitaTitle) {
        Assert.assertTrue(shouldHaveText(title,kitaTitle,10));
        return this;
    }

    @FindBy(id = "kTitle")
    WebElement kitaTitle;
    public KitaPage verifyKitaInfoIsPresent(String kitaName) {
        Assert.assertTrue(shouldHaveText(kitaTitle,kitaName,10));
        return this;
    }

    @FindBy(xpath = "//button[.='Go Back']")
    WebElement goBackBtn;
    public AllKitasPage selectGoBackBtn() {
        click(goBackBtn);
        return new AllKitasPage(driver);
    }

    @FindBy(id = "kToFavoritesBTN")
    WebElement addToFavoritesBtn;
    public KitaPage addKitaToFavorites() {
        click(addToFavoritesBtn);
        return this;
    }

    @FindBy(id = "kFromFavoritesBTN")
    WebElement removeBtn;
    public KitaPage verifyRemoveBtnIsPresent(String btnText) {
        Assert.assertTrue(isTextPresent(removeBtn,btnText));
        return this;
    }

    @FindBy(id = "kChildSelector")
    WebElement childrenBtn;
    public KitaPage chooseAKidBtn(String selectedKid) {
        click(childrenBtn);
        childrenBtn.sendKeys(selectedKid);
        childrenBtn.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "kRequestBTN")
    WebElement requestBtn;
    public KitaPage sendRequest() {
        clickWithJSExecutor(requestBtn/*,0,500*/);
        return this;
    }

    @FindBy(id = "kShowMessageBTN")
    WebElement sendMessageField;
    @FindBy(id = "textArea")
    WebElement textArea;
    @FindBy(id = "kSendMessageBTN")
    WebElement sendMessageBtn;
    public KitaPage sendAMessage(String text) {
        clickWithJSExecutor(sendMessageField/*,0,400*/);
        typeWithJSExecutor(textArea,text,0,300);
        clickWithJSExecutor(sendMessageBtn/*,0,400*/);
        return this;
    }

    @FindBy(xpath = "//button[.='My Requests']")
    WebElement myRequestsBtn;
    @FindBy(xpath = "//tbody/tr/td[4]")
    WebElement nameField;
    public RequestsPage verifyRequestIsInRequestsList(String name) {
        click(myRequestsBtn);
        Assert.assertTrue(shouldHaveText(nameField, name,10));
        return new RequestsPage(driver);
    }


    public KitaPage removeFromFavorites() {
        click(removeBtn);
        return this;
    }

    public KitaPage verifyAddToFavoritesBtnIsPresent(String btnText) {
        Assert.assertTrue(isTextPresent(addToFavoritesBtn,btnText));
        return this;
    }

    @FindBy(id = "aDialogueBtn")
    WebElement dialogueBtn;
    @FindBy(xpath = "//button[.='Maria Kallas']")
    WebElement managerName;

    public DialoguePage verifyMessageIsInDialogues() {
        click(dialogueBtn);
        click(managerName);
        new DialoguePage(driver).verifyMessageIsPresent("hello");

        return new DialoguePage(driver);
    }
}
