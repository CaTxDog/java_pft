package ru.truakdsg.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.truakdsg.pft.addressbook.model.ContactData;

public class ContactSaveTest extends TestBase {

  //При инициализации грузится локально созданный профиль, устанавливается путь для сохранения файлов
  @Test (enabled = false)
  public void downloadContactFirst() throws Exception {
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
      app.contact().downloadContactCard();
  }

}
