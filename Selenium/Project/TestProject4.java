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

public class TestProject4 {
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
    public void Employee(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id=\"menu_pim_viewPimModule\"]")));
        driver.findElement(By.xpath("//a[@id=\"menu_pim_viewPimModule\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"btnAdd\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"firstName\"]")).sendKeys("Selenium");
        driver.findElement(By.xpath("//input[@id=\"lastName\"]")).sendKeys("Test");
        driver.findElement(By.xpath("//input[@id=\"btnSave\"]")).click();
        driver.findElement(By.xpath("//a[@id=\"menu_pim_viewPimModule\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"empsearch_employee_name_empName\"]")).sendKeys("Selenium Test");
        driver.findElement(By.xpath("//input[@id=\"searchBtn\"]")).click();
        if (driver.findElement(By.xpath("//td/a[contains(text(),\"Selenium\")]")).isDisplayed()) {
            System.out.println("Test is passed");
        } else
            System.out.println("Test is failed");
    }

    @AfterClass
    public void close(){
       driver.close();
    }
}
