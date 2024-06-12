package fast.campus.fcss07.repository;

import fast.campus.fcss07.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findUserByUsername(String username);
}
