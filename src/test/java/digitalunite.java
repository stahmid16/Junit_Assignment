import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.image.Kernel;
import java.sql.Driver;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class digitalunite {
  WebDriver driver;
    @BeforeAll
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


    }

  public static void scrollToElement(WebDriver driver, WebElement element) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
  }


  @Test
    public void formSubmit() throws InterruptedException {
      driver.get("https://www.digitalunite.com/practice-webform-learners");
      driver.findElement(By.xpath("//button[contains(@class,'close')]")).click();
      driver.findElement(By.id("edit-name")).sendKeys("I am tahmid");
      List<WebElement> textBox= driver.findElements((By.className("form-control")));
      textBox.get(1).sendKeys("01743564256");
      textBox.get(2).sendKeys("12/22/2024");


     Thread.sleep(10000);
      //WebElement date= textBox.get(2);

    //Actions actionsd = new Actions(driver);
    //actionsd.moveToElement(date).perform();
    //WebElement dateset= driver.findElement(By.id("edit-date"));
    //dateset.click();
    //dateset.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
    //dateset.sendKeys(Keys.LEFT,Keys.LEFT);
    //dateset.sendKeys("24/12/2024");
    //dateset.sendKeys(Keys.TAB);


      textBox.get(3).sendKeys("tahmid13@gmailcom");
        textBox.get(4).sendKeys("Simple person");
        driver.findElement(By.id("edit-uploadocument-upload")).sendKeys("F:\\ss.png");

//      JavascriptExecutor js = (JavascriptExecutor) driver;
//      js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

//        Thread.sleep(10000);
        WebElement age = driver.findElement(By.id("edit-age"));
//        scrollToElement(driver, age);
    Actions actions = new Actions(driver);
    actions.moveToElement(age).perform();
   // actions.click().perform();
    age.click();
//        age.click();
//        .click();
    WebElement submit = driver.findElement(By.id("edit-submit"));
    Actions action2s = new Actions(driver);
    action2s.moveToElement(submit).perform();
    action2s.click().perform();
    driver.switchTo().alert().accept();
    String actualStatus= driver.findElement(By.tagName("h1")).getText();
    String acceptedStatus= "Thank you for your submission!";
    Assertions.assertTrue(actualStatus.contains(acceptedStatus));


//    scrollToElement(driver, submit);
//    submit.click();
//        driver.findElement(By.id("edit-submit")).click();



    }
}
