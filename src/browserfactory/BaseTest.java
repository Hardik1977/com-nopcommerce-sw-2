package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    //Browser set up
    public static WebDriver driver;
    //public static String baseUrl="";

    public void openBrowser(String baseUrl) {
        //Launch the Chrome Browser
        driver = new ChromeDriver();
        //Open the URL into the browser
        driver.get(baseUrl);
        //Maximise window
        driver.manage().window().maximize();
        //implicit timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    public void closeBrowser() {
        //closing statement of browser
        driver.close();
    }


}
