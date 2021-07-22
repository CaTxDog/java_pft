package ru.truakdsg.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.truakdsg.pft.addressbook.model.ContactData;
import ru.truakdsg.pft.addressbook.model.GroupData;

public class ContactEditTest extends TestBase{

  @Test
  public void testContactCreationFirst() throws Exception {
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Petr", "Petrov", "Terminator111", "Raif", "Omsk", "111111111111", "111111111222", "test@test2.com", "test1@test1.com"));
    }
    app.getContactHelper().editContactFirst();
    app.getContactHelper().fillContactForm(new ContactData("Ivan", "Ivanov", "Terminator228", "Raif", "Omsk", "333333333333", "78889995566", "test@test1.com", "test1@test1.com"));
    app.getContactHelper().updateContact();
  }
}
