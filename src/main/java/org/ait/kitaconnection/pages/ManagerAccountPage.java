package org.ait.kitaconnection.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManagerAccountPage extends BasePage{

    public ManagerAccountPage(WebDriver driver) {
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

    public ManagerAccountPage inputData(/*String firstName, String lastName, String userEmail,*/
                                     String userPostcode, String userCity, String userAddress) {

        type(postCode,userPostcode);
        type(city,userCity);
        type(address,userAddress);
        return this;
    }

    @FindBy(id = "dateOfBirth-input")
    WebElement dateOfBirthInput;
    public ManagerAccountPage enterBirthDate(String date) {
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
    public ManagerAccountPage save() {
        click(saveBtn);
        return this;
    }

  /*  @FindBy(???????????)
    WebElement oldPassField;

    @FindBy(???????????)
    WebElement newPassField;

    @FindBy(???????????)
    WebElement confirmPassField;
    public ManagerAccountPage changePassword(String oldPass, String newPass, String confirmPass) {
        type(oldPassField,oldPass);
        type(newPassField,newPass);
        type(confirmPassField,confirmPass);

        return this;
    }

    @FindBy(????????????)
    WebElement savePassBtn;
    public ManagerAccountPage savePass() {
        click(savePassBtn);
        return this;
    }*/

    @FindBy(id = "cKTitle-input")
    WebElement titleField;
    @FindBy(id = "cKPostcode-input")
    WebElement postcodeField;
    @FindBy(id = "cKCity-input")
    WebElement cityField;
    @FindBy(id = "cKAddress-input")
    WebElement addressField;
    @FindBy(id = "cKCapacity-input")
    WebElement capacityField;
    @FindBy(id = "cKFileSelector")
    WebElement uploadPic;
    @FindBy(id = "cKDescription")
    WebElement descriptionField;
    public ManagerAccountPage editKindergartenData(String title, String address, String postCode,
                                                   String city, String capacity,
                                                   String description) {
        type(titleField,title);
        type(addressField,address);
        type(postcodeField,postCode);
        type(cityField,city);
        type(capacityField,capacity);
        type(descriptionField,description);

        return this;
    }


    public ManagerAccountPage uploadPicture(String photoPath) {
        uploadPic.sendKeys(photoPath);

        return this;
    }

    @FindBy(xpath = "//button[.='Edit Data']")
    WebElement editDataBtn;
    public ManagerAccountPage editData() {
        click(editDataBtn);
        return this;
    }

    @FindBy(xpath = "//button[.='My Kindergarten']")
    WebElement myKitaLink;
    public ManagerAccountPage selectMyKitaLink() {
        click(myKitaLink);
        return this;
    }

    @FindBy(xpath = "//button[.='Add a Kindergarten']")
    WebElement addKitaBtn;
    public ManagerAccountPage addKita() {
        click(addKitaBtn);
        return this;
    }
}
