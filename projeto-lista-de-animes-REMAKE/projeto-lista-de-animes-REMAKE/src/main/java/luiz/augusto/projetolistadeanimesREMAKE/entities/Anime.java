package luiz.augusto.projetolistadeanimesREMAKE.entities;

import lombok.*;
import luiz.augusto.projetolistadeanimesREMAKE.entities.enums.Genre;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@ToString
@EqualsAndHashCode
@Table(name = "tb_anime")
@NoArgsConstructor
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String name;
    private Integer[] genre;
    @Getter
    @Setter
    private Integer releaseYear;
    @Getter
    @Setter
    private String author;
    @Getter
    @Setter
    private String synopsis;


    public Anime(String name, List<Integer> genre, Integer releaseYear, String author, String synopsis)
    {
        this.name = name;
        setGenre(genre);
        this.releaseYear = releaseYear;
        this.author = author;
        this.synopsis = synopsis;
    }

    public void setGenre(List<Integer> genre)
    {
        this.genre = genre.toArray(new Integer[genre.size()]);
    }

    public List<Genre> getGenre()
    {
        List<Integer> listOfGenreCodes = Arrays.asList(genre);
        List<Genre> listOfGenres = listOfGenreCodes.stream().map((x) -> Genre.valueOf(x)).collect(Collectors.toList());
        return listOfGenres;
    }

}
