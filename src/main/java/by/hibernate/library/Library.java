package by.hibernate.library;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class Library {
    private static SessionFactory factory = null;


    private static SessionFactory getSessionFactory() {
        if (factory == null) {
            Configuration config = new Configuration();
            config.configure("hibernate.cfg.xml");

            ServiceRegistry serReg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
            factory = config.buildSessionFactory();
        }
        return factory;
    }


    public static void Create() {
        try (Session session = getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Author a = new Author();
            a.setName_author("author_la-la-la");

            System.out.println("saving --AUTHOR-- " + a);
            int saved = (int) session.save(a); //or .persist(a)
            a.setId_author(saved);

            Book b = new Book();

            b.setAuthor(a);

            b.setTitle("here must be title for book");
            System.out.println("saving --BOOK-- " + b);
            session.save(b);


            transaction.commit();
            System.out.println("all must be saved");
        }

    }


}
