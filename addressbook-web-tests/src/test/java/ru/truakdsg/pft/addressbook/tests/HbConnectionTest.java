package ru.truakdsg.pft.addressbook.tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.truakdsg.pft.addressbook.model.GroupData;

import java.util.List;

public class HbConnectionTest {

  private SessionFactory sessionFactory;

  @BeforeClass
  protected void setUp() throws Exception {
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    try {
      sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
    }
    catch (Exception e) {
      e.printStackTrace();
      // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
      // so destroy it manually.
      StandardServiceRegistryBuilder.destroy( registry );
    }
  }

  @Test
  public void testHbConnection(){

    Session session = sessionFactory.openSession();
    Transaction tx = session.beginTransaction();
    List<GroupData> result = session.createQuery("from GroupData order by id DESC").list();
    for ( GroupData group : result) {
      System.out.println(group);
      System.out.println();
    }
    System.out.println();
    System.out.println();
    System.out.println();
    GroupData newAdd = (GroupData) session.createQuery("from GroupData order by id DESC").setMaxResults(1).list().get(0);
    GroupData newGroup = new GroupData().withId(newAdd.getId()+1).withName("new group").withHeader("new Header").withFooter("new footer");
    session.save(newGroup);
    List<GroupData> resultNew = session.createQuery("from GroupData").setMaxResults(100).list();
    for ( GroupData group : resultNew) {
      System.out.println(group);
      System.out.println();
    }
    session.flush();
    tx.commit();
    Transaction tx1 = session.beginTransaction();
    GroupData deleteNew = (GroupData) session.createQuery("from GroupData order by id DESC").setMaxResults(1).list().get(0);
    session.delete(deleteNew);
    session.flush();
    tx1.commit();
    session.close();
  }
}
