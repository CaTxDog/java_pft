package ru.truakdsg.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.truakdsg.pft.addressbook.appmanager.HelperBase;
import ru.truakdsg.pft.addressbook.model.GroupData;

import java.util.*;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().GroupPage();
    if (app.group().list().size() == 0) {
      app.group().create(new GroupData("test1", "test1", "test1"));
    }
  }

  @Test
  public void testGroupCreation() throws Exception {
    List<GroupData> before = app.group().list();
    int index = before.size()-1;
    GroupData group = new GroupData(
            before.get(index).getId(),
            "Name Modify " + HelperBase.generateRandomInt(50),
            "Header Modify " + HelperBase.generateRandomInt(50),
            "Footer Modify " + HelperBase.generateRandomInt(50));
    app.group().modify(index, group);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(group);
    Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
