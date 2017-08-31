package ru.stqa.pft.addressbook.appmanager;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by Антон on 02.07.2017.
 */
public class TestBase  {

  protected static ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

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

  public  void verifyGroupListInUI() {
    if (Boolean.getBoolean("verifyUI")){
      Groups dbGroups=app.db().groups();
      Groups uiGroups=app.group().all();
      assertThat(uiGroups, equalTo(dbGroups.stream().
              map((g)->new GroupData().withId(g.getId()).withName(g.getName())).
              collect(Collectors.toSet())));
    }

  }

}

