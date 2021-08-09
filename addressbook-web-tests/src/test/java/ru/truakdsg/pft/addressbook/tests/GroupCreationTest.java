package ru.truakdsg.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.truakdsg.pft.addressbook.model.GroupData;

import java.util.Set;

public class GroupCreationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().GroupPage();
  }

  @Test
  public void testGroupCreation() throws Exception {
    Set<GroupData> before = app.group().all();
    GroupData group = new GroupData()
            .withName("name " + app.group().generateRandomInt(50))
            .withHeader("header " + app.group().generateRandomInt(50))
            .withFooter("footer " + app.group().generateRandomInt(50));
    app.group().create(group);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(group);
    Assert.assertEquals(before, after);
  }
}
