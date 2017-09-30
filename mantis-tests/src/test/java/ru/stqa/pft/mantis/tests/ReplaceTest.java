package ru.stqa.pft.mantis.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class ReplaceTest {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void ReplaceTest() {
        wd.get("http://localhost/mantisbt-2.3.3/login_page.php");
        wd.findElement(By.id("username")).click();
        wd.findElement(By.id("username")).clear();
        wd.findElement(By.id("username")).sendKeys("administrator");
        wd.findElement(By.id("password")).click();
        wd.findElement(By.id("password")).clear();
        wd.findElement(By.id("password")).sendKeys("root");
        wd.findElement(By.xpath("//form[@id='login-form']/fieldset/input[2]")).click();
        wd.findElement(By.linkText("управление")).click();
        wd.findElement(By.linkText("Управление пользователями")).click();
        wd.findElement(By.linkText("user1")).click();
        wd.findElement(By.xpath("//form[@id='account-prefs-reset-form']/fieldset/input[4]")).click();
        wd.findElement(By.xpath("//form[@id='manage-user-reset-form']/fieldset/span/input")).click();
        wd.findElement(By.xpath("//div[2]/div[2]/div[2]/div/div/div/div[2]/div/a")).click();
        wd.findElement(By.linkText("user1")).click();
        wd.findElement(By.xpath("//form[@id='manage-user-reset-form']/fieldset/span/input")).click();
        wd.findElement(By.xpath("//div[2]/div[2]/div[2]/div/div/div/div[2]/div/a")).click();
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
