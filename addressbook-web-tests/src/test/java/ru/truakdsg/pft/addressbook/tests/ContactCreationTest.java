package ru.truakdsg.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.truakdsg.pft.addressbook.appmanager.HelperBase;
import ru.truakdsg.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().createContact(new ContactData("Sergey "+HelperBase.generateRandomInt(50), "Test "+HelperBase.generateRandomInt(50), "NewBie "+HelperBase.generateRandomInt(50), "Raif", "Omsk", "+7"+HelperBase.generateRandomInt(Integer.MAX_VALUE), "+7"+HelperBase.generateRandomInt(Integer.MAX_VALUE), "test@test1.com", "test1@test1.com"));
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }
}
