package ru.truakdsg.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.truakdsg.pft.addressbook.model.ContactData;

import java.io.File;

public class ContactViewDetailsTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().HomePage();
    if (app.db().contacts().size() == 0){
      app.contact().create(new ContactData()
              .withFirstname("Petr")
              .withLastname("Petrov")
              .withNickname("Terminator111")
              .withCompany("Raif")
              .withAddress("Omsk")
              .withHomePhone("111111111111")
              .withMobilePhone("111111111222")
              .withEmail("test@test2.com")
              .withEmail2("test1@test1.com"));
    }
  }

  @Test
  public void viewContactDetails() throws Exception {
    app.contact().viewDetails();
 }

/*  @Test
  public void modifyContactDetails() throws Exception {
    app.contact().viewDetails();
    app.contact().editContact();
    app.contact().fillContactForm(new ContactData()
            .withFirstname("Modify")
            .withLastname("Modify")
            .withNickname("Modify")
            .withPhoto(new File("src\\test\\resources\\stru.png"))
            .withCompany("Modify")
            .withAddress("Modify")
            .withHomePhone("Modify")
            .withMobilePhone("Modify")
            .withEmail("Modify@Modify1.com")
            .withEmail2("Modify2@Modify2.com"));
  }*/

}
