package ru.truakdsg.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import ru.truakdsg.pft.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void returnGroupPage() {
    click(By.linkText("group page"));
  }

  public void selectGrop() {
      click(By.xpath("/html/body/div/div[4]/form/span/input"));
  }

  public void deleteSelectedGrops() {
    click(By.name("delete"));
  }

  public void groupEdit(){
    click(By.xpath("/html/body/div/div[4]/form/input[6]"));
  }

  public void updateGroup(){
    click(By.xpath("/html/body/div/div[4]/form/input[3]"));
  }

  public void createGroup(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnGroupPage();
  }

  public boolean isThereAGroup() {
   return isElementPresent(By.xpath("/html/body/div/div[4]/form/span/input"));
  }
}
