package ru.truakdsg.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.truakdsg.pft.addressbook.model.ContactData;

public class ContactViewDetailsTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().HomePage();
    if (app.contact().list().size() == 0){
      app.contact().create(new ContactData("Petr", "Petrov", "Terminator111", "Raif", "Omsk", "111111111111", "111111111222", "test@test2.com", "test1@test1.com"));
    }
  }

  @Test
  public void viewContactDetails() throws Exception {
    app.contact().viewDetails();
 }

  @Test
  public void modifyContactDetails() throws Exception {
    app.contact().viewDetails();
    app.contact().modify();
    app.contact().fillContactForm(new ContactData("Sergey_v1", "Ivanov_v1", "Terminator228_v1", "Raif_v1", "Omsk", "112233", "111222333", "test_v1@test1.com", "test1@test1.com"));
  }

}
