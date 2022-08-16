package luiz.augusto.projetolistadeanimesREMAKE.services.impl;

import lombok.RequiredArgsConstructor;
import luiz.augusto.projetolistadeanimesREMAKE.entities.Genre;
import luiz.augusto.projetolistadeanimesREMAKE.repositories.GenreRepository;
import luiz.augusto.projetolistadeanimesREMAKE.services.GenreService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;


    @Override
    public void saveGenre(Genre genre) {
        genreRepository.save(genre);
    }
}
