package org.ait.kitaconnection.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class KitaPage extends BasePage{

    public KitaPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(?????????)
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
}
