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
        click(requestBtn);
        return this;
    }

    @FindBy(id = "kShowMessageBTN")
    WebElement sendMessageField;
    @FindBy(id = "textArea")
    WebElement textArea;
    @FindBy(id = "kSendMessageBTN")
    WebElement sendMessageBtn;
    public KitaPage sendAMessage(String text) {
        click(sendMessageField);
        type(textArea,text);
        click(sendMessageBtn);
        return this;
    }

    @FindBy(xpath = "//button[.='My Requests']")
    WebElement myRequestsBtn;
    @FindBy(xpath = "//td[text()='lea sm']")
    WebElement nameField;
    public RequestsPage verifyRequestIsInRequestsList() {
        click(myRequestsBtn);
        Assert.assertTrue(shouldHaveText(nameField, ChildrensData.FIRST_NAME+" "+ChildrensData.LAST_NAME,10));
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
    @FindBy(xpath = "//button[.= 'Anthony Hopkins']")
    WebElement managerName;

    public DialoguePage verifyMessageIsInDialogues() {
        click(dialogueBtn);
        click(managerName);
        new DialoguePage(driver).verifyMessageIsPresent("hello");

        return new DialoguePage(driver);
    }
}
