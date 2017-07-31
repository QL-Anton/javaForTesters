package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

/**
 * Created by Антон on 07.07.2017.
 */
public class ApplicationManager {

 WebDriver wd;

  private ContactHelper contactHelper;
  private SessionHelper sessionHelper;

  private NavigationHelper navigationHelper ;
  private  GroupHelper groupHelper;
  private String browser;

  public ApplicationManager(String browser) {

    this.browser = browser;
  }




  public void init() {

    WebDriver driver;
    System.setProperty("webdriver.gecko.driver", "D:\\geckodriver\\geckodriver.exe");




    if (browser.equals(BrowserType.FIREFOX)){
      wd = new FirefoxDriver();
    } else if (browser.equals(BrowserType.CHROME)){
wd=new ChromeDriver();
    } else if (browser.equals(BrowserType.IE)){
      wd=new InternetExplorerDriver();
    }

wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

     wd.get("http://localhost/addressbook/group.php");
    groupHelper = new GroupHelper(wd);
    contactHelper = new ContactHelper(wd);
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

  public ContactHelper getContactHelper() {
    return contactHelper;
  }
}
