package ru.truakdsg.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.truakdsg.pft.addressbook.model.ContactData;
import ru.truakdsg.pft.addressbook.model.Contacts;

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
    attach(By.name("photo"),contactData.getPhoto());
    type(By.name("company"),contactData.getCompany());
    type(By.name("address"),contactData.getAddress());
    type(By.name("home"),contactData.getHomePhone());
    type(By.name("mobile"),contactData.getMobilePhone());
    type(By.name("work"),contactData.getWorkPhone());
    type(By.name("email"),contactData.getEmail());
    type(By.name("email2"),contactData.getEmail2());
    type(By.name("email3"),contactData.getEmail3());
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void selectContactByNumber(final int s){
    click(By.xpath("//table//tr[" + String.valueOf(s+1) + "]/td[1]/input"));
  }

  private void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
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

  public void editContact(){
    click(By.xpath("/html/body/div/div[4]/form[1]/input[2]"));
  }

  public void downloadContactCard(){
    click(By.xpath("/html/body/div/div[4]/form[2]/table/tbody/tr[2]/td[9]/a/img"));
  }

 /* public void editContactNumber(final int s){
    click(By.xpath("//table//tr[" + String.valueOf(s+1) + "]/td[8]"));
  }*/

  public void editContactSelectedById(int id){
    click(By.xpath("//input[@value=\""+id+"\"]/ancestor::tr/td[8]"));
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
    contactCache = null;
    returnHomePage();
  }

  public void modify(ContactData contact) {
    editContactSelectedById(contact.getId());
    fillContactForm(contact);
    update();
    contactCache = null;
    HomePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteContact();
    deleteContactAccept();
    contactCache = null;
    HomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("/html/body/div/div[4]/form[2]/table/tbody/tr[2]/td[1]"));
  }

  public int count(){
    return wd.findElements(By.xpath("//tr[@name='entry']")).size();
  }

  private Contacts contactCache = null;

  public Contacts all(){
    if (contactCache != null){
      return new Contacts(contactCache);
    }

    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.xpath("td/input")).getAttribute("value"));
      String lastname = element.findElement(By.xpath("td[2]")).getText();
      String name = element.findElement(By.xpath("td[3]")).getText();
      String address = element.findElement(By.xpath("td[4]")).getText();
      String allEmails = element.findElement(By.xpath("td[5]")).getText();
      String allPhones = element.findElement(By.xpath("td[6]")).getText();
      ContactData contact = new ContactData()
              .withId(id)
              .withFirstname(name)
              .withLastname(lastname)
              .withAddress(address)
              .withAllEmails(allEmails)
              .withAllPhones(allPhones.replaceAll("\\D",""));
      contactCache.add(contact);
    }
    return new Contacts(contactCache);
  }

  public ContactData infoFromEditForm(ContactData contact) {
    editContactSelectedById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactData()
            .withId(contact.getId())
            .withFirstname(firstname)
            .withLastname(lastname)
            .withAddress(address)
            .withHomePhone(home)
            .withMobilePhone(mobile)
            .withWorkPhone(work)
            .withEmail(email)
            .withEmail2(email2)
            .withEmail3(email3);
  }
}
