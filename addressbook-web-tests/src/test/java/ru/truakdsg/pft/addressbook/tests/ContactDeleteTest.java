package ru.truakdsg.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.truakdsg.pft.addressbook.model.ContactData;
import ru.truakdsg.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeleteTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().HomePage();
    if (app.db().contacts().size() == 0){
      app.contact().create(new ContactData()
                      .withFirstname("Petr")
                      .withLastname("Petrov")
                      .withNickname("Terminator111")
                      .withCompany("Raif")
                      .withAddress("Omsk")
                      .withHomePhone("111111111111")
                      .withMobilePhone("111111111222")
                      .withEmail("test@test2.com")
                      .withEmail2("test1@test1.com"));
    }
  }

  @Test
  public void deleteContactFirst() throws Exception {
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    assertThat(app.contact().count(), equalTo(before.size()-1));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.withOut(deletedContact)));
  }

}
