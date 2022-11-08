package by.hibernate.library;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Scanner;


public class Library {
    private static SessionFactory factory = null;
    private static Scanner sc = new Scanner(System.in);

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
            a.setName_author("author_name");

            System.out.println("saving --AUTHOR-- " + a);
            long saved = (long) session.save(a);
            a.setId_author(saved);

            Book b = new Book();

            b.setAuthor(a);

            b.setTitle("title for book");
            System.out.println("saving --BOOK-- " + b);
            session.save(b);


            transaction.commit();
            System.out.println("all must be saved");

        }

    }


    public static void Read() {

        try (Session session = getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();


            Author author = session.get(Author.class, 1L);
            System.out.println("---FOUND AUTHOR--- \n" + author);
            transaction.commit();
        }
    }


    public static void Update() {

        try (Session session = getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Author a = session.get(Author.class, 1L);
            a.setName_author(sc.nextLine());

            session.update(a);


            transaction.commit();
            System.out.println("----------------author must be updated------------");

        }
    }


    public static void Delete() {

        try (Session session = getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();


            Author a = session.get(Author.class, sc.nextLong());
            a.setName_author("noname");

            session.delete(a);


            transaction.commit();
            System.out.println("----------------author must be deleted------------");

        }
    }


}
