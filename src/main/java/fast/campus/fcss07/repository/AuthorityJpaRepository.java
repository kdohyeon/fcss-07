package fast.campus.fcss07.repository;

import fast.campus.fcss07.repository.entity.AuthorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityJpaRepository extends JpaRepository<AuthorityEntity, Integer> {
}
