package TestProjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestProject6 {
    private WebDriver driver;
    @BeforeClass
    public void initialize(){
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        WebElement Username = driver.findElement(By.xpath("//input[@id=\"txtUsername\"]"));
        WebElement Password = driver.findElement(By.xpath("//input[@id=\"txtPassword\"]"));
        Username.sendKeys("orange");
        Password.sendKeys("orangepassword123");
        driver.findElement(By.xpath("//input[@id=\"btnLogin\"]")).click();
    }
    @Test
    public void dir(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id=\"menu_directory_viewDirectory\"]")));
        WebElement directory = driver.findElement(By.xpath("//a[@id=\"menu_directory_viewDirectory\"]"));
        Boolean visible = directory.isDisplayed();
        Boolean clickable = directory.isEnabled();
        System.out.println(visible + " " + clickable);
        if (visible && clickable) {
            directory.click();
            String heading = driver.findElement(By.xpath("//div[@id=\"content\"]/div/div/h1")).getText();
            Assert.assertEquals(heading,"Search Directory");
            /*System.out.println(heading);
            if (heading.equals("Search Directory")) {
                System.out.println("Test is Passed");
                driver.close();
            } else
                System.out.println("Failed");*/
        } else
            System.out.println("Test is Failed");
    }

    @AfterClass
    public void close(){
       driver.close();
    }
}
