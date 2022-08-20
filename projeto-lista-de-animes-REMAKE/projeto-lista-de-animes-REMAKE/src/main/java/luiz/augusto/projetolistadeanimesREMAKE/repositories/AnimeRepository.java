package luiz.augusto.projetolistadeanimesREMAKE.repositories;

import luiz.augusto.projetolistadeanimesREMAKE.entities.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {

    @Query(value = "select ani.name from tb_anime ani, tb_genre g " +
            "inner join tb_anime_genre anig " +
            "where anig.anime_id = ani.id " +
            "and g.id = anig.genre_id " +
            "and g.name = :genreName " , nativeQuery = true)
    List<Anime> findAnimesByGenre(@Param("genreName") String genreName);
}
