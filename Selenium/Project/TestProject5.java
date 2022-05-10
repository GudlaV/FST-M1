package TestProjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestProject5 {
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
    public void myinfo(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id=\"menu_pim_viewMyDetails\"]")));
        driver.findElement(By.xpath("//a[@id=\"menu_pim_viewMyDetails\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"btnSave\"]")));
        driver.findElement(By.xpath("//input[@id=\"btnSave\"]")).click();
        WebElement firstname = driver.findElement(By.xpath("//input[@id=\"personal_txtEmpFirstName\"]"));
        firstname.clear();
        firstname.sendKeys("Harry");
        WebElement lastname = driver.findElement(By.xpath("//input[@id=\"personal_txtEmpLastName\"]"));
        lastname.clear();
        lastname.sendKeys("Potter");
        driver.findElement(By.xpath("//input[@id=\"personal_optGender_1\"]")).click();
        Select Nationality = new Select(driver.findElement(By.xpath("//select[@id=\"personal_cmbNation\"]")));
        Nationality.selectByVisibleText("Indian");
        WebElement dob = driver.findElement(By.xpath("//input[@id=\"personal_DOB\"]"));
        dob.clear();
        dob.sendKeys("2005-05-05");
        driver.findElement(By.xpath("//input[@id=\"btnSave\"]")).click();
    }

    @AfterClass
    public void close(){
        driver.close();
    }
}
