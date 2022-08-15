package luiz.augusto.projetolistadeanimesREMAKE.services.impl;

import lombok.RequiredArgsConstructor;
import luiz.augusto.projetolistadeanimesREMAKE.entities.Anime;
import luiz.augusto.projetolistadeanimesREMAKE.exceptions.ObjectNotFoundException;
import luiz.augusto.projetolistadeanimesREMAKE.repositories.AnimeRepository;
import luiz.augusto.projetolistadeanimesREMAKE.services.AnimeService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnimeServiceImpl implements AnimeService {

    private final AnimeRepository animeRepository;

    @Override
    public Anime getAnimeById(Long animeId) {
        return animeRepository.findById(animeId).orElseThrow(
                () -> new ObjectNotFoundException("Anime not found!")
        );
    }

    public void saveAnime(Anime anime) { animeRepository.save(anime); }

}
