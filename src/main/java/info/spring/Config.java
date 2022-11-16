package info.spring;

import info.spring.repository.AuthorRepository;
import info.spring.repository.AuthorRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public AuthorRepository authorRepository() {
        return new AuthorRepositoryImpl();
    }

}
