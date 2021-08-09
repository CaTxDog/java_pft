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
      app.group().create(new GroupData()
              .withName("New name " + app.group().generateRandomInt(50))
              .withHeader("New header " + app.group().generateRandomInt(50))
              .withFooter("New footer " + app.group().generateRandomInt(50)));
    }
  }

  @Test
  public void testGroupCreation() throws Exception {
    List<GroupData> before = app.group().list();
    int index = before.size()-1;
    GroupData group = new GroupData()
            .withId(before.get(index).getId())
            .withName("Modify name " + app.group().generateRandomInt(50))
            .withHeader("Modify header " + app.group().generateRandomInt(50))
            .withFooter("Modify footer " + app.group().generateRandomInt(50));
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
