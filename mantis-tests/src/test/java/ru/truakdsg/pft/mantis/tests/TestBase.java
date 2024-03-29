package ru.truakdsg.pft.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.truakdsg.pft.mantis.appmanager.ApplicationManager;

import java.io.File;

public class TestBase {

  public static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
    app.ftp().upload(new File("src/test/resources/config_inc.php"), "config_inc.php", "config_inc_php.back");
  }

  @AfterSuite (alwaysRun = true)
  public void tearDown() throws Exception {
    app.ftp().restore("config_inc_php.back","config_inc.php");
    app.stop();
  }

}
