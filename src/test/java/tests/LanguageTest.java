package tests;
import java.util.Properties;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LanguagePage;


public class LanguageTest extends BasePage {
    WebDriver driver;
    Properties properties;
    BasePage basePage;
    LanguagePage languagePage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        basePage = new BasePage();
        properties = basePage.initialize_properties();
        driver = basePage.initialize_driver();
        languagePage = new LanguagePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testCase1(){
        LanguagePage.goAboutPage();
        LanguagePage.clickLang();
        LanguagePage.goEn();
        System.out.println(LanguagePage.EnGetText());
        String expectedText="About us";
        Assert.assertEquals(expectedText,LanguagePage.EnGetText());
    }

    @Test
    public void testCase2(){
        LanguagePage.goAboutPage();
        LanguagePage.clickLang();
        LanguagePage.goTr();
        System.out.println(LanguagePage.EnGetText());
        String expectedText="Hakkımızda";
        Assert.assertEquals(expectedText,LanguagePage.EnGetText());
    }
    @Test
    public void testCase3(){
        LanguagePage.goAboutPage();
        LanguagePage.clickLang();
        LanguagePage.goMon();
        System.out.println(LanguagePage.EnGetText());
        String expectedText="Бидний тухай";
        Assert.assertEquals(expectedText,LanguagePage.EnGetText());
    }
    @Test
    public void testCase4(){
        LanguagePage.goAboutPage();
        LanguagePage.clickLang();
        LanguagePage.goCh();
        System.out.println(LanguagePage.EnGetText());
        String expectedText="關於我們";
        Assert.assertEquals(expectedText,LanguagePage.EnGetText());
    }
    @Test
    public void testCase5(){
        LanguagePage.goAboutPage();
        LanguagePage.clickLang();
        LanguagePage.goRus();
        System.out.println(LanguagePage.EnGetText());
        String expectedText="O нас";
        Assert.assertEquals(expectedText,LanguagePage.EnGetText());
    }


}
