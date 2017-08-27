package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Created by Антон on 02.07.2017.
 */
public class TestBase  {

  protected static ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();

  }

  @AfterSuite
  public void tearDown() {
    app.stop();
  }

  public ApplicationManager getApp() {
    return app;
  }
}
