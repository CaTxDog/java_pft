package ru.truakdsg.pft.mantis.tests;

import org.apache.hc.core5.http.ParseException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.truakdsg.pft.mantis.model.MailMessage;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static ru.truakdsg.pft.mantis.appmanager.HelperBase.generateRandomInt;

public class RegistrationTest extends TestBase{

  @BeforeSuite
  public void startMailServer(){
    app.mail().start();
  }

  @AfterSuite (alwaysRun = true)
  public void stopMailServer(){
    app.mail().stop();
  }

  @Test
  public void testRegistration() throws IOException, ParseException {
    String email = String.format("user%s@localhost.lacaldomain", System.currentTimeMillis());
    String user = String.format("user%s",generateRandomInt(100));;
    String password = String.format("password",generateRandomInt(100));;
    app.registration().start(user, email);
    List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
    String confirmationLink = findeConfirmationLink(mailMessages, email);
    app.registration().finish(confirmationLink, password);
    assertTrue(app.newSession().login(user, password));
  }

  private String findeConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }
}
