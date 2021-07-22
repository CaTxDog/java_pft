package ru.truakdsg.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.truakdsg.pft.addressbook.model.ContactData;

public class ContactDeleteTest extends TestBase{

  @Test
  public void deleteContactFirst() throws Exception {
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Petr", "Petrov", "Terminator111", "Raif", "Omsk", "111111111111", "111111111222", "test@test2.com", "test1@test1.com"));
    }
    app.getContactHelper().selectContactFirst();
    app.getContactHelper().deleteContact();
    app.getContactHelper().deleteContactAccept();
  }

}
