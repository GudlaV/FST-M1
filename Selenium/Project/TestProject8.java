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

public class TestProject8 {
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
    public void leave(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),\"Apply Leave\")]")));
        driver.findElement(By.xpath("//span[contains(text(),\"Apply Leave\")]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id=\"applyleave_txtLeaveType\"]")));
        Select leave = new Select(driver.findElement(By.xpath("//select[@id=\"applyleave_txtLeaveType\"]")));
        leave.selectByVisibleText("DayOff");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"applyleave_txtFromDate\"]")));
        WebElement fromdate = driver.findElement(By.xpath("//input[@id=\"applyleave_txtFromDate\"]"));
        fromdate.clear();
        fromdate.sendKeys("2022-04-26");
        WebElement todate = driver.findElement(By.xpath("//input[@id=\"applyleave_txtToDate\"]"));
        todate.clear();
        todate.sendKeys("2022-04-27");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"applyBtn\"]")));
        driver.findElement(By.xpath("//input[@id=\"applyBtn\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id=\"menu_leave_viewMyLeaveList\"]")));
        driver.findElement(By.xpath("//a[@id=\"menu_leave_viewMyLeaveList\"]")).click();
        WebElement searchdate1 = driver.findElement(By.xpath("//input[@id=\"calFromDate\"]"));
        searchdate1.clear();
        searchdate1.sendKeys("2022-04-26");
        WebElement searchdate2 = driver.findElement(By.xpath("//input[@id=\"calToDate\"]"));
        searchdate2.clear();
        searchdate2.sendKeys("2022-04-27");
        driver.findElement(By.xpath("//input[@id=\"btnSearch\"]")).click();
        String text = driver.findElement(By.xpath("//td/a[contains(text(),\"Pending Approval\")]")).getText();
        System.out.println("Status of the Leave is : " + text);
    }
    @AfterClass
    public void close(){
        driver.close();
    }

}
