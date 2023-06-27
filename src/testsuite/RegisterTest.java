package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {

    //Declaring BaseURL
    String baseUrl = "https://demo.nopcommerce.com/";

    @Test
    public void testUserShouldNavigateToRegisterPageSuccessfully() {
        // Click on the "Register" link
        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();

        // Verify the text "Register"
        String expectedText = "Register";
        String actualText = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[1]/h1")).getText();
        Assert.assertEquals("Navigated to Register page", expectedText, actualText);

    }

    @Test
    public void testUserSholdRegisterAccountSuccessfully() {

        // Click on the "Register" link
        driver.findElement(By.linkText("Register")).click();
        // Select gender radio button
        driver.findElement(By.xpath("//input[@id = 'gender-male']")).click();
        // Enter First name
        driver.findElement(By.xpath("//input[@id = 'FirstName']")).sendKeys("Ankur");
        // Enter Last name
        driver.findElement(By.xpath("//input[@id = 'LastName']")).sendKeys("Rathod");
        // Select Day Month and Year
        driver.findElement(By.xpath("//select[@name = 'DateOfBirthDay']//option[text() = '1']")).click();
        driver.findElement(By.xpath("//select[@name = 'DateOfBirthMonth']//option[text() = 'January']")).click();
        driver.findElement(By.xpath("//select[@name = 'DateOfBirthYear']//option[text() = '2001']")).click();
        // Enter Email address
        driver.findElement(By.xpath("//input[@id = 'Email']")).sendKeys("prime123@gmail.com");
        // Enter Password
        driver.findElement(By.xpath("//input[@id = 'Password']")).sendKeys("Prime");

        // Enter Confirm password
        driver.findElement(By.xpath("//input[@id = 'ConfirmPassword']")).sendKeys("Prime3");

        // Click on REGISTER button
        driver.findElement(By.xpath("//button[@id = 'register-button']")).click();

        // Verify the text 'Your registration completed
        String expected = "Your registration completed";
        String actual = driver.findElement(By.xpath("//div[text() = 'Your registration completed']")).getText();
        Assert.assertEquals(expected, actual);
    }

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
