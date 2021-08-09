package ru.truakdsg.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.truakdsg.pft.addressbook.appmanager.HelperBase;
import ru.truakdsg.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactEditTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().HomePage();
    if (app.contact().list().size() == 0){
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
    List<ContactData> before = app.contact().list();
    int index = before.size()-1;
    ContactData contact = new ContactData()
            .withId(before.get(index-1).getId())
            .withFirstname("FirstName "+ HelperBase.generateRandomInt(50))
            .withLastname("LastName "+HelperBase.generateRandomInt(50))
            .withNickname("Terminator-"+HelperBase.generateRandomInt(50))
            .withCompany("Raif")
            .withAddress("Omsk")
            .withHomePhone("+8"+HelperBase.generateRandomInt(Integer.MAX_VALUE))
            .withMobilePhone("+8"+HelperBase.generateRandomInt(Integer.MAX_VALUE))
            .withEmail("test@test2.com")
            .withEmail2("test1@test1.com");
    app.contact().edit(index, contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index-1);
    before.add(contact);
    Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
