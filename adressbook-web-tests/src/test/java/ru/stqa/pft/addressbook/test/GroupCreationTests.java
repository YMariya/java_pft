package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;


public class GroupCreationTests extends  TestBase {


    @Test
    public void testGroupCreation() {
int before = app.getGroupHelper().getGroupCount();
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        int after = app.getGroupHelper().getGroupCount();
      Assert.assertEquals(after,before + 1);

    }

}






