package info.spring.service;

import info.spring.model.Author;
import info.spring.model.Book;
import lombok.Setter;

@Setter
public class BookServiceImpl implements BookService {

    //private AuthorService as = new AuthorServiceImpl();
    private AuthorService as; // 3. создание контекста из репозитория? (не по имени)

    public void save(Book book) {
        //check author
        Author author = as.find(book.getAuthor().getName());
        if (author != null) {
            as.save(book.getAuthor());
        }
        System.out.println("book saved");

    }
}



