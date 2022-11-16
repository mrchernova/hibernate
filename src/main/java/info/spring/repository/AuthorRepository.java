package info.spring.repository;

import info.spring.model.Author;

public interface AuthorRepository {

    void save(Author author);

    Author find(String name);


}
