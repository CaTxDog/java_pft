package ru.truakdsg.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.truakdsg.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test1", "test1", "test1"));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGrop(before.size()-1);
    app.getGroupHelper().deleteSelectedGrops();
    app.getGroupHelper().returnGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size()-1);
      Assert.assertEquals(before,after);
  }

}
