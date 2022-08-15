package luiz.augusto.projetolistadeanimesREMAKE.entities;

import lombok.Data;
import luiz.augusto.projetolistadeanimesREMAKE.entities.enums.Genre;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@Table(name = "tb_anime")
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private List<Integer> genre;
    private Integer releaseYear;
    private String author;
    private String synopsis;


    public Anime(String name, List<Genre> genre, Integer releaseYear, String author, String synopsis)
    {
        this.name = name;
        setGenre(genre);
        this.releaseYear = releaseYear;
        this.author = author;
        this.synopsis = synopsis;
    }

    public void setGenre(List<Genre> genre)
    {
        if(!getGenre().isEmpty())
            this.genre = this.genre.stream().map((x) -> genre.get(x).getCode()).collect(Collectors.toList());
    }

    public List<Genre> getGenre()
    {
        List<Genre> listOfGenres = new ArrayList<Genre>();
        listOfGenres = this.genre.stream().map((x) -> Genre.valueOf(this.genre.get(x))).collect(Collectors.toList());
        return listOfGenres;
    }


}
