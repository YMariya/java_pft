package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;


@Test
public class ContactDeletionTests extends TestBase{


    public void testContactDeletion() {

       app.getNavigationHelper().gotoHome();

        if ( ! app.getContactHelper().isThereAContact()){
            app.getNavigationHelper().gotoContactPage();
            app.getContactHelper().addContact();
           }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() -1);

        app.getContactHelper().deleteSelectContact();
        app.wd.switchTo().alert().accept();

        app.getNavigationHelper().gotoHome();


        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before,after);

    }


}
