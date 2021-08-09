package ru.truakdsg.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.truakdsg.pft.addressbook.appmanager.HelperBase;
import ru.truakdsg.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactCreationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().HomePage();
  }

  @Test
  public void testContactCreation() throws Exception {
    Set<ContactData> before = app.contact().all();
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
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
