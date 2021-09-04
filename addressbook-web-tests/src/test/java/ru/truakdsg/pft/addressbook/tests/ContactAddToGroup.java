package ru.truakdsg.pft.addressbook.tests;

import io.netty.util.internal.ConstantTimeUtils;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.truakdsg.pft.addressbook.model.ContactData;
import ru.truakdsg.pft.addressbook.model.Contacts;
import ru.truakdsg.pft.addressbook.model.GroupData;
import ru.truakdsg.pft.addressbook.model.Groups;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;

public class ContactAddToGroup extends TestBase{

  @BeforeSuite
  public void ensurePreconditions() {
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
  }

  @DataProvider
  public Iterator<Object[]> test() throws IOException {
    Groups groups = app.db().groups();
    Contacts contactBD = app.db().contacts();
    ContactData contact = contactBD.iterator().next();
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[]{new ContactData().withId(contact.getId()).inGroup(groups.iterator().next())});
    return list.iterator();
  }

  @Test (dataProvider = "test")
  public void testContactAddToGroup(ContactData contact){
    Contacts before = app.db().contacts();
    app.contact().addContactToGroup(contact);
    Contacts after = app.db().contacts();
    System.out.println(contact.getGroups());
    System.out.println();
    MatcherAssert.assertThat(after.iterator().next().getGroups(), equalTo(contact.getGroups()));

  }
}
