package ru.truakdsg.pft.addressbook;

import org.testng.annotations.*;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("test5", "test5", "test5"));
    submitGroupCreation();
    returnGroupPage();
  }


}
