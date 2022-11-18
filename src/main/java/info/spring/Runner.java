package info.spring;

import info.spring.model.Author;
import info.spring.repository.AuthorRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class Runner {
    public static void main(String[] args) {


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("info.spring");

        AuthorRepository ar = context.getBean(AuthorRepository.class);
        Author a = new Author();
        a.setName("Afan");
        ar.save(a);


        List<Author> gena = ar.find("Gena");
        System.out.println(gena);

//        AuthorServiceImpl as = context.getBean(AuthorServiceImpl.class);
//        BookServiceImpl bs = context.getBean(BookServiceImpl.class);
//
//        Author a = new Author(1L, "Tratata");
//        Book b = new Book(1L, "tra book", a);
//
//        as.save(a);
//        bs.save(b);
//
//        System.out.println(as.find("Tratata"));


    }
}
