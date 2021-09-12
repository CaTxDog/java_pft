package ru.truakdsg.pft.addressbook.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.truakdsg.pft.addressbook.model.ContactData;
import ru.truakdsg.pft.addressbook.model.Contacts;
import ru.truakdsg.pft.addressbook.model.GroupData;
import ru.truakdsg.pft.addressbook.model.Groups;

import java.util.List;

public class DbHelper {

  private final SessionFactory sessionFactory;

  public DbHelper(){
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
  }

  public Groups groups(){
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<GroupData> result = session.createQuery("from GroupData").list();
    session.getTransaction().commit();
    session.close();
    return new Groups(result);
  }

  public Contacts contacts(){
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<ContactData> result = session.createQuery("from ContactData").setMaxResults(1000).list();
    session.getTransaction().commit();
    session.close();
    return new Contacts(result);
  }

  public ContactData contactsFirst(){
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    ContactData result = (ContactData) session.createQuery("from ContactData").setMaxResults(1).list().get(0);
    session.getTransaction().commit();
    session.close();
    return result;
  }

  public GroupData groupsFirst(){
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    GroupData result = (GroupData) session.createQuery("from GroupData").setMaxResults(1).list().get(0);
    session.getTransaction().commit();
    session.close();
    return result;
  }

  public GroupData groupsLast(){
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    GroupData result = (GroupData) session.createQuery("from GroupData order by id DESC").setMaxResults(1).list().get(0);
    session.getTransaction().commit();
    session.close();
    return result;
  }

  public ContactData getContactsById(Integer id){
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    ContactData result = (ContactData) session.createQuery("from ContactData where id = :paramName").setParameter("paramName", id).list().get(0);
    session.getTransaction().commit();
    session.close();
    return result;
  }

  public void addGroup(){
    Session session = sessionFactory.openSession();
    Transaction tx = session.beginTransaction();
    GroupData result = (GroupData) session.createQuery("from GroupData order by id DESC").setMaxResults(1).list().get(0);
    GroupData newGroup = new GroupData().withId(result.getId()+1).withName("new group").withHeader("new Header").withFooter("new footer");
    session.save(newGroup);
    session.flush();
    tx.commit();
    session.close();
  }

  public void deleteGroup(){
    Session session = sessionFactory.openSession();
    Transaction tx = session.beginTransaction();
    GroupData deleteNew = (GroupData) session.createQuery("from GroupData order by id DESC").setMaxResults(1).list().get(0);
    session.delete(deleteNew);
    session.flush();
    tx.commit();
    session.close();
  }
}
