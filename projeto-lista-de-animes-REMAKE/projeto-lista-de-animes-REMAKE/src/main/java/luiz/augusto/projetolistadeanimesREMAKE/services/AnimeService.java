package luiz.augusto.projetolistadeanimesREMAKE.services;

import luiz.augusto.projetolistadeanimesREMAKE.entities.Anime;
import luiz.augusto.projetolistadeanimesREMAKE.entities.Genre;

import java.util.List;

public interface AnimeService {

    Anime getAnimeById(Long animeId);

    void saveAnime(Anime anime);

    List<Genre> saveGenresIfNotExists(List<Genre> genres);

    Anime addGenresToAnime(Long animeId, List<Genre> genres);

}
