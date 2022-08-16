package luiz.augusto.projetolistadeanimesREMAKE.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "tb_anime")
@NoArgsConstructor
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "tb_anime_genre",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genre = new ArrayList<>();
    private Integer releaseYear;
    private String author;
    private String synopsis;


    public Anime(String name, List<Genre> genre, Integer releaseYear, String author, String synopsis)
    {
        this.name = name;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.author = author;
        this.synopsis = synopsis;
    }

}
