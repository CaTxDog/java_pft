package ru.truakdsg.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class RegistrationHelper extends HelperBase{

  public RegistrationHelper(ApplicationManager app) {
    super(app);
  }
  public void start(String username, String email){
    wd.get(app.getProperty("web.baseUrl")+"signup_page.php");
    type(By.xpath("//*[@id=\"username\"]"), username);
    type(By.xpath("//*[@id=\"email-field\"]"), email);
    click(By.xpath("/html/body/div/div/div/div/div/div[4]/div/div/div[1]/form/fieldset/input[2]"));
  }

  public void finish(String confirmationLink, String password) {
    wd.get(confirmationLink);
    type(By.xpath("//*[@id=\"password\"]"), password);
    type(By.xpath("//*[@id=\"password-confirm\"]"), password);
    click(By.xpath("/html/body/div/div/div/div/div/div[5]/div/div/div/div/form/fieldset/span/button"));
  }
}
