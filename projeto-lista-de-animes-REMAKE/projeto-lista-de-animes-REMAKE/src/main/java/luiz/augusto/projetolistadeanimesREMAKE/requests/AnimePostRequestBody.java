package luiz.augusto.projetolistadeanimesREMAKE.requests;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AnimePostRequestBody {

    private String name;
    private List<Integer> genre;
    private Integer releaseYear;
    private String author;
    private String synopsis;
}
