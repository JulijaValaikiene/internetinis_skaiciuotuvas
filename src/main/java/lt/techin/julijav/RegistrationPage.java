package lt.techin.julijav;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[text()='Naujos paskyros sukūrimas']")
    WebElement registrationElement;
    @FindBy(id = "username")
    WebElement registrationNameInput;

    @FindBy(id = "password")
    WebElement registrationPasswordInput;

    @FindBy(id = "passwordConfirm")
    WebElement registrationPasswordConfirmationInput;
    @FindBy(xpath = "//button[text()='Sukurti']")
    WebElement createNewUerButton;

    public String getTextOfRegistrationElement() {
        return registrationElement.getText();
    }

    public void enterRegistrationNameInput(String userName) {
        registrationNameInput.sendKeys(userName);
    }

    public void enterRegistrationPasswordInput(String password) {
        registrationPasswordInput.sendKeys(password);
    }

    public void enterRegistrationPasswordConfirmationInput(String password) {
        registrationPasswordConfirmationInput.sendKeys(password);
    }

    public void clickCreateNewUserButton() {
        createNewUerButton.click();

    }
}