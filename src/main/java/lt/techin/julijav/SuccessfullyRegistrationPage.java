package lt.techin.julijav;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessfullyRegistrationPage extends BasePage {
    public SuccessfullyRegistrationPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath = " //ul[text()='Logout, Martin'")
    WebElement logoutLink;
    @FindBy (xpath = " //input[@value='skaičiuoti']")
    WebElement calculateButton;

    public void clickLogoutLink() {
        logoutLink.click();
    }
    public String getTextOfCalculateButton(){
        return calculateButton.getText();
    }

}
