import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

public class BaseConfig {

    @BeforeAll
    public static void setUp(){
        Configuration.baseUrl = "http://192.168.163.128/opencart/upload/";
        Configuration.browserSize = "1920x1680";
    }

    @BeforeEach
    public void browserOpen(){
        Selenide.open("/");
    }

}
