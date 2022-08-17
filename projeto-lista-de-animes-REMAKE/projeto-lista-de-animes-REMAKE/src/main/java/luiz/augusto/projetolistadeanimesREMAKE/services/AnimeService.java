package luiz.augusto.projetolistadeanimesREMAKE.services;

import luiz.augusto.projetolistadeanimesREMAKE.entities.Anime;
import luiz.augusto.projetolistadeanimesREMAKE.entities.Genre;
import luiz.augusto.projetolistadeanimesREMAKE.requests.AnimePostRequestBody;
import luiz.augusto.projetolistadeanimesREMAKE.requests.GenrePostRequestBody;

import java.util.List;

public interface AnimeService {

    Anime getAnimeById(Long animeId);

    Genre getGenreByName(String name);

    void saveAnime(AnimePostRequestBody animePostRequestBody);

    Anime addGenresToAnime(Long animeId, GenrePostRequestBody genrePostRequestBody);

    List<Genre> verifyIfGenresExists(List<String> genres);
}
