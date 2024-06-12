package fast.campus.fcss07.repository;

import fast.campus.fcss07.domain.User;
import fast.campus.fcss07.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final UserJpaRepository userJpaRepository;

    @Transactional(readOnly = true)
    public User getUserByUsername(String username) {
        return userJpaRepository.findUserByUsername(username)
                .orElseThrow(UserNotFoundException::new)
                .toUser();
    }
}
