package ru.stqa.pft.mantis.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.mantis.appmanager.HttpSession;

import javax.xml.rpc.ServiceException;
import java.io.IOException;
import static org.testng.Assert.assertTrue;

/**
 * Created by Антон on 31.08.2017.
 */
public class LoginTest extends  TestBase {

  @Test
   public void testLogin() throws IOException, ServiceException {
    skipIfNotFixed(1);
      HttpSession session = app.newSession();
        assertTrue(session.login("administrator", "root"));
    assertTrue ( session.isLoggedInAs ( "administrator" ) );
      }
}
