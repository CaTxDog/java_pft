package ru.truakdsg.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.truakdsg.pft.addressbook.model.GroupData;
import ru.truakdsg.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTest extends TestBase {

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
  public void testGroupDeletion() throws Exception {
    Groups before = app.group().all();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Groups after = app.group().all();
    assertEquals(after.size(), before.size()-1);

    before.remove(deletedGroup);
    assertThat(after, equalTo(before.withOut(deletedGroup)));
  }

}
