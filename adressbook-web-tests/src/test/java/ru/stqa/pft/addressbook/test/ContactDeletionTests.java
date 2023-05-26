package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;


@Test //(enabled = false)
public class ContactDeletionTests extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().home();

        if ( app.contact().getContactList().size() == 0){
            app.goTo().contact();
            app.contact().add();
        }
    }

    public void testContactDeletion() {
        List<ContactData> before = app.contact().getContactList();
        int index = before.size() -1;
        app.contact().delete(index);
        app.goTo().home();

        List<ContactData> after = app.contact().getContactList();
        Assert.assertEquals(after.size(),before.size() - 1);

        before.remove(index);
        Assert.assertEquals(before,after);

    }




}
