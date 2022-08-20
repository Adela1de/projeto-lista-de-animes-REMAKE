package luiz.augusto.projetolistadeanimesREMAKE.mapper;

import lombok.RequiredArgsConstructor;
import luiz.augusto.projetolistadeanimesREMAKE.entities.Genre;
import luiz.augusto.projetolistadeanimesREMAKE.requests.GenrePostRequestBody;
import org.modelmapper.ModelMapper;

@RequiredArgsConstructor
public class GenreMapper {


    private static final ModelMapper mapper = new ModelMapper();

    public static Genre toGenre(GenrePostRequestBody genrePostRequestBody)
    {
        Genre genre = mapper.map(genrePostRequestBody, Genre.class);
        return genre;
    }
}
