package luiz.augusto.projetolistadeanimesREMAKE.services;

import luiz.augusto.projetolistadeanimesREMAKE.entities.Anime;

public interface AnimeService {

    Anime getAnimeById(Long animeId);

    void saveAnime(Anime anime);
}
