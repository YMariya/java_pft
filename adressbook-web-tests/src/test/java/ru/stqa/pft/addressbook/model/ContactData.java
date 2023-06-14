package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import jakarta.persistence.*;
import org.testng.annotations.DataProvider;

import javax.xml.crypto.Data;
import java.io.File;

@Entity

@Table(name = "addressbook")

public class ContactData {
    @XStreamOmitField
    @Id
    @Column(name = "id")
    private int id;


    @Column(name = "deprecated", columnDefinition = "datetime")
    private String deprecated;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "address")
    private String address;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "home")
    private String home;

    @Column(name = "email")
    private String email;

    public String getMobile() {
        return mobile;
    }

    public ContactData withMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getHome() {
        return home;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ContactData withHome(String home) {
        this.home = home;
        return this;
    }


    @Column(name = "photo")
    private String photo;

    public File getPhoto() {
        return new File( photo);
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

    public int getId() {
        return id;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }


    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", home='" + home + '\'' +
                ", work='" + work + '\'' +
                ", email='" + email + '\'' +
                ", email2='" + email2 + '\'' +
                ", email3='" + email3 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }
    @Transient
    private String newAdress;

    public ContactData withNewAdress(String newAdress) {

        this.newAdress = newAdress;
        return this;
    }

    public ContactData withHomePhone(String home) {
        this.home = home;
        return this;
    }


    public ContactData withMobilePhone(String mobile) {
        this.mobile = mobile;
        return this;

    }


    @Column(name = "work")
    private String work;

    public ContactData withWorkPhone(String work) {
        this.work = work;
        return this;
    }

    public String getWorkPhone() {
        return work;
    }

    public void setWorkPhone(String workPhone) {
        this.work = work;
    }

    public String getMobilePhone() {
        return mobile;
    }

    public void setMobilePhone(String mobile) {
        this.mobile = mobile;
    }

    public String getHomePhone() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    @Transient
    public String allPhones;

    @Column(name = "email2")
    public String email2;

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }


    @Column(name = "email3")
    public String email3;

    public String getEmail2() {
        return email2;
    }


    public String getEmail3() {
        return email3;
    }


    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    @Transient
    public String allEmails;

    public String getAllEmails() {
        return allEmails;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    @Transient
    public String allAdress;

    public String getAllAdress() {
        return allAdress;
    }

    public void setNewAdress(String newAdress) {
        this.newAdress = newAdress;
    }
}
