package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import ru.stqa.pft.mantis.model.UserData;
import ru.stqa.pft.mantis.model.Users;

import java.sql.*;

/**
 * Created by Антон on 30.09.2017.
 */
public class ChangePasswordHelper extends  HelperBase {

  public ChangePasswordHelper(ApplicationManager app){
    super(app);
  }


  public void loginAsAdmin() {
    wd.manage().window().maximize();
    wd.get(app.getProperty("Web.baseUrl") + "/login_page.php");
    type(By.name("username"), "administrator");
    type(By.name("password"), "root");
    click(By.xpath("//form[@id='login-form']/fieldset/input[2]"));
  }

  public void resetPassword(int Id) {
   /* click(By.xpath("//div[@id='sidebar']//span[.=' управление ']"));
    click(By.xpath("//div[@class='row']//a[.='Управление пользователями']"));
    click(By.xpath(String.format("//a[@href='manage_user_edit_page.php?user_id=%s']", Id)));
    click(By.xpath("//span//input[@value='Сбросить пароль']"));
    click(By.xpath("//div[@class='btn-group']//a[.='Продолжить']"));
    **/


    wd.get (app.getProperty("Web.baseUrl") + "/manage_user_edit_page.php?user_id= " +Id);

    //type ( By.cssSelector ( "input[value='Сбросить пароль']" ) );
    click (By.cssSelector("input[value='Сбросить пароль']"));
  }

  public void renewalPassword(String confirmationLink, String password) {
    wd.get(confirmationLink);
    type(By.id("password"),password);
    type(By.id("password-confirm"),password);
    click(By.xpath("//span[@class='submit-button']/button"));

  }

}
