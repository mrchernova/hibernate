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
public class Author extends Printable implements Serializable {


    @Column(name = "name")
    private String name;




}