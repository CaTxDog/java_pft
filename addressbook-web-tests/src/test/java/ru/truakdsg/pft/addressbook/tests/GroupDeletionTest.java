package ru.truakdsg.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGrop();
    app.getGroupHelper().deleteSelectedGrops();
    app.getGroupHelper().returnGroupPage();
  }

}
