package ru.stqa.pft.mantis.appmanager;

import org.apache.http.impl.client.CloseableHttpClient;
import org.openqa.selenium.By;
import ru.stqa.pft.mantis.model.Users;
public class ChangePasswordHelper extends  HelperBase {

    private CloseableHttpClient httpclient;

    public ChangePasswordHelper(ApplicationManager app) {
        super(app);
    }

    public void login() {
        wd.get(app.getProperty("Web.baseUrl") + "/login.php");
        type(By.name("username"), app.getProperty("Web.AdminLogin"));
        type(By.name("password"), app.getProperty("Web.AdminPassword"));
        click(By.cssSelector("input[value='Войти'"));
    }


    public void resetPassword(Users user) {
        wd.get(app.getProperty("Web.baseUrl") + "/manage_user_edit_page.php?user_id= " + user.iterator().next().getId());
        click(By.cssSelector("input[value='Сбросить пароль']"));
    }


    public void finish(String confirmationLink, String password) {
        wd.get(confirmationLink);
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        click (By.cssSelector("button[type='submit']"));
    }


}