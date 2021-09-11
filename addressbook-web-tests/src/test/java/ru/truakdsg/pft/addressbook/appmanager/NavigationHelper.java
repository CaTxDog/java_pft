package ru.truakdsg.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void GroupPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.xpath("/html/body/div/div[4]/form/input[1]"))) {
      return;
    }
    click(By.linkText("groups"));
  }
  public void HomePage(){
    click(By.xpath("/html/body/div/div[3]/ul/li[1]/a"));
    new Select(wd.findElement(By.xpath("/html/body/div/div[4]/form[1]/select"))).selectByVisibleText("[all]");
  }
  public void returnHomePage() {
    if (isElementPresent(By.xpath("//*[@id=\"maintable\"]"))) {
      return;
    }
    click(By.linkText("home page"));
  }
}
