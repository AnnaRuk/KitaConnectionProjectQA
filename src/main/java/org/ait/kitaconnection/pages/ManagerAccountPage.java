package org.ait.kitaconnection.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManagerAccountPage extends BasePage{

    public ManagerAccountPage(WebDriver driver) {
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

    public ManagerAccountPage inputData(String firstName, String lastName, String userEmail,
                                     String userPostcode, String userCity, String userAddress) {
        type(fName,firstName);
        type(lName,lastName);
        type(email,userEmail);
        type(postCode,userPostcode);
        type(city,userCity);
        type(address,userAddress);
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
    public ManagerAccountPage save() {
        click(saveBtn);
        return this;
    }

    @FindBy(???????????)
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
    }

    @FindBy(?????????)
    WebElement titleField;
    @FindBy(?????????)
    WebElement postcodeField;
    @FindBy(?????????)
    WebElement cityField;
    @FindBy(?????????)
    WebElement addressField;
    @FindBy(?????????)
    WebElement contactsField;
    @FindBy(?????????)
    WebElement capacityField;
    @FindBy(?????????)
    WebElement uploadPic;
    @FindBy(?????????)
    WebElement descriptionField;
    public ManagerAccountPage inputKindergartenData(String title,String postCode,String city,
                                                    String address, String contacts,String capacity,
                                                    String description) {
        type(titleField,title);
        type(postcodeField,postCode);
        type(cityField,city);
        type(addressField,address);
        type(contactsField,contacts);
        type(capacityField,capacity);
        type(descriptionField,description);

        return this;
    }


    public ManagerAccountPage uploadPicture(String photoPath) {
        uploadPic.sendKeys(photoPath); // TODO check Open file btn!!!!

        return this;
    }

    @FindBy(????????)
    WebElement saveBtnKita;
    public ManagerAccountPage saveKita() {
        click(saveBtnKita);
        return this;
    }
}
