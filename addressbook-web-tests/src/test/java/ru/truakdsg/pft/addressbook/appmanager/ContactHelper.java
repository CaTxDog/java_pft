package ru.truakdsg.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.truakdsg.pft.addressbook.model.ContactData;
import ru.truakdsg.pft.addressbook.model.GroupData;

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

  public void selectContactFirst(){
    click(By.xpath("//table//tr[2]/td[1]/input"));
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

  public void viewContactFirstDetails(){
    click(By.xpath("/html/body/div/div[4]/form[2]/table/tbody/tr[2]/td[7]/a/img"));
  }

  public void modifyContact(){
    click(By.xpath("/html/body/div/div[4]/form[1]/input[2]"));
  }

  public void downloadContactCard(){
    click(By.xpath("/html/body/div/div[4]/form[2]/table/tbody/tr[2]/td[9]/a/img"));
  }

  public void editContactNumber(final int s){
    click(By.xpath("//table//tr[" + String.valueOf(s+1) + "]/td[8]"));
  }

  public void editContactFirst(){
    click(By.xpath("/html/body/div/div[4]/form[2]/table/tbody/tr[2]/td[8]/a/img"));
  }

  public void updateContact(){
    click(By.xpath("/html/body/div/div[4]/form[1]/input[1]"));
  }

  public void addNextContact() {
    click(By.linkText("add next"));
  }

  public void returnHomePage() {
    click(By.xpath("/html/body/div/div[3]/ul/li[1]/a"));
  }

  public void createContact(ContactData contact) {
    creatNewContact();
    fillContactForm(contact);
    returnHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("/html/body/div/div[4]/form[2]/table/tbody/tr[2]/td[1]"));
  }
}
