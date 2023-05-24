package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {
    @BeforeMethod
    public  void ensurePrecondition() {
        app.getNavigationHelper().gotoGroupPage();

        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
    }
    @Test
    public void testGroupDeletion() throws Exception {
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroups(before.size() - 1);
        app.getGroupHelper().deleteSelectGroups();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);

    }


}



