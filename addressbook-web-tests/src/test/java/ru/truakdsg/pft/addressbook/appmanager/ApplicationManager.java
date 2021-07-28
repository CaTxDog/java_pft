package ru.truakdsg.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  WebDriver wd;
  WebDriverWait wait;
  private NavigationHelper navigationHelper;
  private ContactHelper contactHelper;
  private GroupHelper groupHelper;
  private SessionHelper sessionHelper;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init() {
    //Насйтрока параметров загрузки профиля FF
    //При ошибки отутствия профиля - удалить параметр opt
    if (browser.equals(BrowserType.FIREFOX)) {
      ProfilesIni profile = new ProfilesIni();
      FirefoxProfile prof = profile.getProfile("fortest");
      prof.setPreference("browser.download.dir","C:\\Developer\\java_pft\\Contact");
      prof.setPreference("browser.download.folderList", 2);
      FirefoxOptions opt = new FirefoxOptions();
      opt.setProfile(prof);
      wd = new FirefoxDriver(opt);
    } else if (browser.equals(BrowserType.CHROME)) {
      wd = new ChromeDriver();
    } else if (browser.equals(BrowserType.IE)){
      wd = new InternetExplorerDriver();
    } else if (browser.equals(BrowserType.OPERA)){
      wd = new OperaDriver();
    } else if (browser.equals(BrowserType.EDGE)){
      wd = new EdgeDriver();
    };
    wd.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    groupHelper = new GroupHelper(wd);
    contactHelper = new ContactHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
  }

  public void stop() {
    sessionHelper.logout();
    wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
