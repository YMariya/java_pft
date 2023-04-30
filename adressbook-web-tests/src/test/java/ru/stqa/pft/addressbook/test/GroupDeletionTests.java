package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

        @Test
        public void testGroupDeletion() throws Exception {
            app.gotoGroupPage();
            app.selectGroups();
            app.deleteSelectGroups();
            app.returnToGroupPage();
        }


}



