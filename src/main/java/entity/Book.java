package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@NamedQuery(name = "Book.findAllBooks", query = "SELECT b FROM Book b")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @Column(nullable = false)
    private String title;
    private Float price;
    @Size(max = 2000)
    @Column(length = 2000)
    private String description;
    private String isbn;
    private Integer nbOfPage;
    private Boolean illustrations;
}
