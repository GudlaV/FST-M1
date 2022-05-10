package TestProjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestProject2 {
    private WebDriver driver;
    @BeforeClass
    public void initialize(){
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
    }

    @Test
    public void image(){
        WebElement Header_Image = driver.findElement(By.xpath("//img[@src=\"/orangehrm/symfony/web/webres_5d69118beeec64.10301452/themes/default/images/login/logo.png\"]"));
        System.out.println("URL is: " + Header_Image.getAttribute("src"));
    }

    @AfterClass
    public void close(){
        driver.close();
    }
}
