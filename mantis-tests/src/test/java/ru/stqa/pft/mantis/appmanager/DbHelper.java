package ru.stqa.pft.mantis.appmanager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.pft.mantis.model.UserData;

/**
 * Created by Антон on 30.09.2017.
 */
public class DbHelper {
  private final SessionFactory sessionFactory;

  public DbHelper() {
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
  }

  public UserData userById(int userId) {
    Session session = sessionFactory.openSession();
    UserData result = (UserData) session.createQuery("from UserData where id=" + userId).getSingleResult();
    session.close();
    return result;
  }
}
