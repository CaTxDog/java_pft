package ru.truakdsg.pft.addressbook.tests;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.truakdsg.pft.addressbook.model.ContactData;
import ru.truakdsg.pft.addressbook.model.Contacts;
import ru.truakdsg.pft.addressbook.model.Groups;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import static org.hamcrest.CoreMatchers.not;

public class ContactRemoveFromGroup extends TestBase{


  @DataProvider
  public Iterator<Object[]> test() throws IOException {
    Groups groups = app.db().groups();
    Contacts contactBD = app.db().contacts();
    ContactData contact = contactBD.iterator().next();
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[]{new ContactData().withId(contact.getId()).inGroup(groups.iterator().next())});
    return list.iterator();
  }

  @Test(dataProvider = "test")
  public void testContactAddToGroup(ContactData contact){
    app.contact().removeContactFromGroup(contact);
    Contacts after = app.db().contacts();
    System.out.println(after.iterator().next().getGroups());
    System.out.println(contact.getGroups());
    MatcherAssert.assertThat(after.iterator().next().getGroups(), not(contact.getGroups()));
  }
}
