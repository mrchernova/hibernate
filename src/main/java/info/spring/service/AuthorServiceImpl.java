package info.spring.service;

import info.spring.model.Author;
import info.spring.repository.AuthorRepository;
import info.spring.repository.AuthorRepositoryImpl;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Setter
public class AuthorServiceImpl implements AuthorService {

//        @Autowired
//        private final AuthorRepository repository = new AuthorRepositoryImpl();
        private AuthorRepository repository;// 3. создание контекста из репозитория? (не по имени)

        public void save(Author author) {
                repository.save(author);
        }

        public Author find(String name) {

                return repository.find(name);
        }

}
