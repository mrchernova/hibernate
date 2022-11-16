package info.spring.repository;

import info.spring.model.Author;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Setter
public class AuthorRepositoryImpl implements AuthorRepository {

    //private Set<Author> authors = new HashSet<>();
    private Set<Author> authors; // 3. создание контекста из репозитория? (не по имени)

    public void save(Author author) {
        authors.add(author);
    }

    public Author find(String name) {
        return authors.stream()
                .filter(author -> author.getName().equals(name))
                .findFirst().orElse(null);
    }

}
