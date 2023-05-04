package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactModificationTests extends TestBase{
    @Test

    public void testContactModification() {

        app.getNavigationHelper().gotoHome();
        app.getContactHelper().editContact();
        app.getContactHelper().fillContactForm(new ContactData("firstname","lastname","address","email", null), false);
        app.getContactHelper().submitContactModification();
        app.getGroupHelper().returnToHomePage();

    }


}
