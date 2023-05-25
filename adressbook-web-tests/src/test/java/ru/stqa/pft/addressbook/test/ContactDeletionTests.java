package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;


@Test (enabled = false)
public class ContactDeletionTests extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().gotoHome();

        if ( ! app.getContactHelper().isThereAContact()){
            app.goTo().gotoContactPage();
            app.getContactHelper().addContact();
        }
    }

    public void testContactDeletion() {
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() -1);

        app.getContactHelper().deleteSelectContact();
        app.wd.switchTo().alert().accept();

        app.goTo().gotoHome();


        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before,after);

    }


}
