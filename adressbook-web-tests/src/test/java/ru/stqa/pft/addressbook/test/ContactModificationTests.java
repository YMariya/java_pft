package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().home();

        if ( app.contact().getContactList().size() == 0){
            app.goTo().contact();
            app.contact().add();
        }
    }
    @Test //(enabled = false)

    public void testContactModification() {
        List<ContactData> before = app.contact().getContactList();
        int index = before.size() -1;
        ContactData contact = new ContactData( before.get(index).getId(),"firstname","lastname","address","email");

        app.contact().modify(index, contact);
        List<ContactData> after = app.contact().getContactList();
        Assert.assertEquals(after.size(),before.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after); }



}
