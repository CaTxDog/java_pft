package ru.truakdsg.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.truakdsg.pft.addressbook.model.ContactData;
import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }
  public void creatNewContact() {
    click(By.linkText("add new"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"),contactData.getFirstname());
    type(By.name("lastname"),contactData.getLastname());
    type(By.name("nickname"),contactData.getNickname());
    type(By.name("company"),contactData.getCompany());
    type(By.name("address"),contactData.getAddress());
    type(By.name("home"),contactData.getHomePhone());
    type(By.name("mobile"),contactData.getMobilePhone());
    type(By.name("email"),contactData.getEmail());
    type(By.name("email2"),contactData.getEmail2());
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void selectContactNumber(final int s){
    click(By.xpath("//table//tr[" + String.valueOf(s+1) + "]/td[1]/input"));
  }

  public void selectContact(int index){
    wd.findElements(By.xpath("//table//tr[*]/td[1]/input")).get(index).click();
  }

  public void deleteContact(){
    click(By.xpath("/html/body/div/div[4]/form[2]/div[2]/input"));
  }

  public void deleteContactAccept(){
    wd.switchTo().alert().accept();
  }

  public void viewContactNumberDetails(final int s){
    click(By.xpath("//table//tr[" + String.valueOf(s+1) + "]/td[8]"));
  }

  public void viewDetails(){
    click(By.xpath("/html/body/div/div[4]/form[2]/table/tbody/tr[2]/td[7]/a/img"));
  }

  public void modify(){
    click(By.xpath("/html/body/div/div[4]/form[1]/input[2]"));
  }

  public void downloadContactCard(){
    click(By.xpath("/html/body/div/div[4]/form[2]/table/tbody/tr[2]/td[9]/a/img"));
  }

 /* public void editContactNumber(final int s){
    click(By.xpath("//table//tr[" + String.valueOf(s+1) + "]/td[8]"));
  }*/

  public void editContactSelect(final int s){
    click(By.xpath("//table//tr[" + String.valueOf(s+1) + "]/td[8]"));
  }

  public void update(){
    click(By.xpath("/html/body/div/div[4]/form[1]/input[1]"));
  }

  public void addNext() {
    click(By.linkText("add next"));
  }

  public void HomePage(){
    click(By.xpath("/html/body/div/div[3]/ul/li[1]/a"));
  }

  public void returnHomePage() {
    click(By.xpath("/html/body/div/div[3]/ul/li[1]/a"));
  }

  public void create(ContactData contact) {
    creatNewContact();
    fillContactForm(contact);
    returnHomePage();
  }

  public void edit(int index, ContactData contact) {
    editContactSelect(index);
    fillContactForm(contact);
    update();
    HomePage();
  }

  public void delete(int index) {
    selectContact(index);
    deleteContact();
    deleteContactAccept();
    HomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("/html/body/div/div[4]/form[2]/table/tbody/tr[2]/td[1]"));
  }

  public int getCountactCount(){
    return wd.findElements(By.xpath("//tr[@name='entry']")).size();
  }

  public List<ContactData> list(){
    List<ContactData> contacts = new ArrayList<>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.xpath("td/input")).getAttribute("value"));
      String lastname = element.findElement(By.xpath("td[2]")).getText();
      String name = element.findElement(By.xpath("td[3]")).getText();
      String address = element.findElement(By.xpath("td[4]")).getText();
      ContactData contact = new ContactData()
              .withId(id)
              .withFirstname(name)
              .withLastname(lastname)
              .withAddress(address);
      contacts.add(contact);
    }
    return contacts;
  }
}
