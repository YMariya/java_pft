package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.sql.*;

public class DbConnectionContactTest {
    @Test
    public void testDbConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?&user=root&password=");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select id,lastname,firstname,address, mobile, home, work," +
                    " email, email2, email3  from addressbook");
            Contacts contacts = new Contacts();
            while (rs.next()) {
                contacts.add(new ContactData().withId(rs.getInt("id")).withLastname(rs.getString("lastname"))
                        .withFirstname(rs.getString("firstname")).withAddress(rs.getString("address"))
                        .withMobilePhone(rs.getString("mobile")).withHome(rs.getString("home"))
                        .withWorkPhone(rs.getString("work")).withEmail(rs.getString("email"))
                        .withEmail2(rs.getString("email2")).withEmail3(rs.getString("email3")));
            }
            rs.close();
            st.close();
            conn.close();

            System.out.println(contacts);


        } catch (SQLException ex) {

            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
