package tests;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BlogPage;
import pages.HomePage;
import util.HelperMethods;

import java.util.List;
import java.util.Properties;

public class HomePageTest extends BasePage {
    WebDriver driver;
    Properties properties;
    BasePage basePage;
    HomePage homePage;
    By seeCoursesBtn = By.xpath("//*[@id=\"about-section\"]/div/div/div[1]/a");
    By signUp = By.xpath("//*[@id=\"btnFree\"]");


    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        basePage = new BasePage();
        properties = basePage.initialize_properties();
        driver = basePage.initialize_driver();
        homePage=new HomePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testCase1(){
        HelperMethods.doClick(driver.findElement(By.xpath("//*[@id=\"btnFree\"]")));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"btnFree\"]")).isEnabled());
    }
    @Test
    public void testCase2() throws InterruptedException{
        Thread.sleep(1000);
       HelperMethods.doClick(driver.findElement(By.xpath("//*[@id=\"about-section\"]/div/div/div[1]/a")));
        Thread.sleep(1000);
        String expectedUrl = "https://ispeakbetter.com/courses";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }
    @Test
    public void testCase3() throws InterruptedException{
        Thread.sleep(1000);
        HelperMethods.doClick(driver.findElement(By.xpath("//a[@data-text='Learn more']")));
        Thread.sleep(1000);
        String expectedUrl = "https://ispeakbetter.com/about";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }
    @Test
    public void testCase4(){
        By duration = By.xpath("//span[@class='select2 select2-container select2-container--default select2-container--below select2-container--open']//span[@class='dropdown-wrapper']");
        List<WebElement> options = driver.findElements(duration);

        System.out.println(options.size());

        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).getText().equals("30")) {
                options.get(i).click();
            }
        }
        String expectedText = "30";
        String actualText = driver.findElement(By.xpath("//*[@id=\"select2-class_duration-container\"]")).getText();
        Assert.assertEquals(expectedText, actualText);
    }
    @Test
    public void testCase5(){
        By program = By.xpath("//span[@class='select2 select2-container select2-container--default select2-container--below']//span[@class='dropdown-wrapper']");
        List<WebElement> options1 = driver.findElements(program);

        System.out.println(options1.size());

        for (int i = 0; i < options1.size(); i++) {
            if (options1.get(i).getText().equals("Business English")) {
                options1.get(i).click();
            }
        }
        String expectedText = "Business English";
        String actualText = driver.findElement(By.xpath("//span[@id='select2-course_program-container']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }


}
