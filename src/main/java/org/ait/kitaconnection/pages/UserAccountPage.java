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

    public UserAccountPage inputData(/*String firstName, String lastName, String userEmail,*/
                                     String userPostcode, String userCity, String userAddress,
                                     String phone) {
                //type(fName,firstName);
                //type(lName,lastName);
                //type(email,userEmail);
                type(postCode,userPostcode);
                type(city,userCity);
                type(address,userAddress);
                type(phoneField, phone);
        return this;
    }

    @FindBy(id = "dateOfBirth-input")
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

    @FindBy(xpath = "//button[.='Save Data']")
    WebElement saveBtn;
    public UserAccountPage save() {
        click(saveBtn);
        return this;
    }

   /*@FindBy(???????????)
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
    }*/

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
        return new UserAccountPage(driver);
    }
    @FindBy(id = "aKindergartens")
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

    /*@FindBy()
    WebElement getMyFavorites;
    public UserAccountPage selectMyFavoritesLink() {
        click(getMyFavorites);
        return new UserAccountPage(driver);
    }

    @FindBy(xpath = "//button[.='My favorites']")
    WebElement myFavorites;
    public UserAccountPage verifyFavoritesListIsPresent(String title) {
        Assert.assertTrue(shouldHaveText(myFavorites,title,10));
        return null;
    }*/

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


    @FindBy(id = "#addChildBtn")
    WebElement addChildBtn;
    public UserAccountPage addChildLink() {
        click(addChildBtn);
        return this;
    }


    @FindBy(id = "cEditBtn1")
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


}
