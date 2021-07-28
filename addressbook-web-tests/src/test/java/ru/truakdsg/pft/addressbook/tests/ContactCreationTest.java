package ru.truakdsg.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.truakdsg.pft.addressbook.appmanager.HelperBase;
import ru.truakdsg.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    int before = app.getContactHelper().getCountactCount();
    app.getContactHelper().createContact(new ContactData("Sergey "+HelperBase.generateRandomInt(50), "Test "+HelperBase.generateRandomInt(50), "NewBie "+HelperBase.generateRandomInt(50), "Raif", "Omsk", "+7"+HelperBase.generateRandomInt(Integer.MAX_VALUE), "+7"+HelperBase.generateRandomInt(Integer.MAX_VALUE), "test@test1.com", "test1@test1.com"));
    int after = app.getContactHelper().getCountactCount();
    Assert.assertEquals(after, before+1);
  }
}
