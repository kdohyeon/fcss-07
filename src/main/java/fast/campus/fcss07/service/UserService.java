package fast.campus.fcss07.service;

import fast.campus.fcss07.domain.User;
import fast.campus.fcss07.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }
}
