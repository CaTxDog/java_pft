package ru.truakdsg.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.truakdsg.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().createGroup(new GroupData(
            null,
            "name " + app.getGroupHelper().generateRandomInt(50),
            "header " + app.getGroupHelper().generateRandomInt(50),
            "footer " + app.getGroupHelper().generateRandomInt(50)));
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }
}
