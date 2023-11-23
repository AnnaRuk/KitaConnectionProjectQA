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

    @FindBy(id = "postcode-input")
    WebElement postCode;
    @FindBy(id = "city-input")
    WebElement city;
    @FindBy(id = "address-input")
    WebElement address;

    @FindBy(id = "phone-input")
    WebElement phoneField;

    public UserAccountPage inputData(String userPostcode, String userCity, String userAddress,
                                     String phone) {
                type(postCode,userPostcode);
                type(city,userCity);
                type(address,userAddress);
                type(phoneField, phone);
        return this;
    }

    @FindBy(xpath = "//div[.='Birthday:']")
    WebElement dateOfBirthInput;
    public UserAccountPage enterBirthDate(String date) {
        type(dateOfBirthInput,date);

        return this;
    }

    @FindBy(xpath = "//button[.='Save Data']")
    WebElement saveBtn;
    public UserAccountPage save() {
        click(saveBtn);
        return new UserAccountPage(driver);
    }


    @FindBy(xpath = "//button[.='My Children']")
    WebElement myChildrenLink;
    public UserAccountPage selectMyChildrenLink() {
        click(myChildrenLink);
        return new UserAccountPage(driver);
    }

    @FindBy(id = "cNewFirstName-input")
    WebElement childsFirstNameField;
    @FindBy(id = "cNewLastName-input")
    WebElement childsLastNameField;

    public UserAccountPage inputChildrenData(String firstName, String lastName) {
        type(childsFirstNameField,firstName);
        type(childsLastNameField,lastName);
        return this;
    }

    @FindBy(id = "cNewDateOfBirth-input")
    WebElement childsBirthDateField;

    public UserAccountPage enterChildrensBirthDate(String date) {

        type(childsBirthDateField,date);

        return this;
    }

    @FindBy(id = "saveNewChildBtn")
    WebElement saveDataBtn;
    public UserAccountPage saveData() {
        click(saveDataBtn);
        return this;
    }

    @FindBy(xpath = "//input[@value='MALE']")
    WebElement male;

    @FindBy(xpath = "//input[@value='FEMALE']")
    WebElement female;

    @FindBy(xpath = "//input[@value='DIVERSE']")
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

    @FindBy(id = "citySelector")
    WebElement allCitiesSelector;
    public UserAccountPage allCitiesField(String city) {
        click(allCitiesSelector);
        allCitiesSelector.sendKeys(city);
        allCitiesSelector.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "aKindergartens")
    WebElement kindergartens;
    public UserAccountPage selectKindergartensBtn() {
        click(kindergartens);
        return this;
    }
    @FindBy(xpath = "//a[@id='aKnav']//button[@id='aKindergartens']")
    WebElement kindergartensList;
    public UserAccountPage selectKindergartensList() {
        click(kindergartensList);
        return this;
    }
    @FindBy(id = "iconTitle")
    WebElement kitaLink;
    public KitaPage selectKindergarten() {
        click(kitaLink);
        return new KitaPage(driver);
    }


    @FindBy(xpath = "//button[.='My Data']")
    WebElement myDataLink;
    public UserAccountPage selectMyDataLink() {
        click(myDataLink);
        return this;
    }

    @FindBy(xpath = "//button[.='Edit Data']")
    WebElement editDataBtn;
    public UserAccountPage editData() {
        click(editDataBtn);
        return this;
    }


    @FindBy(id = "addChildBtn")
    WebElement addChildBtn;
    public UserAccountPage addChildLink() {
        click(addChildBtn);
        return this;
    }


    @FindBy(id = "cEditBtn10")
    WebElement editBtn;
    public UserAccountPage selectEditBtn() {
        click(editBtn);
        return this;
    }

    @FindBy(id = "kFirstName-input")
    WebElement firstNameInpit;
    @FindBy(id = "kLastName-input")
    WebElement lastNameInput;
    @FindBy(id = "kDateOfBirth-input")
    WebElement birthDateInput;
    public UserAccountPage enterEditedData() {
        type(firstNameInpit,"Cara");
        type(lastNameInput,"Smith");
        type(birthDateInput,"20.06.2019");
        return this;
    }

    @FindBy(id = "cSaveDataBtn")
    WebElement saveChangesBtn;
    public UserAccountPage saveChanges() {
        click(saveChangesBtn);
        return this;
    }


    @FindBy(xpath = "//tbody/tr[1]/td[2]")
    WebElement chosenCityField;
    public UserAccountPage verifyChosenCityIsPresent(String city) {
        Assert.assertTrue(shouldHaveText(chosenCityField,city,10));
        return this;
    }
}
