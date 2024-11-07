import Utils.Utils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class webFormAutomation {

    WebDriver driver;

    @BeforeAll
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    @Order(1)
    public void formSubmission() throws InterruptedException {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        List<WebElement> formInputElements = driver.findElements(By.className("form-control"));
//      Automate Writing Name
        formInputElements.get(0).sendKeys("Rafeed Bin Akbar");
//      Automate Number
        formInputElements.get(1).sendKeys("01646744094");
//      Automate Date Picker
        formInputElements.get(2).sendKeys(Keys.CONTROL,"a");
        formInputElements.get(2).sendKeys(Keys.BACK_SPACE);
        formInputElements.get(2).sendKeys("5/20/2024");
//      Automate Writing Email
        formInputElements.get(3).sendKeys("binakbar3456@gmail.com");
//      Automate Writing about yourself
        formInputElements.get(4).sendKeys("I am a detailed oriented software tester.");
//      Automate uploading image
        String relativePath="\\src\\test\\resources\\q5.jpg";
        String absolutePath=System.getProperty("user.dir")+relativePath;
        driver.findElement(By.id("edit-uploadocument-upload")).sendKeys(absolutePath);
        Thread.sleep(5000);
//      Automate Scrolling
        Utils.scroll(driver,700);
        Thread.sleep(3000);
//      Automate checkbox
        driver.findElement(By.id("edit-age")).click();
//      Automate submission by clicking button
        driver.findElement(By.id("edit-submit")).click();

//      Automate successful submission message
        driver.get("https://www.digitalunite.com/node/5932/webform/confirmation");
        String successMessage= driver.findElement(By.className("webform-confirmation__message")).getText();
        String actualMessage="New submission added to Practice webform for learners.";
        Assertions.assertEquals(successMessage,actualMessage);

    }

    @AfterAll
    public void finishTest(){
        driver.quit();
    }

}
