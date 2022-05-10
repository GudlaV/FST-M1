package TestProjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestProject1 {
    private WebDriver driver;

    @BeforeClass
    public void initialize(){
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        }

        @Test
    public void title(){
            Assert.assertEquals(driver.getTitle(),"OrangeHRM");
        }

        @AfterClass
    public void close(){
        driver.close();
        }
}
