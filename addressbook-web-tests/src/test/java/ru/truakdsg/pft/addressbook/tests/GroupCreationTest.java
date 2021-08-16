package ru.truakdsg.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.truakdsg.pft.addressbook.model.GroupData;
import ru.truakdsg.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().GroupPage();
  }

  @Test
  public void testGroupCreation() throws Exception {
    Groups before = app.group().all();
    GroupData group = new GroupData()
            .withName("name " + app.group().generateRandomInt(50))
            .withHeader("header " + app.group().generateRandomInt(50))
            .withFooter("footer " + app.group().generateRandomInt(50));
    app.group().create(group);
    Groups after = app.group().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
}
