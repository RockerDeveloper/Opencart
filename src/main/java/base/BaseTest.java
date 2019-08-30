package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.NoSuchElementException;

@Slf4j
@Execution(ExecutionMode.CONCURRENT)
public class BaseTest {

    @BeforeEach
    void setup() {

        String runType = System.getProperty("runType", "local-chrome");
        System.out.println("runType is - " + runType);

        Configuration.baseUrl = "http://192.168.163.128/opencart/upload/"; //QA
        Configuration.startMaximized = false;
        Configuration.timeout = 15000;

        switch (runType) {
            case ("local-chrome"):
                Configuration.browserSize = "1920x1080";
                break;
            default:
                throw new NoSuchElementException("Please specify browser for a test run");
        }
    }

    @AfterEach
    void tearDown() {
        Selenide.clearBrowserCookies();

        WebDriverRunner.closeWebDriver();
    }
}
