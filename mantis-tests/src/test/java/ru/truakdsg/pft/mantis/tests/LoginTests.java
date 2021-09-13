package ru.truakdsg.pft.mantis.tests;

import org.apache.hc.core5.http.ParseException;
import org.testng.annotations.Test;
import ru.truakdsg.pft.mantis.appmanager.HttpSession;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class LoginTests extends TestBase{

  @Test
  public void testLogin() throws IOException, ParseException {
    HttpSession session = app.newSession();
    session.login("administrator", "secret");
    assertTrue(session.login("administrator", "secret"));
    assertTrue(session.isLoggedInAs("administrator"));
  }

}
