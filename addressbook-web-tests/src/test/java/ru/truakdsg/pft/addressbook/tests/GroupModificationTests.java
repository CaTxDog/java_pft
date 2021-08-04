package ru.truakdsg.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.truakdsg.pft.addressbook.appmanager.HelperBase;
import ru.truakdsg.pft.addressbook.model.GroupData;

import java.util.*;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", "test1", "test1"));
    }
  }

  @Test
  public void testGroupCreation() throws Exception {
    List<GroupData> before = app.getGroupHelper().getGroupList();
    int index = before.size()-1;
    GroupData group = new GroupData(
            before.get(index).getId(),
            "Name Modify " + HelperBase.generateRandomInt(50),
            "Header Modify " + HelperBase.generateRandomInt(50),
            "Footer Modify " + HelperBase.generateRandomInt(50));
    app.getGroupHelper().modifyGroup(index, group);
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(group);
    Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
