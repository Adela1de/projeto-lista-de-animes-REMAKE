package luiz.augusto.projetolistadeanimesREMAKE.controllers;

import lombok.RequiredArgsConstructor;
import luiz.augusto.projetolistadeanimesREMAKE.entities.Anime;
import luiz.augusto.projetolistadeanimesREMAKE.entities.Genre;
import luiz.augusto.projetolistadeanimesREMAKE.mapper.AnimeMapper;
import luiz.augusto.projetolistadeanimesREMAKE.requests.AnimePostRequestBody;
import luiz.augusto.projetolistadeanimesREMAKE.services.AnimeService;
import luiz.augusto.projetolistadeanimesREMAKE.services.GenreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "animes")
public class AnimeController {

    private final AnimeService animeService;
    private final GenreService genreService;

    @GetMapping
    public ResponseEntity<Anime> getAnimeById(@RequestParam("animeId") Long animeId)
    {
        return ResponseEntity.ok().body(animeService.getAnimeById(animeId));
    }

    @PostMapping
    public ResponseEntity<String> saveNewAnime(@RequestBody AnimePostRequestBody animePostRequestBody)
    {
        var anime = AnimeMapper.toAnime(animePostRequestBody);
        animeService.saveAnime(anime);
        return ResponseEntity.ok().body("Anime saved!");
    }

    @PostMapping(path = "/genre/new")
    public ResponseEntity<String> saveNewGenre(@RequestBody Genre genre)
    {
        genreService.saveGenre(genre);
        return ResponseEntity.ok().body("Genre successfully saved! " );
    }

}
