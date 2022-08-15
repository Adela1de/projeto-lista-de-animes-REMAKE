package luiz.augusto.projetolistadeanimesREMAKE.mapper;

import lombok.RequiredArgsConstructor;
import luiz.augusto.projetolistadeanimesREMAKE.entities.Anime;
import luiz.augusto.projetolistadeanimesREMAKE.requests.AnimePostRequestBody;
import org.modelmapper.ModelMapper;

@RequiredArgsConstructor
public class AnimeMapper {


    private static final ModelMapper mapper = new ModelMapper();

    public static Anime toAnime(AnimePostRequestBody animePostRequestBody)
    {
        Anime anime = mapper.map(animePostRequestBody, Anime.class);
        return anime;
    }
}
