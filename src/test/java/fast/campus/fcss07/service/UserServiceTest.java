package fast.campus.fcss07.service;

import fast.campus.fcss07.domain.user.CreateUser;
import fast.campus.fcss07.domain.user.User;
import fast.campus.fcss07.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService sut;

    @Test
    @DisplayName("user 가 존재하면 runtime exception 을 발생시킨다.")
    void registerFailureCase() {
        // given
        CreateUser user = new CreateUser(
                "danny.kim",
                "12345"
        );
        given(userRepository.userExists(user.getUsername()))
                .willReturn(true);

        // when & then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> sut.register(user)
        );
        Assertions.assertEquals(
                runtimeException.getMessage(),
                "User [danny.kim] already exists"
        );
    }

    @Test
    @DisplayName("user 가 존재하지 않으면 회원가입을 수행한다.")
    void registerSuccessCase() {
        // given
        CreateUser user = new CreateUser(
                "danny.kim",
                "12345"
        );
        given(userRepository.userExists(user.getUsername()))
                .willReturn(false);
        given(userRepository.create(user))
                .willReturn(User.builder()
                        .username(user.getUsername())
                        .build());

        // when
        String register = sut.register(user);

        // then
        Assertions.assertEquals(register, user.getUsername());
        verify(userRepository, times(1))
                .create(user);
    }
}