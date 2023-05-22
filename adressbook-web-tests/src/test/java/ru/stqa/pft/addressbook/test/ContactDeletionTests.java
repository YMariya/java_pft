package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;


@Test
public class ContactDeletionTests extends TestBase{


    public void testContactDeletion() {

       app.getNavigationHelper().gotoHome();

        if ( ! app.getContactHelper().isThereAContact()){
            app.getNavigationHelper().gotoContactPage();
            app.getContactHelper().addContact();
           }
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectContact(before -1);

        app.getContactHelper().deleteSelectContact();
        app.wd.switchTo().alert().accept();
      //  int after = app.getContactHelper().getContactCount();
        app.getNavigationHelper().gotoHome();


        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after,before - 1);
    }


}
