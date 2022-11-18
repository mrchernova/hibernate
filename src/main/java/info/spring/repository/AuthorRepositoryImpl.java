package info.spring.repository;

import info.spring.model.Author;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Repository
@RequiredArgsConstructor
public class AuthorRepositoryImpl implements AuthorRepository {
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper authorMapper;


    private final String SQL_INSERT_AUTHOR = "insert into author (name) values(?)";
    private final String SQL_FIND_AUTHOR_BY_NAME = "SELECT id, name FROM author a WHERE a.name = ?";

    private Set<Author> authors = new HashSet<>();

    public void save(Author author) {
        jdbcTemplate.update(SQL_INSERT_AUTHOR, author.getName());
        System.out.println("Author inserted");

    }

    public List<Author> find(String name) {
      return jdbcTemplate.query(SQL_FIND_AUTHOR_BY_NAME, authorMapper, name);


    }

}
















