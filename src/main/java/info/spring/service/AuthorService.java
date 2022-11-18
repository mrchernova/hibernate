package info.spring.service;

import info.spring.model.Author;

import java.util.List;

public interface AuthorService {

    void save(Author author);

    List<Author> find(String name);
}
