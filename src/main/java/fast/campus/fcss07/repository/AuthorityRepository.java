package fast.campus.fcss07.repository;

import fast.campus.fcss07.domain.Authority;
import fast.campus.fcss07.repository.entity.AuthorityEntity;
import fast.campus.fcss07.repository.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class AuthorityRepository {
    private final AuthorityJpaRepository authorityJpaRepository;

    @Transactional
    public Authority create(String name, UserEntity user) {
        return authorityJpaRepository.save(new AuthorityEntity(name, user))
                .toAuthority();
    }
}
