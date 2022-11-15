package by.hibernate.library;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@MappedSuperclass
public class Printable {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "namePrint")
    private String namePrint;

}
