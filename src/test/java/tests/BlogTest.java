package tests;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BlogPage;
import pages.CoursesPage;

import java.util.Properties;

public class BlogTest extends BasePage{
    WebDriver driver;
    Properties properties;
    BasePage basePage;
    BlogPage blogPage;


    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        basePage = new BasePage();
        properties = basePage.initialize_properties();
        driver = basePage.initialize_driver();
        blogPage=new BlogPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testCase1() throws InterruptedException{
        driver.findElement(By.xpath("//span[@data-hover='Blog']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='main']/div[@class='container']" +
                "/div[@class='vc_row wpb_row vc_row-fluid']/div[@class='wpb_column vc_column_container" +
                " vc_col-sm-12']/div[contains(@class,'vc_column-inner')]/div[@class='wpb_wrapper']" +
                "/div[@class='post_list_main_section_wrapper']/div[1]/div[1]/div[1]/div[1]/a[1]")).click();
        Thread.sleep(1000);
        String Url= "https://blog.ispeakbetter.com/how-to-sound-like-a-native-english-speaker/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(Url, actualUrl);
    }
    @Test
    public void testCase2() throws InterruptedException{
        driver.findElement(By.xpath("//span[@data-hover='Blog']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='vc_row wpb_row vc_row-fluid']//div[2]//div[2]//" +
                "div[1]//div[2]//div[1]//div[1]//div[3]//a[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[normalize-space()='2']")).click();
        Thread.sleep(1000);
        String Url= "https://blog.ispeakbetter.com/category/english-article/page/2/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(Url, actualUrl);
    }
    @Test
    public void testCase3() throws InterruptedException{
        driver.findElement(By.xpath("//span[@data-hover='Blog']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[normalize-space()='3 Hacks to Learn English Better and Faster']")).click();
        Thread.sleep(1000);
        String Url= "https://blog.ispeakbetter.com/3-hacks-to-learn-english-better-and-faster/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(Url, actualUrl);
    }
    @Test
    public void testCase4() throws InterruptedException{
        driver.findElement(By.xpath("//span[@data-hover='Blog']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'Aced your TOEFL/IELTS? Here are the top destinatio')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[normalize-space()='https://www.ielts.org/ielts/destinations']")).click();
        Thread.sleep(1000);
        String Url= "https://www.ielts.org/ielts/destinations";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(Url, actualUrl);
    }
    @Test
    public void testCase5() throws InterruptedException{
        driver.findElement(By.xpath("//span[@data-hover='Blog']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[normalize-space()='Online learning']")).click();
        Thread.sleep(1000);
        String Url= "https://blog.ispeakbetter.com/tag/online-learning/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(Url, actualUrl);
    }
}
