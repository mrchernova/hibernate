package info.spring.repository;

import info.spring.model.Author;

import java.util.List;

public interface AuthorRepository {

    void save(Author author);

    List<Author> find(String name);


}
