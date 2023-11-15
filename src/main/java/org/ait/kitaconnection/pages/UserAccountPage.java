package org.ait.kitaconnection.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class UserAccountPage extends BasePage {

    public UserAccountPage(WebDriver driver) {
        super(driver);
    }

   @FindBy(???????????)
    WebElement fName;
    @FindBy(???????????)
    WebElement lName;
    @FindBy(???????????)
    WebElement email;
    @FindBy(???????????)
    WebElement postCode;
    @FindBy(???????????)
    WebElement city;
    @FindBy(???????????)
    WebElement address;

    @FindBy(????????)
    WebElement phoneField;

    public UserAccountPage inputData(String firstName, String lastName, String userEmail,
                                     String userPostcode, String userCity, String userAddress,
                                     String phone) {
                type(fName,firstName);
                type(lName,lastName);
                type(email,userEmail);
                type(postCode,userPostcode);
                type(city,userCity);
                type(address,userAddress);
                type(phoneField, phone);
        return this;
    }

    @FindBy(?????????????)
    WebElement dateOfBirthInput;
    public UserAccountPage enterBirthDate(String date) {
        click(dateOfBirthInput);

        String os = System.getProperty("os.name");
        System.out.println("My OS is " + os);

        if (os.startsWith("Mac")) {
            dateOfBirthInput.sendKeys(Keys.COMMAND, "a");
        } else {
            dateOfBirthInput.sendKeys(Keys.CONTROL, "a");
        }
        dateOfBirthInput.sendKeys(date);
        dateOfBirthInput.sendKeys(Keys.ENTER);

        return this;
    }

    @FindBy(?????????????)
    WebElement saveBtn;
    public UserAccountPage save() {
        click(saveBtn);
        return this;
    }

   @FindBy(???????????)
   WebElement oldPassField;

    @FindBy(???????????)
    WebElement newPassField;

    @FindBy(???????????)
    WebElement confirmPassField;
    //???????NADO LI VNESTI ETI DANNYE V USERDATA???????????
    public UserAccountPage changePassword(String oldPass, String newPass, String confirmPass) {
        type(oldPassField,oldPass);
        type(newPassField,newPass);
        type(confirmPassField,confirmPass);

        return this;
    }

    @FindBy(????????????)
    WebElement savePassBtn;
    public UserAccountPage savePass() {
        click(savePassBtn);
        return this;
    }

    @FindBy(?????????)
    WebElement myChildrenLink;
    public UserAccountPage selectMyChildrenLink() {
        click(myChildrenLink);
        return new UserAccountPage(driver);
    }

    @FindBy(????????????)
    WebElement childsFirstNameField;
    @FindBy(????????????)
    WebElement childsLastNameField;

    public UserAccountPage inputChildrenData(String firstName, String lastName) {
        type(childsFirstNameField,firstName);
        type(childsLastNameField,lastName);
        return this;
    }

    @FindBy(????????????)
    WebElement childsBirthDateField;

    public UserAccountPage enterChildrensBirthDate(String date) {
        click(childsBirthDateField);

        String os = System.getProperty("os.name");
        System.out.println("My OS is " + os);

        if (os.startsWith("Mac")) {
            dateOfBirthInput.sendKeys(Keys.COMMAND, "a");
        } else {
            dateOfBirthInput.sendKeys(Keys.CONTROL, "a");
        }
        dateOfBirthInput.sendKeys(date);
        dateOfBirthInput.sendKeys(Keys.ENTER);

        return this;
    }

    @FindBy(???????)
    WebElement saveDataBtn;
    public UserAccountPage saveData() {
        click(saveDataBtn);
        return this;
    }

    @FindBy(????????????)
    WebElement male;

    @FindBy(????????????)
    WebElement female;

    @FindBy(?????????????)
    WebElement other;
    public UserAccountPage chooseGender(String gender) {

            if (gender.equals("Male")) {
                click(male);
            } else if (gender.equals("Female")) {
                click(female);
            } else {
                click(other);
            }
            return this;
    }

    @FindBy(????????)
    WebElement cityField;
    public UserAccountPage selectCityField(String city) {
        click(cityField);
        cityField.sendKeys(city);
        cityField.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(????????????????)
    WebElement findKindergarten;
    public UserAccountPage selectFindKindergartenLink() {
        click(findKindergarten);
        return new UserAccountPage(driver);
    }

    @FindBy(????????)
    WebElement kitaLink;
    public KitaPage selectKindergarten() {
        click(kitaLink);
        return new KitaPage(driver);
    }

    @FindBy(???????????)
    WebElement getMyFavorites;
    public UserAccountPage selectMyFavoritesLink() {
        click(getMyFavorites);
        return new UserAccountPage(driver);
    }

    @FindBy(??????????)
    WebElement myFavorites;
    public UserAccountPage verifyFavoritesListIsPresent(String title) {
        Assert.assertTrue(shouldHaveText(myFavorites,title,10));
        return null;
    }
}
