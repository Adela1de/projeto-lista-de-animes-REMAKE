package luiz.augusto.projetolistadeanimesREMAKE.services.impl;

import lombok.RequiredArgsConstructor;
import luiz.augusto.projetolistadeanimesREMAKE.entities.Anime;
import luiz.augusto.projetolistadeanimesREMAKE.entities.Genre;
import luiz.augusto.projetolistadeanimesREMAKE.exceptions.ObjectNotFoundException;
import luiz.augusto.projetolistadeanimesREMAKE.repositories.AnimeRepository;
import luiz.augusto.projetolistadeanimesREMAKE.repositories.GenreRepository;
import luiz.augusto.projetolistadeanimesREMAKE.requests.AnimePostRequestBody;
import luiz.augusto.projetolistadeanimesREMAKE.services.AnimeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        var listOfGenres = anime.getGenre();
        saveGenresIfNotExists(listOfGenres);
        anime.getGenre().removeAll(listOfGenres);
        animeRepository.save(anime);
        anime.getGenre().addAll(listOfGenres);
        animeRepository.save(anime);
    }

    @Override
    public void saveGenresIfNotExists(List<Genre> genres) {
        genres.forEach((x) -> {
            if(genreRepository.findByName(x.getName()) == null) genreRepository.save(x);
        });
    }

    @Override
    public List<Genre> saveNewGenresIfNotExists(List<String> genres)
    {
        var listOfGenres = genres.stream().map((x) -> new Genre(x) ).collect(Collectors.toList());
        saveGenresIfNotExists(listOfGenres);
        return listOfGenres;
    }

    @Override
    public Anime addGenresToAnime(Long animeId, List<String> genres) {
        var anime = getAnimeById(animeId);
        var listOfGenres = saveNewGenresIfNotExists(genres);
        anime.getGenre().addAll(listOfGenres);
        return animeRepository.save(anime);
    }

}
