package ru.truakdsg.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.truakdsg.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactDeleteTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().HomePage();
    if (app.contact().list().size() == 0){
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
    List<ContactData> before = app.contact().list();
    int index = before.size()-1;
    app.contact().delete(index);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size()-1);

    before.remove(index);
    Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
