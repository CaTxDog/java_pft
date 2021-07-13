package ru.truakdsg.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.truakdsg.pft.addressbook.model.ContactData;

public class ContactViewDetailsTest extends TestBase{

  @Test
  public void viewContactDetails() throws Exception {
    app.getContactHelper().viewContactFirstDetails();
 }

  @Test
  public void modifyContactDetails() throws Exception {
    app.getContactHelper().viewContactFirstDetails();
    app.getContactHelper().modifyContact();
    app.getContactHelper().fillContactForm(new ContactData("Sergey_v1", "Ivanov_v1", "Terminator228_v1", "Raif_v1", "Omsk", "112233", "111222333", "test_v1@test1.com", "test1@test1.com"));
  }

}
