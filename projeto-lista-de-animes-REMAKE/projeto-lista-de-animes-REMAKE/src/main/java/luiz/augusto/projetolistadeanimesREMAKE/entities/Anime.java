package luiz.augusto.projetolistadeanimesREMAKE.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "tb_anime")
@NoArgsConstructor
public class Anime implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "tb_anime_genre",
            joinColumns = @JoinColumn(name = "anime_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genre = new ArrayList<>();
    private Integer releaseYear;
    private String author;
    private String synopsis;
    @ManyToMany(mappedBy = "animes")
    private List<AnimeRating> animeRatings = new ArrayList<>();
    @ManyToMany(mappedBy = "favorites")
    private List<User> favoriteBy = new ArrayList<>();


    public Anime(String name, Integer releaseYear, String author, String synopsis)
    {
        this.name = name;
        this.releaseYear = releaseYear;
        this.author = author;
        this.synopsis = synopsis;
    }

}
