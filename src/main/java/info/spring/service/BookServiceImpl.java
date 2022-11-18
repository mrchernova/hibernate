package info.spring.service;

import info.spring.model.Author;
import info.spring.model.Book;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Setter
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private AuthorService as = new AuthorServiceImpl();

    public void save(Book book) {
        //check author
//        Author author = as.find(book.getAuthor().getName());
//        if (author != null) {
//            as.save(book.getAuthor());
//        }
        System.out.println("book saved");

    }
}



