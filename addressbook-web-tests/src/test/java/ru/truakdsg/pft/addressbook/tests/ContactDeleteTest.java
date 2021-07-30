package ru.truakdsg.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.truakdsg.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeleteTest extends TestBase{

  @Test
  public void deleteContactFirst() throws Exception {
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Petr", "Petrov", "Terminator111", "Raif", "Omsk", "111111111111", "111111111222", "test@test2.com", "test1@test1.com"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size()-1);
    app.getContactHelper().deleteContact();
    app.getContactHelper().deleteContactAccept();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size()-1);

    before.remove(before.size()-1);
    Assert.assertEquals(before, after);
  }

}
