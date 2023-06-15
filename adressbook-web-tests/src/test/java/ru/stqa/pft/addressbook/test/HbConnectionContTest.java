package ru.stqa.pft.addressbook.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;
import ru.stqa.pft.addressbook.model.ContactData;



public class HbConnectionContTest {

    private SessionFactory sessionFactory;

    @BeforeClass
    protected void setUp() throws Exception {
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            try {
                sessionFactory = (SessionFactory) new MetadataSources( registry ).buildMetadata().buildSessionFactory();
            }
            catch (Exception e) {
                e.printStackTrace();
                StandardServiceRegistryBuilder.destroy( registry );
    }}
    @Test
    public void testHbConnectionContTest() {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

        List result = session.createQuery( "from ContactData where deprecated = '0000-00-00'" ).list();


        session.getTransaction().commit();
        session.close();
        for (ContactData contact  : (List<ContactData>) result ) {
            System.out.println( contact );
            System.out.println(contact.getGroups());
        }
    }
}

