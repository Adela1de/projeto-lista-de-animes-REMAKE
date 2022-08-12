package luiz.augusto.userhandlingforanimelistproject.repositories;

import luiz.augusto.userhandlingforanimelistproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
