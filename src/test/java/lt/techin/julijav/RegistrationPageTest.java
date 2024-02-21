package lt.techin.julijav;

import ch.qos.logback.classic.Logger;


import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationPageTest extends BasePageTest {
    LoginPage loginPage;
    RegistrationPage registrationPage;
    SuccessfullyRegistrationPage successfullyRegistrationPage;
    String userName = "Marta";
    String existingUserName = "Marta";

    String userPassword = "Marta159";
    private final Logger log = (Logger) LoggerFactory.getLogger(RegistrationPageTest.class);

    @Test
    public void userRegistration() {

        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        successfullyRegistrationPage = new SuccessfullyRegistrationPage(driver);

        String expectedLoginElementText = "Prisijungimas";
        String actualLoginElementText = loginPage.getTextOfLoginElement();
        assertEquals(expectedLoginElementText, actualLoginElementText, "Login page element should have this text" + expectedLoginElementText);
        loginPage.clickCreateNewUserLink();
        String expectedRegElementText = "Naujos paskyros sukūrimas";
        String actualRegElementText = registrationPage.getTextOfRegistrationElement();
        assertEquals(expectedRegElementText, actualRegElementText, "Registration page element should have this text" + expectedRegElementText);
        registrationPage.enterRegistrationNameInput(userName);
        registrationPage.enterRegistrationPasswordInput(userPassword);
        registrationPage.enterRegistrationPasswordConfirmationInput(userPassword);
        registrationPage.clickCreateNewUserButton();
//        String expectedSuccessfulRegButtonText = "skaičiuoti";
//        String actualSuccessfulRegButtonText = successfullyRegistrationPage.getTextOfCalculateButton();
//        assertEquals(expectedSuccessfulRegButtonText, actualSuccessfulRegButtonText, "Successful Registration page button should have this text" + expectedSuccessfulRegButtonText);
        log.info("Registration is successfully done!");
    }

    @Test
    public void existingUserRegistration() {

        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        successfullyRegistrationPage = new SuccessfullyRegistrationPage(driver);

        String expectedLoginElementText = "Prisijungimas";
        String actualLoginElementText = loginPage.getTextOfLoginElement();
        assertEquals(expectedLoginElementText, actualLoginElementText, "Login page element should have this text" + expectedLoginElementText);
        loginPage.clickCreateNewUserLink();
        String expectedRegElementText = "Naujos paskyros sukūrimas";
        String actualRegElementText = registrationPage.getTextOfRegistrationElement();
        assertEquals(expectedRegElementText, actualRegElementText, "Registration page element should have this text" + expectedRegElementText);
        registrationPage.enterRegistrationNameInput(existingUserName);
        registrationPage.clickCreateNewUserButton();
        String expectedErrorRegNameText = "Toks vartotojo vardas jau egzistuoja";
        String actualErrorRegNameText = registrationPage.getTextErrorMessageOfRegistrationNameInput();
        assertEquals(expectedErrorRegNameText, actualErrorRegNameText, "Registration page element should have this text" + expectedErrorRegNameText);
        log.info("Existing User Registration Test is successfully done!");
    }

}
