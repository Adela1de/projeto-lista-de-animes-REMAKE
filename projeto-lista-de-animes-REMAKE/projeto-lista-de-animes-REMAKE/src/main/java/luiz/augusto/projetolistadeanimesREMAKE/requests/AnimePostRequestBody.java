package luiz.augusto.projetolistadeanimesREMAKE.requests;

import lombok.Getter;
import lombok.Setter;
import luiz.augusto.projetolistadeanimesREMAKE.entities.enums.Genre;

import java.util.List;

@Getter
@Setter
public class AnimePostRequestBody {

    private String name;
    private List<Genre> genre;
    private Integer releaseYear;
    private String author;
    private String synopsis;
}
