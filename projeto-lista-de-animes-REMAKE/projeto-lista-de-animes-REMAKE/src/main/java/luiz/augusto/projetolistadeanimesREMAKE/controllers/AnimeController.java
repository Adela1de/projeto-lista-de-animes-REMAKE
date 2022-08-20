package luiz.augusto.projetolistadeanimesREMAKE.controllers;

import lombok.RequiredArgsConstructor;
import luiz.augusto.projetolistadeanimesREMAKE.entities.Anime;
import luiz.augusto.projetolistadeanimesREMAKE.entities.AnimeRating;
import luiz.augusto.projetolistadeanimesREMAKE.requests.AnimePostRequestBody;
import luiz.augusto.projetolistadeanimesREMAKE.requests.GenrePostRequestBody;
import luiz.augusto.projetolistadeanimesREMAKE.services.AnimeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "animes")
public class AnimeController {

    private final AnimeService animeService;

    @GetMapping
    public ResponseEntity<Anime> getAnimeById(@RequestParam("animeId") Long animeId)
    {
        return ResponseEntity.ok().body(animeService.getAnimeById(animeId));
    }

    @PostMapping(path = "/new")
    public ResponseEntity<String> saveNewAnime(@RequestBody AnimePostRequestBody animePostRequestBody)
    {
        animeService.saveAnime(animePostRequestBody);
        return ResponseEntity.ok().body("Anime saved!");
    }

    @PostMapping(path = "/genres/new")
    public ResponseEntity<String> addGenresToAnime(@RequestParam("animeId") Long animeId,
                                                   @RequestBody GenrePostRequestBody genrePostRequestBody)
    {
        var anime = animeService.addGenresToAnime(animeId, genrePostRequestBody);
        return ResponseEntity.ok().body("genres added to anime: "+anime.getName());
    }

    @PostMapping(path = "/rate/new/{animeId}/{userId}")
    public ResponseEntity<String> addNewAnimeRating(@PathVariable Long animeId,
                                                    @PathVariable Long userId,
                                                    @RequestBody AnimeRating animeRating)
    {
        animeService.saveNewAnimeRating(animeId, userId, animeRating);
        return ResponseEntity.ok().body("Rating Saved");
    }

    @PostMapping(path = "/favorites/new/{animeId}/{userId}")
    public ResponseEntity<String> addNewFavorite(@PathVariable Long animeId, @PathVariable Long userId)
    {
        animeService.addFavorite(animeId, userId);
        return ResponseEntity.ok().body("Anime added to favorites");
    }

    @PostMapping(path = "/genres/get")
    public ResponseEntity<List<Anime>> getAnimesByGenre(@RequestParam("genreName") String genreName)
    {
        var animes = animeService.getAnimesByGenre(genreName);
        return ResponseEntity.ok().body(animes);
    }

}
