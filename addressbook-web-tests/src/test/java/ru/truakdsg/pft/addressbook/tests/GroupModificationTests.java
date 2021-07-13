package ru.truakdsg.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.truakdsg.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGrop();
    app.getGroupHelper().groupEdit();
    app.getGroupHelper().fillGroupForm(new GroupData("Edit1", "Edit2", "Edit3"));
    app.getGroupHelper().updateGroup();
    app.getGroupHelper().returnGroupPage();
  }

}
