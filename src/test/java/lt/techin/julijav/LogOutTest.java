package lt.techin.julijav;

import ch.qos.logback.classic.Logger;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogOutTest extends BasePageTest {

    String userName = "Marta";
    String userPassword = "Marta159";
    LoginPage loginPage;
    UserAccountPage userAccountPage;
    private final Logger log = (Logger) LoggerFactory.getLogger(RegistrationPageTest.class);

    @Test
    public void userLogout() {

        loginPage = new LoginPage(driver);
        userAccountPage = new UserAccountPage(driver);

        String expectedLoginElementText = "Prisijungimas";
        String actualLoginElementText = loginPage.getTextOfLoginElement();
        assertEquals(expectedLoginElementText, actualLoginElementText, "Login page element should have this text" + expectedLoginElementText);
        loginPage.fillNameInput(userName);
        loginPage.fillPasswordInput(userPassword);
        loginPage.clickLoginButton();
        String expectedUserAccountElementText = "Galimos operacijos: sudėti, atimti, dauginti, dalinti";
        String actualUserAccountElementText = userAccountPage.getTextOfUserAccountElement();
        assertEquals(expectedUserAccountElementText, actualUserAccountElementText, "User account page element should have this text" + expectedUserAccountElementText);
        userAccountPage.clickLogoutLink();
        log.info("Logout is successfully done!");
    }
}
