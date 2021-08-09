package ru.truakdsg.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.truakdsg.pft.addressbook.appmanager.HelperBase;
import ru.truakdsg.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactEditTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().HomePage();
    if (app.contact().all().size() == 0){
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
    Set<ContactData> before = app.contact().all();
    ContactData modifyContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifyContact.getId())
            .withFirstname("FirstName "+ HelperBase.generateRandomInt(50))
            .withLastname("LastName "+HelperBase.generateRandomInt(50))
            .withNickname("Terminator-"+HelperBase.generateRandomInt(50))
            .withCompany("Raif")
            .withAddress("Omsk")
            .withHomePhone("+8"+HelperBase.generateRandomInt(Integer.MAX_VALUE))
            .withMobilePhone("+8"+HelperBase.generateRandomInt(Integer.MAX_VALUE))
            .withEmail("test@test2.com")
            .withEmail2("test1@test1.com");
    app.contact().modify(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifyContact);
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
