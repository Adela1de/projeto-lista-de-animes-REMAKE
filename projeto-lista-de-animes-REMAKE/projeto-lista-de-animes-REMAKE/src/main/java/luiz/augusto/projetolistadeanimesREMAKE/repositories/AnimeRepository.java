package luiz.augusto.projetolistadeanimesREMAKE.repositories;

import luiz.augusto.projetolistadeanimesREMAKE.entities.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {

    @Query(value = "select ani.* from tb_anime ani, tb_genre g " +
            "inner join tb_anime_genre anig " +
            "where anig.anime_id = ani.id " +
            "and g.id = anig.genre_id " +
            "and g.name like ? " , nativeQuery = true)
    Anime findAnimesByGenre(String genreName);
}
