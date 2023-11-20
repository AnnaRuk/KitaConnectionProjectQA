package org.ait.kitaconnection.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DialoguePage extends BasePage{

    public DialoguePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "message1text")
    WebElement message1text;
    public DialoguePage verifyMessageIsPresent(String text) {
        Assert.assertTrue(shouldHaveText(message1text,text,10));
        return this;
    }
}
