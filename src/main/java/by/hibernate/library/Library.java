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

// ----------------------------------------------------

            Author a = new Author();
            a.setName("authors name");
            Author a1 = new Author();
            a1.setName("authors name1");

            Book b = new Book();
            b.setName("authors n");
            b.setTitle("title book");

            Book b1 = new Book();
            b1.setName("authors n1");
            b1.setTitle("title book1");


            session.save(a);
            session.save(a1);
            session.save(b);
            session.save(b1);



            transaction.commit();



// ----------------------------------------------------





//            Author a = new Author();
//            a.setName_author("author_name");
//
//            System.out.println("saving --AUTHOR-- " + a);
//            int saved = (int) session.save(a);
//            a.setIdAuthor(saved);
//
//            Book b = new Book();
//
//            b.setAuthor(a);
//
//            b.setTitle("title for book");
//            System.out.println("saving --BOOK-- " + b);
//            session.save(b);
//
//
//            transaction.commit();
//            System.out.println("all must be saved");

        }

    }


    public static void Read() {

        try (Session session = getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();




            Author author = session.get(Author.class, 1);
            System.out.println("---FOUND AUTHOR--- \n" + author);
            transaction.commit();
        }
    }


    public static void Update() {

        try (Session session = getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Author a = session.get(Author.class, 1);
            a.setName(sc.nextLine());

            session.update(a);


            transaction.commit();
            System.out.println("----------------author must be updated------------");

        }
    }


    public static void Delete() {

        try (Session session = getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();



            System.out.println("Удалить автора под номером: ");

            try {
                Author a = session.get(Author.class, sc.nextLong());
                session.delete(a);
                System.out.println("автор с таким id удален");
            }catch (Exception e){
                System.out.println("нет автора с таким id");
                System.out.println("или есть связь с другой таблицей");
            }


            transaction.commit();


        }
    }


}
