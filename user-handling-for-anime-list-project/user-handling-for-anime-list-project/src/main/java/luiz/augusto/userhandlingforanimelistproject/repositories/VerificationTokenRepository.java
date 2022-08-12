package luiz.augusto.userhandlingforanimelistproject.repositories;

import luiz.augusto.userhandlingforanimelistproject.entities.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
}
