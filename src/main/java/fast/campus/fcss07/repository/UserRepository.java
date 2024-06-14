package fast.campus.fcss07.repository;

import fast.campus.fcss07.domain.Authority;
import fast.campus.fcss07.domain.EncryptionAlgorithm;
import fast.campus.fcss07.domain.user.CreateUser;
import fast.campus.fcss07.domain.user.User;
import fast.campus.fcss07.exception.UserNotFoundException;
import fast.campus.fcss07.repository.entity.AuthorityEntity;
import fast.campus.fcss07.repository.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final UserJpaRepository userJpaRepository;
    private final AuthorityJpaRepository authorityJpaRepository;

    @Transactional(readOnly = true)
    public Boolean userExists(String username) {
        return userJpaRepository.findUserByUsername(username).isPresent();
    }

    @Transactional(readOnly = true)
    public User getUserByUsername(String username) {
        return userJpaRepository.findUserByUsername(username)
                .orElseThrow(UserNotFoundException::new)
                .toUser();
    }

    @Transactional
    public User create(CreateUser create) {
        UserEntity user = userJpaRepository.save(UserEntity.newUser(create));
        AuthorityEntity authority = authorityJpaRepository.save(new AuthorityEntity("READ", user));
        user.replaceAuthority(List.of(authority));

        return user.toUser();
    }
}
