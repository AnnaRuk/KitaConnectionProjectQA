package org.ait.kitaconnection.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class AllKitasPage extends BasePage{

    public AllKitasPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "allKitasBtn")
    WebElement chosenCity;
    public AllKitasPage selectCity(String city) {
        click(chosenCity);
        chosenCity.sendKeys(city);
        chosenCity.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(xpath = "//td[.='Berlin']")
    WebElement cityField;
    public AllKitasPage verifyListIsDisplayed(String chosenCity) {
        Assert.assertTrue(shouldHaveText(cityField,chosenCity,10));
        return new AllKitasPage(driver);
    }

    @FindBy(xpath = "//div[.='Kita im BMEL']")
    WebElement kitaLink;
    public KitaPage selectKita() {
        click(kitaLink);
        return new KitaPage(driver);
    }

    public AllKitasPage verifyLinksInAllKitasPage() {
        List<WebElement> images = driver.findElements(By.tagName("img"));

        System.out.println("Total number of images on the page: " + images.size());

        for (int i = 0; i < images.size(); i++) {
            WebElement image = images.get(i);

            String imageUrl = image.getAttribute("src");
            System.out.println("URL of image " + (i + 1) + " is " + imageUrl);
            verifyLinks(imageUrl);

            try {
                boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver)
                        .executeScript("return (typeof arguments[0].naturalWidth != undefined && arguments[0].naturalWidth>0);", image);
                if (imageDisplayed) {
                    System.out.println("DISPLAY - OK");
                    System.out.println("**************************************************");
                } else {
                    System.out.println("DISPLAY - BROKEN");
                }
            } catch (Exception ex) {
                System.out.println("ERROR OCCURRED");
            }
        }
        return this;
    }


    @FindBy(id = "kListTitle")
    WebElement kindergartensListTitle;
    public AllKitasPage verifyKitaTitleIsPresent() {
        Assert.assertTrue(shouldHaveText(kindergartensListTitle,"Kindergartens",10));
        return this;
    }
}
