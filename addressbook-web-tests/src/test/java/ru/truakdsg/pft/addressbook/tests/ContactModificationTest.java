package ru.truakdsg.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.truakdsg.pft.addressbook.appmanager.HelperBase;
import ru.truakdsg.pft.addressbook.model.ContactData;
import ru.truakdsg.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTest extends TestBase{

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
  public void testContactCreationFirst() throws Exception {
    Contacts before = app.db().contacts();
    ContactData modifyContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifyContact.getId())
            .withFirstname("FirstName "+ HelperBase.generateRandomInt(50))
            .withLastname("LastName "+HelperBase.generateRandomInt(50))
            .withNickname("Terminator-"+HelperBase.generateRandomInt(50))
            .withPhoto(new File("src\\test\\resources\\stru.png"))
            .withCompany("Raif")
            .withAddress("Omsk")
            .withHomePhone("+8"+HelperBase.generateRandomInt(Integer.MAX_VALUE))
            .withMobilePhone("+8"+HelperBase.generateRandomInt(Integer.MAX_VALUE))
            .withWorkPhone("+8"+HelperBase.generateRandomInt(Integer.MAX_VALUE))
            .withEmail("test@test2.com")
            .withEmail2("test1@test1.com")
            .withEmail3("test1@test3.com");
    app.contact().modify(contact);
   // assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.withOut(modifyContact).withAdded(contact)));
  }
}
