package ru.truakdsg.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.truakdsg.pft.addressbook.model.ContactData;

public class ContactDeleteTest extends TestBase{

  //Удаление контакта по порядковому номеру
  @Test
  public void deleteContactNumber() throws Exception {
    app.getContactHelper().selectContactNumber(3);
    app.getContactHelper().deleteContact();
    app.getContactHelper().deleteContactAccept();
  }

  //Удаление первого контакта в списке
  @Test
  public void deleteContactFirst() throws Exception {
    app.getContactHelper().selectContactFirst();
    app.getContactHelper().deleteContact();
    app.getContactHelper().deleteContactAccept();
  }

}
