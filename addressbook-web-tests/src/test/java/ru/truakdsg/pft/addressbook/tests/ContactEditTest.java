package ru.truakdsg.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.truakdsg.pft.addressbook.appmanager.HelperBase;
import ru.truakdsg.pft.addressbook.model.ContactData;
import ru.truakdsg.pft.addressbook.model.GroupData;

public class ContactEditTest extends TestBase{

  @Test
  public void testContactCreationFirst() throws Exception {
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Petr", "Petrov", "Terminator111", "Raif", "Omsk", "111111111111", "111111111222", "test@test2.com", "test1@test1.com"));
    }
    app.getContactHelper().editContactFirst();
    app.getContactHelper().fillContactForm(new ContactData("FirstName "+ HelperBase.generateRandomInt(50), "LastName "+HelperBase.generateRandomInt(50), "Terminator-"+HelperBase.generateRandomInt(50), "Raif", "Omsk", "+8"+HelperBase.generateRandomInt(Integer.MAX_VALUE), "+8"+HelperBase.generateRandomInt(Integer.MAX_VALUE), "test@test1.com", "test1@test1.com"));
    app.getContactHelper().updateContact();
  }
}
