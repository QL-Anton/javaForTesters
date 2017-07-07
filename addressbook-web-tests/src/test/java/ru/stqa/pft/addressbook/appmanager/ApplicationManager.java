package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Антон on 07.07.2017.
 */
public class ApplicationManager {
  FirefoxDriver wd;

  private SessionHelper sessionHelper;

  private NavigationHelper navigationHelper ;
  private  GroupHelper groupHelper;



  public void init() {
    WebDriver driver;
    System.setProperty("webdriver.gecko.driver", "D:\\geckodriver\\geckodriver.exe");
    driver = new FirefoxDriver();

    wd = new FirefoxDriver();
wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

     wd.get("http://localhost/addressbook/group.php");
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd );
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");

  }

  public void login(String username, String password) {
    wd.findElement(By.name("user")).click();
  wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys("a");
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
  wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
   wd.findElement(By.name("pass")).sendKeys(password);
  wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }

  public void stop() {
    wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
