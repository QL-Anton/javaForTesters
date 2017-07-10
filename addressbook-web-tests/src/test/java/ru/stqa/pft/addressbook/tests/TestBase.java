package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;


import static org.openqa.selenium.remote.BrowserType.FIREFOX;
import static sun.plugin2.util.BrowserType.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

/**
 * Created by Антон on 02.07.2017.
 */
public class TestBase  {

  protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

  @BeforeMethod
  public void setUp() throws Exception {



    app.init();

  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }

  public ApplicationManager getApp() {
    return app;
  }
}
