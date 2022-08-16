package luiz.augusto.projetolistadeanimesREMAKE.repositories;

import luiz.augusto.projetolistadeanimesREMAKE.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    Genre findByName(String name);
}
