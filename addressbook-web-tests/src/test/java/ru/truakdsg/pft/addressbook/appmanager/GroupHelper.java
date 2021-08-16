package ru.truakdsg.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.truakdsg.pft.addressbook.model.GroupData;
import ru.truakdsg.pft.addressbook.model.Groups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void fillForm(GroupData groupData) {
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

  public void deleteSelected() {
    click(By.name("delete"));
  }

  public void edit() {
    click(By.xpath("/html/body/div/div[4]/form/input[6]"));
  }

  public void update() {
    click(By.xpath("/html/body/div/div[4]/form/input[3]"));
  }

  public void create(GroupData group) {
    initGroupCreation();
    fillForm(group);
    submitGroupCreation();
    returnGroupPage();
  }

  public void modify(GroupData group) {
    selectGroupById(group.getId());
    edit();
    fillForm(group);
    update();
    returnGroupPage();
  }

  public void delete(GroupData group) {
    selectGroupById(group.getId());
    deleteSelected();
    returnGroupPage();
  }

  private void selectGroupById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

/*  public boolean isThereAGroup() {
   return isElementPresent(By.xpath("/html/body/div/div[4]/form/span/input"));
  }

  public int getGroupCount() {
    return wd.findElements(By.xpath("//span")).size();
  }*/

  public Groups all() {
    Groups groups = new Groups();
    List<WebElement> elements = wd.findElements(By.xpath("//span[*]"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.xpath("input")).getAttribute("value"));
      groups.add(new GroupData().withId(id).withName(name));
    }
    return groups;
  }

}
