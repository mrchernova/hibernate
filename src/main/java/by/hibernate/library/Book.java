package by.hibernate.library;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Book extends Printable implements Serializable{

    @Column(name = "title")
    private String title;



}



