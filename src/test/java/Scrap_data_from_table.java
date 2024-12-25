import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class Scrap_data_from_table {

    WebDriver driver;

    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }
    @Test
    public void scrap_data() throws IOException {
        driver.get("https://dsebd.org/latest_share_price_scroll_by_value.php");
        List<WebElement> getTable = driver.findElements(By.className("table"));
        WebElement table = getTable.get(1);
        List<WebElement> allRows = table.findElements(By.tagName("tr"));

        BufferedWriter writer = new BufferedWriter(new FileWriter("./src/main/resources/scraped.txt"));
        for (WebElement row : allRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            StringBuilder rowText = new StringBuilder();
            for (WebElement cell : cells) {
                rowText.append(cell.getText()).append("\t"); // Append cell text with a tab separator
            }
            if (rowText.length() > 0) {
                String outputRow = rowText.toString().trim();
                System.out.println(outputRow); // Print the row to the console
                writer.write(outputRow);      // Write the row to the file
                writer.newLine();             // Add a new line in the file
            }
        }
        writer.close(); // Ensure the writer is closed after finishing
    }

}
//./src/main/resources/user.json
