import Utils.Utils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class registrationFormAutomation {

    WebDriver driver;

    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    @Order(2)
    public void registrationAutomation() throws InterruptedException {
        driver.get("https://demo.wpeverest.com/user-registration/guest-registration-form/");
//      Automate text field (First name, last name, email, password, gender, nationality)
        List<WebElement> textBoxElements= driver.findElements(By.className("input-text"));
        textBoxElements.get(0).sendKeys("saif");
        String randomEmail = Utils.generateRandomEmail();
        textBoxElements.get(1).sendKeys(randomEmail);
//        String randomPassword = Utils.generatePassword();
        textBoxElements.get(2).sendKeys("c1@fgAS%854d");
        textBoxElements.get(3).sendKeys("Mahmud");
        driver.findElement(By.id("radio_1665627729_Male")).click();
        Utils.scroll(driver,500);
        driver.findElement(By.id("input_box_1665629217")).sendKeys("Bangladeshi");

//      Automate Date picker
        List<WebElement> datePickerElements = driver.findElements(By.className("flatpickr-input"));
        String date = "2024-11-04";  // Use the appropriate date format
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = arguments[1];", datePickerElements.get(0), date);

//      Automate select country dropdown
        Select country = new Select(driver.findElement(By.id("country_1665629257")));
        country.selectByVisibleText("Bangladesh");

//      Automate phone number
        List<WebElement> phoneElements=driver.findElements(By.id("phone_1665627880"));
        phoneElements.get(1).sendKeys("1646744085");

        Utils.scroll(driver,1300);

//      Automate privacy policy checkbox
        driver.findElement(By.id("privacy_policy_1665633140")).click();

//      Automate submit button
        driver.findElement(By.className("ur-submit-button")).click();
        Thread.sleep(4000);

//      Automate suceess message and assertion
        String actualSuccessMessage=driver.findElement(By.tagName("ul")).getText();
        System.out.println(actualSuccessMessage);

        Assertions.assertTrue(actualSuccessMessage.contains("Login"));
    }

    @AfterAll
    public void finishTest(){
        driver.quit();
    }
}
