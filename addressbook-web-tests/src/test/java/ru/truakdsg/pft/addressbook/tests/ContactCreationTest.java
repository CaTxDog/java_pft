package ru.truakdsg.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.truakdsg.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().createContact(new ContactData("Sergey", "Ivanov", "Terminator228", "Raif", "Omsk", "79998887766", "78889995566", "test@test1.com", "test1@test1.com"));
  }

}
