package ru.truakdsg.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.truakdsg.pft.addressbook.model.GroupData;
import ru.truakdsg.pft.addressbook.model.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().GroupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData()
              .withName("New name " + app.group().generateRandomInt(50))
              .withHeader("New header " + app.group().generateRandomInt(50))
              .withFooter("New footer " + app.group().generateRandomInt(50)));
    }
  }

  @Test
  public void testGroupCreation() throws Exception {
    Groups before = app.group().all();
    GroupData modifyGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifyGroup.getId())
            .withName("Modify name " + app.group().generateRandomInt(50))
            .withHeader("Modify header " + app.group().generateRandomInt(50))
            .withFooter("Modify footer " + app.group().generateRandomInt(50));
    app.group().modify(group);
    Groups after = app.group().all();
    assertEquals(after.size(), before.size());

    before.remove(modifyGroup);
    before.add(group);
    assertEquals(before, after);

    assertThat(after, equalTo(before.withOut(modifyGroup).withAdded(group)));
  }

}
