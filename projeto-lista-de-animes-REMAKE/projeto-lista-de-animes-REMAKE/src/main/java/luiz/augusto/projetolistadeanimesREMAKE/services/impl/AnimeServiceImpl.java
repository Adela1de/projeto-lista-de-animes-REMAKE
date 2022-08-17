package luiz.augusto.projetolistadeanimesREMAKE.services.impl;

import lombok.RequiredArgsConstructor;
import luiz.augusto.projetolistadeanimesREMAKE.entities.Anime;
import luiz.augusto.projetolistadeanimesREMAKE.entities.Genre;
import luiz.augusto.projetolistadeanimesREMAKE.exceptions.ObjectNotFoundException;
import luiz.augusto.projetolistadeanimesREMAKE.repositories.AnimeRepository;
import luiz.augusto.projetolistadeanimesREMAKE.repositories.GenreRepository;
import luiz.augusto.projetolistadeanimesREMAKE.services.AnimeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeServiceImpl implements AnimeService {

    private final AnimeRepository animeRepository;
    private final GenreRepository genreRepository;

    @Override
    public Anime getAnimeById(Long animeId) {
        return animeRepository.findById(animeId).orElseThrow(
                () -> new ObjectNotFoundException("Anime not found!")
        );
    }

    @Override
    public void saveAnime(Anime anime) {
        saveGenresIfNotExists(anime.getGenre());
        animeRepository.save(anime);
    }

    @Override
    public List<Genre> saveGenresIfNotExists(List<Genre> genres) {
        genres.forEach((x) -> {
            if(genreRepository.findByName(x.getName()) == null) genreRepository.save(x);
        });

        return genres;
    }

    @Override
    public Anime addGenresToAnime(Long animeId, List<Genre> genres) {
        var anime = getAnimeById(animeId);
        var listOfGenres = saveGenresIfNotExists(genres);
        anime.getGenre().addAll(listOfGenres);
        return animeRepository.save(anime);
    }

}
