package info.spring.service;

import info.spring.model.Author;
import info.spring.repository.AuthorRepository;
import info.spring.repository.AuthorRepositoryImpl;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Setter
@Service
public class AuthorServiceImpl implements AuthorService {

        @Autowired
        private  AuthorRepository repository;

        public void save(Author author) {
                repository.save(author);
        }

        public List<Author> find(String name) {

                return repository.find(name);
        }

}
