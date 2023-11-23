package org.ait.kitaconnection.pages;

import org.ait.kitaconnection.data.ManagerData;
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

    public ManagerAccountPage inputData(String userPostcode, String userCity, String userAddress) {

        type(postCode,userPostcode);
        type(city,userCity);
        type(address,userAddress);
        return this;
    }

    @FindBy(id = "dateOfBirth-input")
    WebElement dateOfBirthInput;
    public ManagerAccountPage enterBirthDate(String date) {

        type(dateOfBirthInput,date);

        return this;
    }

    @FindBy(xpath = "//button[.='Save Data']")
    WebElement saveBtn;
    public ManagerAccountPage save() {
        click(saveBtn);
        return this;
    }


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

   @FindBy(xpath = "//button[.='My Data']")
   WebElement myDataLink;
    public ManagerAccountPage selectMyDataLink() {
        click(myDataLink);
        return this;
    }

    @FindBy(xpath = "//button[.='Edit Data']")
    WebElement editBtn;
    public ManagerAccountPage selectEditBtn() {

        clickWithJSExecutor(editBtn,0,1000);
        return this;
    }
}
