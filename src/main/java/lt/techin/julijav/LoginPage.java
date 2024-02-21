package lt.techin.julijav;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h3[text()='Prisijungimas']")
    WebElement loginElement;
    @FindBy(css = "input[placeholder*='Prisijungimo vardas']")
    WebElement nameInput;
    @FindBy(xpath = "//input[@placeholder='Slaptažodis']")
    WebElement passwordInput;
    @FindBy(xpath = "//button[text()='Prisijungti']")
    WebElement loginButton;
    @FindBy(xpath = "//a[text()='Sukurti naują paskyrą']")
    WebElement createNewUserLink;

    @FindBy(xpath = "//span[text()='Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi']")
    WebElement errorLoginNameMessage;

    public String getTextOfLoginElement() {

        return loginElement.getText();
    }

    public void fillNameInput(String name) {

        nameInput.sendKeys(name);
    }

    public void fillPasswordInput(String password) {

        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {

        loginButton.click();
    }

    public void clickCreateNewUserLink() {

        createNewUserLink.click();
    }

    public String getTextOfErrorLoginNameMessage(){
        return errorLoginNameMessage.getText();
    }
}
