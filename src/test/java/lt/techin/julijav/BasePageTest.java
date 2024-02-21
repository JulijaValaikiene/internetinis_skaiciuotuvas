package lt.techin.julijav;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.platform.commons.logging.LoggerFactory;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.logging.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class BasePageTest {
    WebDriver driver;
    Wait<WebDriver> wait;
    String mainPageURL = "http://localhost:8080/prisijungti";

//    private static final Logger log = (Logger) LoggerFactory.getLogger(BasePageTest.class);

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get(mainPageURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(4))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(TimeoutException.class);
//        log.info("Test environment initialized");

    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
//            log.info("WebDriver closed");
        }
    }
}
