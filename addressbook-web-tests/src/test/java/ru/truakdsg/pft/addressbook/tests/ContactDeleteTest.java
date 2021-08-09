package ru.truakdsg.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.truakdsg.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactDeleteTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().HomePage();
    if (app.contact().all().size() == 0){
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
    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size()-1);

    before.remove(deletedContact);
    Assert.assertEquals(before, after);
  }

}
