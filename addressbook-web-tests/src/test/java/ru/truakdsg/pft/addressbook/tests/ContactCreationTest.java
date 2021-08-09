package ru.truakdsg.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.truakdsg.pft.addressbook.appmanager.HelperBase;
import ru.truakdsg.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().HomePage();
  }

  @Test
  public void testContactCreation() throws Exception {
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData()
            .withFirstname("Sergey "+HelperBase.generateRandomInt(50))
            .withLastname("Test "+HelperBase.generateRandomInt(50))
            .withNickname("NewBie "+HelperBase.generateRandomInt(50))
            .withCompany("Raif")
            .withAddress("Omsk")
            .withHomePhone("+7"+HelperBase.generateRandomInt(Integer.MAX_VALUE))
            .withMobilePhone("+7"+HelperBase.generateRandomInt(Integer.MAX_VALUE))
            .withEmail("test@test1.com")
            .withEmail2("test1@test1.com");
    app.contact().create(contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
