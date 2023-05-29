package ru.stqa.pft.addressbook.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends GroupHelper {

    private boolean creation;

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("address"), contactData.getAddress());
        type(By.name("email"), contactData.getEmail());

//        if (creation) {
//            new Select(wd.findElement(By.name("selected[]"))).selectByVisibleText(contactData.getFirstname());
//        } else {
//            Assert.assertFalse(isElementPresent(By.linkText("add new")));
//        }
         }
        public void selectContact (int index) {
            wd.findElements(By.name("selected[]")).get(index).click();
        }
    public void selectContactById (int id) {
        wd.findElement(By.cssSelector("input[value'"+ id + "']")).click();
    }

        public void deleteSelectContact () {
            click(By.xpath("//div[2]/input"));
        }

        public void editContact (int index)  {
           // click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
            // wd.findElements(By.name("selected[]")).get(index).click();
            wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();

        }

        public void submitContactModification () {
            click(By.xpath("//input[22]"));
        }


    public void createContact(ContactData contact) {

        fillContactForm(contact);
        submitContactCreation();
        returnToHomePage();
    }
    public void modifyContacts( ContactData contact) {
        editContact(contact.getId());
        fillContactForm(contact);
        submitContactModification();
        returnToHomePage();
    }

    public void delete(int index) {
        selectContact(index);
        deleteSelectContact();
        wd.switchTo().alert().accept();
    }


    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteSelectContact();
        wd.switchTo().alert().accept();
    }

    public boolean isThereAContact() {
        return  isElementPresent(By.name("selected[]"));
    }


    public void add() {

        fillContactForm(new ContactData().withFirstname("Иван").withLastname("Сидоров").withAddress("Москва"));
        submitContactCreation();
        returnToHomePage();
    }

    public int getContactCount() {
      return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[@name = 'entry']"));
        for (WebElement element : elements) {
            List<WebElement> rowElements = element.findElements(By.tagName("td"));
            String name = rowElements.get(2).getText();
            String lastname = rowElements.get(1).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData().whithId(id).withFirstname(name).withLastname(lastname);
            contacts.add(contact);
        }
        return contacts;
    }

    public Set<ContactData> allContacts() {
        Set<ContactData> contacts = new HashSet<ContactData>();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[@name = 'entry']"));
        for (WebElement element : elements) {
            List<WebElement> rowElements = element.findElements(By.tagName("td"));
            String name = rowElements.get(2).getText();
            String lastname = rowElements.get(1).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData().whithId(id).withFirstname(name).withLastname(lastname);
            contacts.add(contact);
        }
        return contacts;
    }


}
