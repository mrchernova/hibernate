package info.spring;

import info.spring.model.Author;
import info.spring.model.Book;
import info.spring.repository.AuthorRepositoryImpl;
import info.spring.service.AuthorService;
import info.spring.service.AuthorServiceImpl;
import info.spring.service.BookService;
import info.spring.service.BookServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {
    public static void main(String[] args) {

//        long start = System.currentTimeMillis();
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.config.xml");
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("info.freeit");
//        System.out.println(System.currentTimeMillis() - start);
//        AuthorServiceImpl as = context.getBean(AuthorServiceImpl.class);
//        BookServiceImpl bs = context.getBean(BookServiceImpl.class);
//
//        Author a = new Author(1L, "Tolstoj");
//        Book b = new Book(1L, "War and Peace", a);
//
//        as.save(a);
//        bs.save(b);
//
//        System.out.println(as.find("Tolstoj"));

//        Author author = new Author(1L, "qwerty");
//        Book book = new Book(1L, "title1", author);
//
//
//        AuthorService as = new AuthorServiceImpl();
//        BookService bs = new BookServiceImpl();
//
//        as.save(author);
//        bs.save(book);  // когда сохраняем через книгу, то проверяем а еть ли такой автор и если его нет, тогда мы ничего не сохраним
//        // но если есть, тогда напечатается "book saved"
//        System.out.println(as.find("qwerty"));


        // 2. создание контекста из xml файла
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.config.xml");
////        System.out.println(context != null);
//        Object found = context.getBean("author");
//        Object found2 = (Book)context.getBean("book");
//        System.out.println(found);
//        System.out.println(found);
//        System.out.println(found2);


        // 3. создание контекста из репозитория? (не по имени)
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.config.xml");
        //System.out.println(context != null);

        AuthorServiceImpl as = context.getBean(AuthorServiceImpl.class);
        BookServiceImpl bs = context.getBean(BookServiceImpl.class);

        Author a = new Author(1L, "Tratata");
        Book b = new Book(1L, "tra book", a);

        as.save(a);
        bs.save(b);

        System.out.println(as.find("Tratata"));


    }
}
