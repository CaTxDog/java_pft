package ru.truakdsg.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ru.truakdsg.pft.addressbook.model.ContactData;
import ru.truakdsg.pft.addressbook.model.GroupData;

import java.io.File;


public class ContactAddToGroup extends TestBase{

  @BeforeSuite
  public void ensurePreconditions() {
    app.db().addGroup();
    app.goTo().HomePage();
    if (app.db().contacts().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstname("Petr")
              .withLastname("Petrov")
              .withNickname("Terminator111")
              .withCompany("Raif")
              .withAddress("Omsk")
              .withHomePhone("111111111111")
              .withMobilePhone("111111111222")
              .withEmail("test@test2.com")
              .withEmail2("test1@test1.com")
              .withPhoto(new File("src\\test\\resources\\stru.png")));
    }
    if (app.db().groups().size() == 0) {
      app.goTo().GroupPage();
      app.group().create(new GroupData()
              .withName("New name " + app.group().generateRandomInt(50))
              .withHeader("New header " + app.group().generateRandomInt(50))
              .withFooter("New footer " + app.group().generateRandomInt(50)));
      app.goTo().HomePage();
    }
    ContactData contactFirst = app.db().contactsFirst();
    GroupData groupFirst = app.db().groupsFirst();
    if (contactFirst.getGroups().contains(groupFirst) == true){
      ContactData contact = new ContactData().withId(contactFirst.getId()).inGroup(groupFirst);
      app.contact().removeContactFromGroup(contact);
      app.goTo().HomePage();
    }
  }

  @AfterSuite
  public void ensureAftercondition(){
    app.db().deleteGroup();
  }

  @Test
  public void testContactAddToGroupNew(){
    ContactData contactFirst = app.db().contactsFirst();
    GroupData groupLast = app.db().groupsLast();
    ContactData contact = new ContactData().withId(contactFirst.getId()).inGroup(groupLast);
    app.contact().addContactToGroup(contact);
    ContactData after = app.db().getContactsById(contactFirst.getId());
    Assert.assertTrue(after.getGroups().contains(groupLast));
  }
}
