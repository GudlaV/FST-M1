package TestProjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestProject7 {
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
    public void qual(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id=\"menu_pim_viewMyDetails\"]")));
        driver.findElement(By.xpath("//a[@id=\"menu_pim_viewMyDetails\"]")).click();
        driver.findElement(By.xpath("//ul[@id=\"sidenav\"]//a[contains(text(),\"Qualifications\")]")).click();
        driver.findElement(By.xpath("//input[@id=\"addWorkExperience\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"experience_employer\"]")).sendKeys("0");
        driver.findElement(By.xpath("//input[@id=\"experience_jobtitle\"]")).sendKeys("0");
        driver.findElement(By.xpath("//input[@id=\"btnWorkExpSave\"]")).click();

    }
    @AfterClass
    public void close(){
        driver.close();
    }
}
