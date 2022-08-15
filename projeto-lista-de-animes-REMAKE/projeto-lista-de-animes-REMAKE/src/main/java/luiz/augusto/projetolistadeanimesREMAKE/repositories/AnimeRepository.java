package luiz.augusto.projetolistadeanimesREMAKE.repositories;

import luiz.augusto.projetolistadeanimesREMAKE.entities.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {
}
