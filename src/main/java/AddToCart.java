import base.BaseTest;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.WebDriverRunner;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AddToCart extends BaseTest {
    private String EMAIL = "chapchaimax@gmail.com";
    private String PASSWORD = "ocozliaes";

    public void logInSearchingAddDelete() throws InterruptedException {
        Selenide.open("http://192.168.163.130/opencart/upload/");

        SelenideDriver webDriver = WebDriverRunner.getSelenideDriver();
        //SelenideDriver driver = new ChromeDriver();

        webDriver.$(By.className("dropdown")).click();
        webDriver.$(By.xpath("//li/a[contains(text(),'Login')]")).click();

        //fillForm
        webDriver.$(By.cssSelector("div.form-group input[" +
                "name=\"email\"]")).sendKeys(EMAIL);
        webDriver.$(By.cssSelector("div.form-group input[name=\"password\"]")).sendKeys(PASSWORD);
        webDriver.$(By.cssSelector("input[class = \"btn btn-primary\"]")).click();
        Selenide.sleep(5000);

        System.out.println("wait to add");
        webDriver.$(By.cssSelector("input[name=\"search\"]")).click();
        webDriver.$(By.cssSelector("input[name=\"search\"]")).clear();
        webDriver.$(By.cssSelector("input[name=\"search\"]")).sendKeys("mac");
        webDriver.$(By.cssSelector("button[class=\"btn btn-default btn-lg\"]")).click();
        Selenide.sleep(5000);
        //add to cart
        webDriver.$(By.xpath("//div[contains(@class,'caption')]/h4/a[contains(text(),'MacBook Pro')]" +
                "/../../following-sibling::div/button[contains(@onclick,'cart.add')]")).click();


        //go to my cart page
        webDriver.$(By.cssSelector("#cart")).click();
        Selenide.sleep(2000);
        webDriver.$(By.cssSelector(".text-right i[class=\"fa fa-shopping-cart\"]")).click();
        Selenide.sleep(5000);
        System.out.println("wait to add");
        WebElement element = webDriver.$(By.cssSelector("table[class=\"table table-bordered\"] td[class=\"text-left\"] a"));
        assertEquals("MacBook Pro", element.getText(), "The MacBook Pro has not been added");

        //delete from cart
        webDriver.$(By.cssSelector("#cart")).click();
        webDriver.$(By.cssSelector("#cart button[class=\"btn btn-danger btn-xs\"]")).click();
        System.out.println("wait until delete");
        Selenide.sleep(5000);
        WebElement emptyCart = webDriver.$(By.cssSelector("#content p"));
        assertEquals("Your shopping cart is empty!", emptyCart.getText());
        Selenide.sleep(5000);
    }

    public void noNameTest(String phone1, String phone2, String phone3) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://192.168.163.130/opencart/upload/");
        webDriver.findElement(By.className("dropdown")).click();
        webDriver.findElement(By.cssSelector("a[href=\"http://192.168.163.129/opencart/upload/index.php?route=account/login\"]")).click();
        //fillForm
        webDriver.findElement(By.cssSelector("div.form-group input[" +
                "name=\"email\"]")).sendKeys(EMAIL);
        webDriver.findElement(By.cssSelector("div.form-group input[name=\"password\"]")).sendKeys(PASSWORD);
        webDriver.findElement(By.cssSelector("input[class = \"btn btn-primary\"]")).click();
        Thread.sleep(3000);
        System.out.println("fillForm");
        //choose a filter
        webDriver.findElement(By.cssSelector("div[class=\"collapse navbar-collapse navbar-ex1-collapse\"]" +
                " a[href=\"http://192.168.163.128/opencart/upload/index.php?route=product/category&path=24\"]")).click();
        webDriver.navigate().refresh();
        System.out.println("choose a filter");
        //add by one filter
        webDriver.findElement(By.xpath("//div[contains(@class,'caption')]/h4/a[contains(text(),'HTC Touch HD')]" +
                "/../../following-sibling::div/button[contains(@onclick,'cart.add')]")).click();
        Thread.sleep(3000);
        System.out.println("add by one filter");
        //choose a variant to show the things
        webDriver.findElement(By.cssSelector("button#list-view")).click();
        System.out.println("choose a variant to show the things");
        Thread.sleep(3000);
        //add by second filter
        webDriver.findElement(By.xpath("//div[contains(@class,'caption')]/h4/a[contains(text(),'HTC Touch HD')]" +
                "/../../following-sibling::div/button[contains(@onclick,'cart.add')]")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//div[contains(@class,'caption')]/h4/a[contains(text(),'iPhone')]" +
                "/../../following-sibling::div/button[contains(@onclick,'cart.add')]")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//div[contains(@class,'caption')]/h4/a[contains(text(),'Palm Treo Pro')]" +
                "/../../following-sibling::div/button[contains(@onclick,'cart.add')]")).click();
        Thread.sleep(5000);
        System.out.println("add by second filter");
        //go to cart page
        webDriver.findElement(By.cssSelector("div#cart")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.cssSelector("div#cart " +
                "a[href=\"http://192.168.163.128/opencart/upload/index.php?route=checkout/cart\"]")).click();
        Thread.sleep(5000);
        System.out.println("go to cart page");
        //multiple all elements
        webDriver.findElement(By.xpath("//td/a[contains(text(),'HTC Touch HD')]/../following-sibling::td/div/input"))
                .click();
        webDriver.findElement(By.xpath("//td/a[contains(text(),'HTC Touch HD')]/../following-sibling::td/div/input"))
                .clear();
        webDriver.findElement(By.xpath("//td/a[contains(text(),'HTC Touch HD')]/../following-sibling::td/div/input"))
                .sendKeys(phone1);
        Thread.sleep(5000);
        webDriver.findElement(By.xpath("//td/a[contains(text(),'iPhone')]/../following-sibling::td/div/input")).click();
        webDriver.findElement(By.xpath("//td/a[contains(text(),'iPhone')]/../following-sibling::td/div/input")).clear();
        webDriver.findElement(By.xpath("//td/a[contains(text(),'iPhone')]/../following-sibling::td/div/input"))
                .sendKeys(phone2);
        Thread.sleep(5000);
        webDriver.findElement(By.xpath("//td/a[contains(text(),'Palm Treo Pro')]" +
                "/../following-sibling::td/div/input")).click();
        webDriver.findElement(By.xpath("//td/a[contains(text(),'Palm Treo Pro')]" +
                "/../following-sibling::td/div/input")).clear();
        webDriver.findElement(By.xpath("//td/a[contains(text(),'Palm Treo Pro')]" +
                "/../following-sibling::td/div/input")).sendKeys(phone3);
        webDriver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        System.out.println("multiple all elements");
        Thread.sleep(5000);
        //check if all my phones is really added
        String countOfPhonesAndSum = webDriver.findElement(By.xpath("//span[contains(text(), 'item(s)')]")).getText();
        String[] mass = countOfPhonesAndSum.split(" ");
        assertEquals("300", mass[0]);
        assertEquals("$48,099.00", mass[mass.length - 1]);
        System.out.println("check if all my phones is really added");
        //delete each one
        webDriver.findElement(By.cssSelector("button[class=\"btn btn-danger\"]")).click();
        Thread.sleep(5000);
        webDriver.findElement(By.cssSelector("button[class=\"btn btn-danger\"]")).click();
        Thread.sleep(5000);
        webDriver.findElement(By.cssSelector("button[class=\"btn btn-danger\"]")).click();
        Thread.sleep(5000);
        System.out.println("delete each one");
        //check if they dead
        String countOfPhonesAndSumAfterDelete = webDriver.findElement(By.xpath("//span[contains(text(), 'item(s)')]"))
                .getText();
        assertEquals("0 item(s) - $0.00", countOfPhonesAndSumAfterDelete, "the items did not delete");
        webDriver.quit();
    }

    public Response postImgForTest() {
        File file = new File("C:\\Users\\Максим\\Pictures\\test.jpg");
        return RestAssured.given()
                .contentType("multipart/form-data")
                .multiPart(file)
                .post("http://192.168.163.128/opencart/upload/index.php?route=tool/upload");
    }

    public void blablabla() throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://192.168.163.130/opencart/upload/");
        webDriver.findElement(By.className("dropdown")).click();
        webDriver.findElement(By.cssSelector(
                "a[href=\"http://192.168.163.130/opencart/upload/index.php?route=account/login\"]")).click();
        //fillForm
        webDriver.findElement(By.cssSelector("div.form-group input[" +
                "name=\"email\"]")).sendKeys(EMAIL);
        webDriver.findElement(By.cssSelector("div.form-group input[name=\"password\"]")).sendKeys(PASSWORD);
        webDriver.findElement(By.cssSelector("input[class = \"btn btn-primary\"]")).click();
        Thread.sleep(3000);
        System.out.println("fillForm");
        webDriver.findElement(By.cssSelector("#logo")).click();
        Thread.sleep(5000);
        //add to cart by another way
        webDriver.findElement(By.xpath("//div[contains(@class,'row')]//h4/a[contains(text(),'Apple Cinema 30')]"))
                .click();
        Thread.sleep(5000);
        webDriver.findElement(By.cssSelector("button[class=\"btn btn-primary btn-lg btn-block\"]")).click();
        Thread.sleep(5000);
        webDriver.findElement(By.name("option[218]")).click();
        //"//div[contains(@class,'form-group required')]/div/div/label/input[contains(text(),'')]"
        webDriver.findElement(By.name("option[223][]")).click();
        webDriver.findElement(By.cssSelector("#input-option208")).click();
        webDriver.findElement(By.cssSelector("#input-option208")).clear();
        webDriver.findElement(By.cssSelector("#input-option208")).sendKeys("just for test");
        webDriver.findElement(By.cssSelector("#input-option217")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.cssSelector("#input-option217 option[value =\"4\"]")).click();
        webDriver.findElement(By.cssSelector("#input-option209")).click();
        webDriver.findElement(By.cssSelector("#input-option209")).clear();
        webDriver.findElement(By.cssSelector("#input-option209")).sendKeys("text area for test");
        //postImgForTest();
        WebElement uploadImage = webDriver.findElement(By.cssSelector("#button-upload222"));
//        uploadImage.sendKeys("C:\\Users\\Максим\\Desktop\\test.txt");
        uploadImage.click();
        StringSelection ss = new StringSelection("C:\\Users\\Максим\\Pictures\\test.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        webDriver.switchTo().alert().accept();
        Thread.sleep(3000);
        webDriver.findElement(By.cssSelector(".form-group #button-cart")).click();
        Thread.sleep(5000);
        webDriver.findElement(By.cssSelector("button[class=\"btn btn-inverse btn-block btn-lg dropdown-toggle\"]")).click();
        webDriver.findElement(By.cssSelector(".text-right i[class=\"fa fa-shopping-cart\"]")).click();
        Thread.sleep(5000);
        String countOfPhonesAndSum = webDriver.findElement(By.xpath("//span[contains(text(), 'item(s)')]")).getText();
        String[] mass = countOfPhonesAndSum.split(" ");
        assertEquals("2", mass[0]);
        Thread.sleep(3000);
        //conformation
        webDriver.findElement(By.cssSelector("div[class=\"pull-right\"] ")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.cssSelector("input[value=\"new\"]")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.cssSelector("input[name=\"firstname\"]")).click();
        webDriver.findElement(By.cssSelector("input[name=\"firstname\"]")).clear();
        webDriver.findElement(By.cssSelector("input[name=\"firstname\"]")).sendKeys("TestName");
        webDriver.findElement(By.cssSelector("input[name=\"lastname\"]")).click();
        webDriver.findElement(By.cssSelector("input[name=\"lastname\"]")).clear();
        webDriver.findElement(By.cssSelector("input[name=\"lastname\"]")).sendKeys("TestLastName");
        webDriver.findElement(By.cssSelector("div[class=\"form-group required\"] input[placeholder=\"Address 1\"]"))
                .click();
        webDriver.findElement(By.cssSelector("div[class=\"form-group required\"] input[placeholder=\"Address 1\"]"))
                .clear();
        webDriver.findElement(By.cssSelector("div[class=\"form-group required\"] input[placeholder=\"Address 1\"]"))
                .sendKeys("TestAdress");

        webDriver.findElement(By.cssSelector("input[placeholder=\"City\"]")).click();
        webDriver.findElement(By.cssSelector("input[placeholder=\"City\"]")).clear();
        webDriver.findElement(By.cssSelector("input[placeholder=\"City\"]")).sendKeys("Kakhovka");

        webDriver.findElement(By.cssSelector("input[name=\"postcode\"]")).click();
        webDriver.findElement(By.cssSelector("input[name=\"postcode\"]")).clear();
        webDriver.findElement(By.cssSelector("input[name=\"postcode\"]")).sendKeys("228");

        Select country = new Select(webDriver.findElement(By.cssSelector("#input-payment-country")));
        webDriver.findElement(By.cssSelector("#input-payment-country")).click();
        country.selectByVisibleText("Ukraine");

        Select zone = new Select(webDriver.findElement(By.cssSelector("#input-payment-zone")));
        webDriver.findElement(By.cssSelector("#input-payment-zone")).click();
        zone.selectByVisibleText("Khersons'ka Oblast'");
        webDriver.findElement(By.cssSelector("input[value = \"Continue\"]")).click();
        Thread.sleep(2000);

        webDriver.findElement(By.cssSelector("#collapse-shipping-address .panel-body .form-horizontal input[value=\"existing\"]"))
                .click();
        webDriver.findElement(By.cssSelector(".pull-right #button-shipping-address")).click();
        Thread.sleep(2000);

        webDriver.findElement(By.cssSelector(".panel-body textarea")).click();
        webDriver.findElement(By.cssSelector(".panel-body textarea")).clear();
        webDriver.findElement(By.cssSelector(".panel-body textarea")).sendKeys("bla bla bla test");
        webDriver.findElement(By.cssSelector(".pull-right #button-shipping-method")).click();
        Thread.sleep(2000);


        webDriver.findElement(By.cssSelector(".pull-right .agree")).click();
        Thread.sleep(2000);
        String termsAndConditions = webDriver.findElement(By.cssSelector(".modal-body p")).getText();
        assertEquals("Terms & Conditions", termsAndConditions, "Something gets wrong");
        webDriver.findElement(By.cssSelector(".close")).click();
        webDriver.findElement(By.cssSelector("input[name=\"agree\"]")).click();
        webDriver.findElement(By.cssSelector(".pull-right #button-payment-method")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.cssSelector("button[class=\"btn btn-inverse btn-block btn-lg dropdown-toggle\"]")).click();
        String infoAboutOrderFromFirst = webDriver.findElement(By.cssSelector("table[class=\"table table-striped\"]" +
                " td[class=\"text-left\"]")).getText();
        String infoAboutOrderFromSecond = webDriver.findElement(By.cssSelector("table[class=\"table table-bordered" +
                " table-hover\"] tbody .text-left ")).getText();
        infoAboutOrderFromSecond = infoAboutOrderFromSecond.replaceAll(":\\s", " ");
        infoAboutOrderFromSecond = infoAboutOrderFromSecond.replaceAll("\\s-", "-");
        assertNotEquals(infoAboutOrderFromFirst, infoAboutOrderFromSecond, "The orders do not equal");

        webDriver.findElement(By.cssSelector("input[value=\"Confirm Order\"]")).click();
        Thread.sleep(2000);
        String success = webDriver.findElement(By.cssSelector("#content h1")).getText();
        assertEquals("Your order has been placed!", success, "The order does not placed");
        webDriver.findElement(By.cssSelector("a[class=\"btn btn-primary\"]")).click();
        Thread.sleep(2000);
        webDriver.quit();
    }

    public void withoutLogIn() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://192.168.163.130/opencart/upload/");
        webDriver.findElement(By.xpath("//ul[contains(@class,'nav navbar-nav')]/li/a[contains(text(),'MP3 Players')]"))
                .click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//div[contains(@class,'collapse navbar-collapse navbar-ex1-collapse')]" +
                "/ul/li/div/a[contains(text(),'Show All MP3 Players')]")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//div[contains(@class,'caption')]/h4/a[contains(text(),'iPod Shuffle')]" +
                "/../../following-sibling::div/button[contains(@onclick,'cart.add')]")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.cssSelector("#cart")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.cssSelector(".text-right i[class=\"fa fa-shopping-cart\"]")).click();
        String productName = webDriver.findElement(By.cssSelector("table[class=\"table table-bordered\"] .text-left a"))
                .getText();
        assertEquals("iPod Shuffle", productName, "The product did not booked right");
        Thread.sleep(2000);
        webDriver.findElement(By.cssSelector("h4[class=\"panel-title\"] a[class=\"accordion-toggle\"]")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.cssSelector("#input-coupon")).click();
        webDriver.findElement(By.cssSelector("#input-coupon")).clear();
        webDriver.findElement(By.cssSelector("#input-coupon")).sendKeys("ASDF-1221-ASDA-9999");
        webDriver.findElement(By.cssSelector("input[id=\"button-coupon\"]")).click();
        Thread.sleep(3000);
        String coupon = webDriver.findElement(By.cssSelector("div[class=\"alert alert-danger\"]")).getText();
        assertEquals("Warning: Coupon is either invalid, expired or reached its usage limit!\n×", coupon,
                "It is magic - coupon works");
        webDriver.findElement(By.xpath("//div[contains(@class,'panel panel-default')]" +
                "//a[contains(text(),'Estimate Shipping & Taxes')]")).click();
        Thread.sleep(2000);
        Select country = new Select(webDriver.findElement(By.cssSelector("#input-country")));
        webDriver.findElement(By.cssSelector("#input-country")).click();
        country.selectByVisibleText("Tunisia");
        Select region = new Select(webDriver.findElement(By.cssSelector("#input-zone")));
        webDriver.findElement(By.cssSelector("#input-zone")).click();
        region.selectByVisibleText("Gabes");
        webDriver.findElement(By.cssSelector("#input-postcode")).click();
        webDriver.findElement(By.cssSelector("#input-postcode")).clear();
        webDriver.findElement(By.cssSelector("#input-postcode")).sendKeys("123");
        webDriver.findElement(By.cssSelector("button[id=\"button-quote\"]")).click();
        Thread.sleep(2000);
        assertEquals("Flat Shipping Rate - $8.00", webDriver.findElement(By.cssSelector(".radio label")).getText(),
                "The quotes has been changed");
        Thread.sleep(2000);
        webDriver.findElement(By.cssSelector("input[name=\"shipping_method\"]")).click();
        webDriver.findElement(By.cssSelector(".modal-footer input")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//a[contains(text(),'Use Gift Certificate ')]")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.cssSelector("input[name=\"voucher\"]")).click();
        webDriver.findElement(By.cssSelector("input[name=\"voucher\"]")).clear();
        webDriver.findElement(By.cssSelector("input[name=\"voucher\"]")).sendKeys("PODAROK14");
        webDriver.findElement(By.cssSelector("input[value=\"Apply Gift Certificate\"]")).click();
        Thread.sleep(2000);
        assertEquals("Warning: Gift Certificate is either invalid or the balance has been used up!\n×",
                webDriver.findElement(By.cssSelector("div[class=\"alert alert-danger\"] ")).getText(),
                "It is a magic - a Gift Certificate works ");
        webDriver.findElement(By.cssSelector("a[class=\"btn btn-primary\"]")).click();
        Thread.sleep(1000);
        assertEquals("Checkout Options:", webDriver.findElement(By.cssSelector("#content p")).getText()
                , "Unbelievable, a product should not add");
        Thread.sleep(2000);
        webDriver.findElement(By.cssSelector("#input-email")).click();
        webDriver.findElement(By.cssSelector("#input-email")).clear();
        webDriver.findElement(By.cssSelector("#input-email")).sendKeys(EMAIL);

        webDriver.findElement(By.cssSelector("#input-password")).click();
        webDriver.findElement(By.cssSelector("#input-password")).clear();
        webDriver.findElement(By.cssSelector("#input-password")).sendKeys(PASSWORD);

        webDriver.findElement(By.cssSelector("input#button-login")).click();
        Thread.sleep(3000);

        webDriver.findElement(By.cssSelector("input#button-payment-address")).click();
        Thread.sleep(2000);

        webDriver.findElement(By.cssSelector("#collapse-shipping-address input[value=\"new\"]")).click();
        //new adress
        webDriver.findElement(By.cssSelector("#input-shipping-firstname")).click();
        webDriver.findElement(By.cssSelector("#input-shipping-firstname")).clear();
        webDriver.findElement(By.cssSelector("#input-shipping-firstname")).sendKeys("Tech");

        webDriver.findElement(By.cssSelector("#input-shipping-lastname")).click();
        webDriver.findElement(By.cssSelector("#input-shipping-lastname")).clear();
        webDriver.findElement(By.cssSelector("#input-shipping-lastname")).sendKeys("Lead");

        webDriver.findElement(By.cssSelector("#input-shipping-address-1")).click();
        webDriver.findElement(By.cssSelector("#input-shipping-address-1")).clear();
        webDriver.findElement(By.cssSelector("#input-shipping-address-1")).sendKeys("SoftServe");

        webDriver.findElement(By.cssSelector("#input-shipping-city")).click();
        webDriver.findElement(By.cssSelector("#input-shipping-city")).clear();
        webDriver.findElement(By.cssSelector("#input-shipping-city")).sendKeys("Lviv");

        webDriver.findElement(By.cssSelector("#input-shipping-city")).click();
        webDriver.findElement(By.cssSelector("#input-shipping-city")).clear();
        webDriver.findElement(By.cssSelector("#input-shipping-city")).sendKeys("Lviv");

        Select countryForAdress = new Select(webDriver.findElement(By.cssSelector("#input-shipping-country")));
        webDriver.findElement(By.cssSelector("#input-shipping-country")).click();
        countryForAdress.selectByVisibleText("Ukraine");

        Select regionForAdress = new Select(webDriver.findElement(By.cssSelector("#input-shipping-zone")));
        webDriver.findElement(By.cssSelector("#input-shipping-zone")).click();
        regionForAdress.selectByVisibleText("L'vivs'ka Oblast'");

        webDriver.findElement(By.cssSelector("input#button-shipping-address")).click();
        Thread.sleep(2000);

        webDriver.findElement(By.cssSelector("textarea.form-control")).click();
        webDriver.findElement(By.cssSelector("textarea.form-control")).clear();
        webDriver.findElement(By.cssSelector("textarea.form-control")).sendKeys("I WANT TO BE FREE");
        webDriver.findElement(By.cssSelector("input#button-shipping-method")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.cssSelector("a.agree")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.cssSelector("button.close")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.cssSelector("input[name=\"agree\"]")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.cssSelector("input#button-payment-method")).click();
        Thread.sleep(2000);
        assertEquals("iPod Shuffle", webDriver.findElement(By.cssSelector("div.table-responsive tbody" +
                " td.text-left a")).getText(), "Product name does not appear to request");
        assertEquals("$105.00", webDriver.findElement(By.xpath("//tfoot/tr/td[contains(text(),'$105')]")).getText(),
                "The price does not appear to requirements");
        webDriver.findElement(By.cssSelector("input[value=\"Confirm Order\"]")).click();
        Thread.sleep(2000);

        assertEquals("Your order has been placed!", webDriver.findElement(By.cssSelector("#content h1")).getText(),
                "The order must be added");
        webDriver.findElement(By.cssSelector("div.pull-right a[class=\"btn btn-primary\"]")).click();
        webDriver.quit();
    }

    public void wrongData() {
        Selenide.open("http://192.168.163.130/opencart/upload/");
        SelenideDriver webDriver = WebDriverRunner.getSelenideDriver();
        webDriver.$(By.xpath("\"//ul[contains(@class,'nav navbar-nav')]/li/a[contains(text(),'Cameras')]\"")).click();
    }


}
