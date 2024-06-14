package fast.campus.fcss07.service;

import fast.campus.fcss07.domain.user.CreateUser;
import fast.campus.fcss07.domain.user.User;
import fast.campus.fcss07.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public String register(CreateUser create) {
        return userRepository.create(create).getUsername();
    }

    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }
}
