package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //1 - click on login link
        //locate Email field element
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        //2 - Enter valid username
        WebElement eamilField = driver.findElement(By.id("Email"));
        //User input to Email field
        eamilField.sendKeys("prime12345@gmail.com");
        //3 - user enter password
        //locate Password field element
        WebElement emailPassword = driver.findElement((By.name("Password")));
        emailPassword.sendKeys("123");
        //4 - Clicking login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='button-1 login-button]"));
        loginButton.click();
        //5 - Verify the logout text is show-able.
        String expectedLogOutText = "Log out";
        WebElement LogOutLink = driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
        String actualLogOutLinkText = LogOutLink.getText();

        Assert.assertEquals("Log out text is not displayed", expectedLogOutText, actualLogOutLinkText);

    }

    @Test
    public void verifyTheErrorMessage() {
        //1.click ont he login link
        //Find the Email field element
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        //2. Enter invalid username
        WebElement emailField = driver.findElement(By.id("Email"));
        //Type the Email address to email field element
        emailField.sendKeys("lime123@gmail.com");
        //  3. Enter invalid password
        // Find the Password field Element
        WebElement emailPassword = driver.findElement(By.name("Password"));
        emailPassword.sendKeys("1234567");
        //  4. Click on Login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
        loginButton.click();
        //  5. Verify the error message
        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Error message not displayed as expected", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
