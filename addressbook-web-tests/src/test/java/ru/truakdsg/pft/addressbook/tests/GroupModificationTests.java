package ru.truakdsg.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.truakdsg.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test1", "test1", "test1"));
    }
    app.getGroupHelper().selectGrop();
    app.getGroupHelper().groupEdit();
    app.getGroupHelper().fillGroupForm(new GroupData("Edit1", "Edit2", "Edit3"));
    app.getGroupHelper().updateGroup();
    app.getGroupHelper().returnGroupPage();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before);
  }

}
