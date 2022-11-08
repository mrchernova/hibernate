package by.hibernate.library;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@MappedSuperclass
public class Printable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

}

// еще связи настроить
