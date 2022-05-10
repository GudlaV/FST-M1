package TestProjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestProject3 {

    private WebDriver driver;
    @BeforeClass
    public void initialize(){
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
    }

    @Test
    public void login(){
        WebElement Username = driver.findElement(By.xpath("//input[@id=\"txtUsername\"]"));
        WebElement Password = driver.findElement(By.xpath("//input[@id=\"txtPassword\"]"));
        Username.sendKeys("orange");
        Password.sendKeys("orangepassword123");
        driver.findElement(By.xpath("//input[@id=\"btnLogin\"]")).click();
        if(driver.findElement(By.xpath("//a[@id=\"welcome\"]")).isDisplayed()){
            System.out.println("Homepage is Displayed");
        }else
            System.out.println("Test is Failed");
    }

    @AfterClass
    public void close(){
        driver.close();
    }
}
