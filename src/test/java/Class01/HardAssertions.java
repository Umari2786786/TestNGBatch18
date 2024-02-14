package Class01;

import org.checkerframework.checker.nullness.qual.AssertNonNullIfNonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HardAssertions {
    public static WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void  precondition(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test (groups = "smoke")
    public void verifyTheLoginFunctionality(){
        WebElement username = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        username.sendKeys("Admin");
        WebElement pasword = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        pasword.sendKeys("Hum@nhrm123");
        WebElement loginBtn = driver.findElement(By.xpath("//input[@name='Submit']"));
        loginBtn.click();
        //find element in dashboard
        WebElement dashBoard = driver.findElement(By.xpath("//h1[text()='Dashboard']"));
        String actualText = dashBoard.getText();
        String expectedText = "Dashboard";

        //verification
        Assert.assertEquals(expectedText, actualText);
        //assert that it is displayed
        boolean StateOfDashboardText = dashBoard.isDisplayed();
        Assert.assertTrue(StateOfDashboardText);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

}
