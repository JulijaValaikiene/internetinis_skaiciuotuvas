package lt.techin.julijav;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserAccountPage extends BasePage {
    public UserAccountPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath = " //ul[2]/a")
    WebElement logoutLink;
    @FindBy (xpath = " //h2[text()='Galimos operacijos: sudėti, atimti, dauginti, dalinti']")
    WebElement userAccountElement;


    public void clickLogoutLink() {
        logoutLink.click();
    }
    public String getTextOfUserAccountElement(){
        return userAccountElement.getText();
    }

}
