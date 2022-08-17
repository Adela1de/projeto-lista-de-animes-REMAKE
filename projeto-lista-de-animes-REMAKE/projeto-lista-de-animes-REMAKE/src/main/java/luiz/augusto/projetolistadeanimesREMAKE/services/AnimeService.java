package luiz.augusto.projetolistadeanimesREMAKE.services;

import luiz.augusto.projetolistadeanimesREMAKE.entities.Anime;
import luiz.augusto.projetolistadeanimesREMAKE.entities.Genre;
import luiz.augusto.projetolistadeanimesREMAKE.requests.AnimePostRequestBody;

import java.util.List;

public interface AnimeService {

    Anime getAnimeById(Long animeId);

    Genre getGenreByName(String name);

    void saveAnime(AnimePostRequestBody animePostRequestBody);

    void saveUnsavedGenres(List<String> genres);

    Anime addGenresToAnime(Long animeId, List<Genre> genres);

    List<Genre> verifyIfGenresExists(List<String> genres);
}
