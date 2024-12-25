import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class demo_registation {
    WebDriver driver;
    @BeforeAll
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }
    @Test
    public void userRegistation() throws InterruptedException {
        driver.get("https://demo.wpeverest.com/user-registration/guest-registration-form/");
        List<WebElement> textBox= driver.findElements((By.className("input-text")));
        textBox.get(0).sendKeys("Tahmid");
        textBox.get(1).sendKeys("tahmid14@gmail.com");
        textBox.get(2).sendKeys("dImdafahAt012@*");
        textBox.get(3).sendKeys("tahmid234");
        driver.findElement(By.id("radio_1665627729_Male")).click();
        WebElement gen = driver.findElement(By.id("radio_1665627729_Male"));
        Actions actions = new Actions(driver);
        actions.moveToElement(gen).perform();
        textBox.get(5).sendKeys("Bangladesh");

        List<WebElement> textFIled= driver.findElements(By.tagName("Input"));
        textFIled.get(11).click();


        List<WebElement> sellectDate= driver.findElements(By.className("flatpickr-day"));
        sellectDate.get(25).click();
        textFIled.get(14).sendKeys("01784326573");
        textFIled.get(15).sendKeys("01784326573");
        WebElement scroll= textFIled.get(15);

        actions.moveToElement(scroll).perform();
        textFIled.get(17).click();
        sellectDate.get(64).click();
        textFIled.get(20).sendKeys("4");
        textFIled.get(21).sendKeys("2");
        //Thread.sleep(1000);
       WebElement scroll2= driver.findElement(By.id("textarea_1665630078"));
       scroll2.sendKeys("Student");
        actions.moveToElement(scroll2).perform();
        List<WebElement> radioSelect= driver.findElements(By.cssSelector("[type=radio]"));
        radioSelect.get(4).click();
        radioSelect.get(5).click();
        radioSelect.get(8).click();driver.findElement(By.id("select_1665628361")).click();
        actions.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
        actions.moveToElement(radioSelect.get(9)).perform();
        Thread.sleep(1000);


        driver.findElement(By.id("privacy_policy_1665633140")).click();
        driver.findElement(By.className("ur-submit-button")).click();
       String actualStatus= driver.findElement(By.tagName("ul")).getText();
       String acceptedStatus= "User successfully registered.";
       Assertions.assertTrue(actualStatus.contains(acceptedStatus));














        //textBox.get(4)
       //textBox.get(5).sendKeys();
    }




}
