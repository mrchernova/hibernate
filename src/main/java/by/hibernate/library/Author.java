package by.hibernate.library;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "authors")
public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_author")
    private long id_author;

    @Column(name = "name_author")
    private String name_author;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author") // имя поля в классе  Book
    private Set<Book> books = new HashSet<>();


    @Override
    public String toString() {
        return "Author{" +
                "id_author=" + id_author +
                ", name_author='" + name_author + '\'' +
                ", books=" + books +
                '}';
    }
}