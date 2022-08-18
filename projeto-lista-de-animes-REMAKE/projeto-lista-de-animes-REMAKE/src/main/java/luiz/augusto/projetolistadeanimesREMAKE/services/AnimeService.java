package luiz.augusto.projetolistadeanimesREMAKE.services;

import luiz.augusto.projetolistadeanimesREMAKE.entities.Anime;
import luiz.augusto.projetolistadeanimesREMAKE.entities.AnimeRating;
import luiz.augusto.projetolistadeanimesREMAKE.entities.Genre;
import luiz.augusto.projetolistadeanimesREMAKE.entities.User;
import luiz.augusto.projetolistadeanimesREMAKE.requests.AnimePostRequestBody;
import luiz.augusto.projetolistadeanimesREMAKE.requests.GenrePostRequestBody;

import java.util.List;

public interface AnimeService {

    Anime getAnimeById(Long animeId);

    User getUserById(Long userId);

    Genre getGenreByName(String name);

    void saveAnime(AnimePostRequestBody animePostRequestBody);

    Anime addGenresToAnime(Long animeId, GenrePostRequestBody genrePostRequestBody);

    List<Genre> verifyIfGenresExistsIfNotSaveIt(List<String> genres);

    void saveNewAnimeRating(Long animeId, Long userId, AnimeRating animeRating);
}
