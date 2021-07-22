package ru.truakdsg.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.truakdsg.pft.addressbook.model.GroupData;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test1", "test1", "test1"));
    }
    app.getGroupHelper().selectGrop();
    app.getGroupHelper().deleteSelectedGrops();
    app.getGroupHelper().returnGroupPage();
  }

}
