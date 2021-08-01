package ru.truakdsg.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.truakdsg.pft.addressbook.appmanager.HelperBase;
import ru.truakdsg.pft.addressbook.model.ContactData;
import ru.truakdsg.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactEditTest extends TestBase{

  @Test
  public void testContactCreationFirst() throws Exception {
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Petr", "Petrov", "Terminator111", "Raif", "Omsk", "111111111111", "111111111222", "test@test2.com", "test1@test1.com"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().editContactSelect(before.size()-1);
    ContactData contact = new ContactData(
            before.get(before.size()-2).getId(),
            "FirstName "+ HelperBase.generateRandomInt(50),
            "LastName "+HelperBase.generateRandomInt(50),
            "Terminator-"+HelperBase.generateRandomInt(50),
            "Raif",
            "Omsk",
            "+8"+HelperBase.generateRandomInt(Integer.MAX_VALUE),
            "+8"+HelperBase.generateRandomInt(Integer.MAX_VALUE),
            "test@test1.com",
            "test1@test1.com");
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().updateContact();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size()-2);
    before.add(contact);
    Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
