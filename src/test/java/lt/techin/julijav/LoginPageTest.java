package lt.techin.julijav;

import ch.qos.logback.classic.Logger;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPageTest extends BasePageTest {
    LoginPage loginPage;
    String userName = "Marta";
    String shortUserName = "Ma";
    String userPassword = "Marta159";
    private final Logger log = (Logger) LoggerFactory.getLogger(RegistrationPageTest.class);

    @Test
    public void userLogin() {
        loginPage = new LoginPage(driver);

        String expectedLoginElementText = "Prisijungimas";
        String actualLoginElementText = loginPage.getTextOfLoginElement();
        assertEquals(expectedLoginElementText, actualLoginElementText, "Login page element should have this text" + expectedLoginElementText);
        loginPage.fillNameInput(userName);
        loginPage.fillPasswordInput(userPassword);
        loginPage.clickLoginButton();
        log.info("Login is successfully done!");
    }

    @Test
    public void shortUserNameLogin() {
        loginPage = new LoginPage(driver);

        String expectedLoginElementText = "Prisijungimas";
        String actualLoginElementText = loginPage.getTextOfLoginElement();
        assertEquals(expectedLoginElementText, actualLoginElementText, "Login page element should have this text" + expectedLoginElementText);
        loginPage.fillNameInput(shortUserName);
        loginPage.clickLoginButton();
        String expectedErrorMessageForLoginNameText = "Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi";
        String actualErrorMessageForLoginLoginNameText = loginPage.getTextOfErrorLoginNameMessage();
        assertEquals(expectedErrorMessageForLoginNameText, actualErrorMessageForLoginLoginNameText, "Error message in Login page by entering short name should have this text" + expectedErrorMessageForLoginNameText);
        log.info("Login with short user name brings correct message!");

    }

}
