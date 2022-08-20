package luiz.augusto.projetolistadeanimesREMAKE.services.impl;

import lombok.RequiredArgsConstructor;
import luiz.augusto.projetolistadeanimesREMAKE.entities.Anime;
import luiz.augusto.projetolistadeanimesREMAKE.entities.AnimeRating;
import luiz.augusto.projetolistadeanimesREMAKE.entities.Genre;
import luiz.augusto.projetolistadeanimesREMAKE.entities.User;
import luiz.augusto.projetolistadeanimesREMAKE.exceptions.ObjectNotFoundException;
import luiz.augusto.projetolistadeanimesREMAKE.repositories.AnimeRatingRepository;
import luiz.augusto.projetolistadeanimesREMAKE.repositories.AnimeRepository;
import luiz.augusto.projetolistadeanimesREMAKE.repositories.GenreRepository;
import luiz.augusto.projetolistadeanimesREMAKE.repositories.UserRepository;
import luiz.augusto.projetolistadeanimesREMAKE.requests.AnimePostRequestBody;
import luiz.augusto.projetolistadeanimesREMAKE.requests.GenrePostRequestBody;
import luiz.augusto.projetolistadeanimesREMAKE.services.AnimeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnimeServiceImpl implements AnimeService {

    private final AnimeRepository animeRepository;
    private final GenreRepository genreRepository;
    private final AnimeRatingRepository animeRatingRepository;
    private final UserRepository userRepository;

    @Override
    public Anime getAnimeById(Long animeId) {
        return animeRepository.findById(animeId).orElseThrow(
                () -> new ObjectNotFoundException("Anime not found!")
        );
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new ObjectNotFoundException("User not found!")
        );
    }

    @Override
    public Genre getGenreByName(String name) {
        return genreRepository.findByName(name).orElseThrow(() -> new ObjectNotFoundException("Genre does not exists"));
    }

    @Override
    public void saveAnime(AnimePostRequestBody animePostRequestBody) {
        var anime = new Anime();

        anime.setName(animePostRequestBody.getName());
        anime.setAuthor(animePostRequestBody.getAuthor());
        anime.setSynopsis(animePostRequestBody.getSynopsis());
        anime.setReleaseYear(animePostRequestBody.getReleaseYear());
        anime.setGenre(verifyIfGenresExistsIfNotSaveIt(animePostRequestBody.getGenre()));

        animeRepository.save(anime);
    }

    @Override
    public Anime addGenresToAnime(Long animeId, GenrePostRequestBody genrePostRequestBody) {
        var anime = getAnimeById(animeId);
        anime.getGenre().addAll(verifyIfGenresExistsIfNotSaveIt(genrePostRequestBody.getName()));
        return animeRepository.save(anime);
    }

    @Override
    public List<Genre> verifyIfGenresExistsIfNotSaveIt(List<String> genres) {

        List<Genre> savedGenres = new ArrayList<>();

        var unsavedGenres = genres.stream().filter(this::genreDoesNotExists).collect(Collectors.toList());
        var savedGenresAsString = genres.stream().filter(
                (x) -> !genreDoesNotExists(x)).collect(Collectors.toList()
        );

        savedGenresAsString.forEach((x) -> savedGenres.add(getGenreByName(x)));
        unsavedGenres.forEach((x) -> savedGenres.add(genreRepository.save(new Genre(x))));

        return savedGenres;
    }

    @Override
    public void saveNewAnimeRating(Long animeId, Long userId, AnimeRating animeRating)
    {
        var anime = getAnimeById(animeId);
        var user = getUserById(userId);
        animeRating.getAnimes().add(anime);
        animeRating.getUsers().add(user);
        animeRatingRepository.save(animeRating);
    }

    @Override
    public void addFavorite(Long animeId, Long userId) {
        var anime = getAnimeById(animeId);
        var user = getUserById(userId);

        user.getFavorites().add(anime);
        userRepository.save(user);
    }

    @Override
    public List<Anime> getAnimesByGenre(String genreName) {
        return animeRepository.findAnimesByGenre(genreName);
    }

    private boolean genreDoesNotExists(String name)
    {
        return !genreRepository.findByName(name).isPresent();
    }

}
