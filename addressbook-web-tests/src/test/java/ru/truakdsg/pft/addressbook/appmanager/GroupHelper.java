package ru.truakdsg.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.truakdsg.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

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

  public void select(Integer index) {
      click(By.xpath("/html/body/div/div[4]/form/span["+(index+1)+"]/input"));
  }

  public void deleteSelected() {
    click(By.name("delete"));
  }

  public void edit(){
    click(By.xpath("/html/body/div/div[4]/form/input[6]"));
  }

  public void update(){
    click(By.xpath("/html/body/div/div[4]/form/input[3]"));
  }

  public void create(GroupData group) {
    initGroupCreation();
    fillForm(group);
    submitGroupCreation();
    returnGroupPage();
  }

  public void modify(int index, GroupData group) {
    select(index);
    edit();
    fillForm(group);
    update();
    returnGroupPage();
  }

  public void delete(int index) {
    select(index);
    deleteSelected();
    returnGroupPage();
  }

/*  public boolean isThereAGroup() {
   return isElementPresent(By.xpath("/html/body/div/div[4]/form/span/input"));
  }

  public int getGroupCount() {
    return wd.findElements(By.xpath("//span")).size();
  }*/

  public List<GroupData> list() {
    List<GroupData> groups = new ArrayList<GroupData>();
    List<WebElement> elements = wd.findElements(By.xpath("//span[*]"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.xpath("input")).getAttribute("value"));
      GroupData group = new GroupData(id, name, null, null);
      groups.add(group);
    }
    return groups;
  }

}
