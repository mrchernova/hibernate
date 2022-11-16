package info.spring.service;

import info.spring.model.Author;

public interface AuthorService {

    void save(Author author);

    Author find(String name);
}
