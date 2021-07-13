package ru.truakdsg.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.truakdsg.pft.addressbook.model.ContactData;

public class ContactEditTest extends TestBase{

  //Редактирование контакта по порядковому номеру
  @Test
  public void testContactCreationNumber() throws Exception {
    app.getContactHelper().editContactNumber(2);
    app.getContactHelper().fillContactForm(new ContactData("Petr", "Petrov", "Petrovich", "Raif", "Omsk", "2222222222", "78889995566", "test2@test1.com", "test1@test1.com"));
    app.getContactHelper().updateContact();
  }
  //Редактирование первого контакта в списке
  @Test
  public void testContactCreationFirst() throws Exception {
    app.getContactHelper().editContactFirst();
    app.getContactHelper().fillContactForm(new ContactData("Ivan", "Ivanov", "Terminator228", "Raif", "Omsk", "333333333333", "78889995566", "test@test1.com", "test1@test1.com"));
    app.getContactHelper().updateContact();
  }
}
