package org.ait.kitaconnection.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

public abstract class BasePage {

    public WebDriver driver;
    JavascriptExecutor js;
    public void pause(int millis) {
        try {
            Thread.sleep(millis);

        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        js = (JavascriptExecutor) driver;
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }

    public void clickWithJSExecutor(WebElement element, int xOffset, int yOffset) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("window.scrollBy(" + xOffset + "," + yOffset + ")");
        js.executeScript("arguments[0].click();", element);
    }

    public void clickWithJSExecutor(WebElement element) {
        scrollToElement(element);
        element.click();
    }

    public void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void resizeBrowserWindow(int width, int height) {
        js.executeScript("window.innerWidth = arguments[0]; window.innerHeight = arguments[1];", width, height);
    }


    public void typeWithJSExecutor(WebElement element, String text, int x, int y){
        if (text != null){
            clickWithJSExecutor(element/*, x, y*/);
            element.clear();
            element.sendKeys(text);
        }
    }
    public boolean shouldHaveText(WebElement element, String text, int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public boolean
     isTextPresent(WebElement element,String text) {

        return element.getText().contains(text);
    }

    public void verifyLinks(String linkUrl) {
        try{
            URL url = new URL(linkUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.connect();

            if (connection.getResponseCode() >= 400) {
                System.out.println(linkUrl + " - " + connection.getResponseMessage() + " is a broken link");
            } else {
                System.out.println(linkUrl + " - "+ connection.getResponseMessage());
            }
        } catch (Exception ex) {
            System.out.println(linkUrl + " - "+ ex.getMessage() + " is a broken link");
        }

    }


    public void clickWithRectangle(WebElement element, int x, int y) {
        Rectangle rectangle = element.getRect();

        int xOffset = rectangle.getWidth() / x;
        int yOffset = rectangle.getHeight() / y;

        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.moveByOffset(-xOffset, -yOffset).click().perform();

    }

    public String getValueAttribute(WebElement element, String name) {

        return element.getAttribute(name);
    }
}
