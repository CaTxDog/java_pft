package ru.truakdsg.pft.addressbook;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    gotoGroupPage();
    selectGrop();
    deleteSelectedGrops();
    returnGroupPage();
  }

}
