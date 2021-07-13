package ru.truakdsg.pft.addressbook;

import org.testng.annotations.*;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    gotoContactPage();
    fillContactForm(new ContactData("Sergey", "Ivanov", "Terminator228", "Raif", "Omsk", "79998887766", "78889995566", "test@test1.com", "test1@test1.com"));
    returnHomePage();
  }

}
