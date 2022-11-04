package by.hibernate.library;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "authors")
public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "author_seq")
    @Column(name = "id_author")
    private int id_author;

    @Column(name = "name_author")
    private String name_author;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author") // имя поля в классе  Book
    private Set<Book> books = new HashSet<>();

}