package ru.truakdsg.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.truakdsg.pft.addressbook.appmanager.HelperBase;
import ru.truakdsg.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", "test1", "test1"));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGrop(1);
    app.getGroupHelper().groupEdit();
    app.getGroupHelper().fillGroupForm(new GroupData(
            "Name Modify " + HelperBase.generateRandomInt(50),
            "Header Modify " + HelperBase.generateRandomInt(50),
            "Footer Modify " + HelperBase.generateRandomInt(50)));
    app.getGroupHelper().updateGroup();
    app.getGroupHelper().returnGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());
  }

}
