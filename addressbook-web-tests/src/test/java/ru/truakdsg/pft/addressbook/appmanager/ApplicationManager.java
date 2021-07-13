package ru.truakdsg.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  WebDriver wd;
  private NavigationHelper navigationHelper;
  private ContactHelper contactHelper;
  private GroupHelper groupHelper;
  private SessionHelper sessionHelper;

  public void init() {
    //Насйтрока параметров загрузки профиля FF
    ProfilesIni profile = new ProfilesIni();
    FirefoxProfile prof = profile.getProfile("fortest");
    prof.setPreference("browser.download.dir","C:\\Developer\\java_pft\\Contact");
    prof.setPreference("browser.download.folderList", 2);
    FirefoxOptions opt = new FirefoxOptions();
    opt.setProfile(prof);
    //При ошибки отутствия профиля - удалить параметр opt
    wd = new FirefoxDriver(opt);
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
