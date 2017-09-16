package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;


/**
 * Created by Антон on 09.09.2017.
 */
public class RegistrationHelper extends  HelperBase {


  public RegistrationHelper(ApplicationManager app) {
    super(app);
  }

  public void start(String username, String email) {
    wd.get(app.getProperty("Web.baseUrl") + "/login.php");
   type(By.name("username"),username);
   type(By.name("email"),email);
   click(By.cssSelector("input[value='Зарегистрироваться']"));


  }
}
