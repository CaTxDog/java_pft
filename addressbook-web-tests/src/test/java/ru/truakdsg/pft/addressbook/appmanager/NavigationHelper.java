package ru.truakdsg.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.xpath("/html/body/div/div[4]/form/input[1]"))) {
      return;
    }
    click(By.linkText("groups"));
  }

  public void returnHomePage() {
    if (isElementPresent(By.xpath("//*[@id=\"maintable\"]"))) {
      return;
    }
    click(By.linkText("home page"));
  }
}
