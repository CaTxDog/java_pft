package ru.truakdsg.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.truakdsg.pft.addressbook.model.ContactData;

public class ContactSaveTest extends TestBase {

  //При инициализации грузится локально созданный профиль, устанавливается путь для сохранения файлов
  @Test
  public void downloadContactFirst() throws Exception {
      app.getContactHelper().downloadContactCard();
  }

}
