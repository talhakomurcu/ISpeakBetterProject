package tests;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CoursesPage;
import pages.LanguagePage;

import java.util.Properties;

import static base.BasePage.driver;

public class CoursesTest extends BasePage {

    WebDriver driver;
    Properties properties;
    BasePage basePage;
    CoursesPage coursesPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        basePage = new BasePage();
        properties = basePage.initialize_properties();
        driver = basePage.initialize_driver();
        coursesPage = new CoursesPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testCase1() throws InterruptedException{
        CoursesPage.clickToCoursesBtn();
        Thread.sleep(1000);
        String Url= "https://ispeakbetter.com/courses";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(Url, actualUrl);
    }
    @Test
    public void testCase2()throws InterruptedException{
        CoursesPage.clickToCoursesBtn();
        Thread.sleep(1000);
        CoursesPage.clickToFirstEnrolmentBtn();
        Thread.sleep(1000);
        boolean verification=CoursesPage.isEnrolmentPageOpened();
        Assert.assertTrue(verification);
    }
    @Test
    public void testCase3()throws InterruptedException{
        CoursesPage.clickToCoursesBtn();
        Thread.sleep(1000);
        CoursesPage.clickToSecondEnrolmentBtn();
        Thread.sleep(1000);
        boolean verification=CoursesPage.isEnrolmentPageOpened();
        Assert.assertTrue(verification);
    }
    @Test
    public void testCase4()throws InterruptedException{
        CoursesPage.clickToCoursesBtn();
        Thread.sleep(1000);
        CoursesPage.clickToThirdEnrolmentBtn();
        Thread.sleep(1000);
        boolean verification=CoursesPage.isEnrolmentPageOpened();
        Assert.assertTrue(verification);
    }
    @Test
    public void testCase5()throws InterruptedException{
        CoursesPage.clickToCoursesBtn();
        Thread.sleep(1000);
        CoursesPage.clickToFourthEnrolmentBtn();
        Thread.sleep(1000);
        boolean verification=CoursesPage.isEnrolmentPageOpened();
        Assert.assertTrue(verification);
    }

}
