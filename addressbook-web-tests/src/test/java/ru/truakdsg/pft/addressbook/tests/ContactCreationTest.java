package ru.truakdsg.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.truakdsg.pft.addressbook.appmanager.HelperBase;

import ru.truakdsg.pft.addressbook.model.ContactData;
import ru.truakdsg.pft.addressbook.model.Contacts;

import java.util.Comparator;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().HomePage();
  }

  @Test
  public void testContactCreation() throws Exception {
    Contacts before = app.contact().all();
    ContactData contact = new ContactData()
            .withFirstname("Sergey "+HelperBase.generateRandomInt(50))
            .withLastname("Test "+HelperBase.generateRandomInt(50))
            .withNickname("NewBie "+HelperBase.generateRandomInt(50))
            .withCompany("Raif")
            .withAddress("Omsk")
            .withHomePhone("+7"+HelperBase.generateRandomInt(Integer.MAX_VALUE))
            .withMobilePhone("+7"+HelperBase.generateRandomInt(Integer.MAX_VALUE))
            .withEmail("test@test1.com")
            .withEmail2("test1@test1.com");
    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size()+1));

    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(contact);
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
}
