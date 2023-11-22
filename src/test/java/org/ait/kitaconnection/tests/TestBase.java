package org.ait.kitaconnection.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestBase {

    WebDriver driver;

    @BeforeMethod
    public void init() {
        disableSeleniumLogging();
       driver = new ChromeDriver();
       driver.get("https://kitaconnection-app-9wbbe.ondigitalocean.app/kita-connection/");//http://localhost:5173/");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(enabled = true)
    public void tearDown(){

        driver.quit();
    }
    private static void disableSeleniumLogging() {
        System.setProperty("webdriver.chrome.silentOutput", "true");
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
    }

}
