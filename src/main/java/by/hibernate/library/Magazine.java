package by.hibernate.library;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "magazines")
public class Magazine implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMagazine")
    private int idMagazine;
    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @Override
    public String toString() {
        return "Magazine{" +
                "idMagazine=" + idMagazine +
                ", title='" + title + '\'' +
//                ", author=" + author +
                '}';
    }
}



