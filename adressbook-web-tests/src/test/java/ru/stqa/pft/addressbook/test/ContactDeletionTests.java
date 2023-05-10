package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


@Test
public class ContactDeletionTests extends TestBase{


    public void testContactDeletion() {
        app.getNavigationHelper().gotoHome();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectContact();
        app.wd.switchTo().alert().accept();
        app.getNavigationHelper().gotoContactPage();

    }
}
