package ru.stqa.pft.mantis.tests;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;

import java.io.IOException;
import java.util.List;

/**
 * Created by Антон on 25.09.2017.
 */
public class ChangePasswordTests extends  TestBase {

  @BeforeMethod
  public void startMailServer(){
    app.mail().start();
  }


  @Test
  public  void testChangePassword() throws IOException, MessagingException {
   app.change().searchUser();

    long current_time = System.currentTimeMillis();
    String password="password";
    String user=String.format("user%s", current_time);
    String email = String.format("user%s@localhost.localdomain", current_time);
    app.registration().start(user, email);
    List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
    String confirmationLink = findConfirmationLink ( mailMessages, email );

    app.registration ().finish (confirmationLink, password );
    Assert.assertTrue (app.newSession ().login (  user, password));

  }

  private void searchUser() {

  }

  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream ().filter ( (m) -> m.to.equals ( email ) ).findFirst ().get ();
    VerbalExpression regex = VerbalExpression.regex ().find ( "http://" ).nonSpace ().oneOrMore ().build ();
    regex.getText ( mailMessage.text );
    return regex.getText ( mailMessage.text );
  }

}
