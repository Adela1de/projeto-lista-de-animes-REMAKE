package luiz.augusto.projetolistadeanimesREMAKE.controllers;

import lombok.RequiredArgsConstructor;
import luiz.augusto.projetolistadeanimesREMAKE.entities.Anime;
import luiz.augusto.projetolistadeanimesREMAKE.services.AnimeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "animes")
public class AnimeController {

    private final AnimeService animeService;

    @PostMapping
    public ResponseEntity<Anime> getAnimeById(@RequestParam("animeId") Long animeId)
    {
        return ResponseEntity.ok().body(animeService.getAnimeById(animeId));
    }
}
