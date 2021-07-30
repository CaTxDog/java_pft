package ru.truakdsg.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.truakdsg.pft.addressbook.appmanager.HelperBase;
import ru.truakdsg.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData(null, "test1", "test1", "test1"));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGrop(before.size()-1);
    app.getGroupHelper().groupEdit();
    GroupData group = new GroupData(
            before.get(before.size()-1).getId(),
            "Name Modify " + HelperBase.generateRandomInt(50),
            "Header Modify " + HelperBase.generateRandomInt(50),
            "Footer Modify " + HelperBase.generateRandomInt(50));
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().updateGroup();
    app.getGroupHelper().returnGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size()-1);
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}
