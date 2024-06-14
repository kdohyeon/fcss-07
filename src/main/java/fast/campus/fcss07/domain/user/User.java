package fast.campus.fcss07.domain.user;

import fast.campus.fcss07.domain.Authority;
import fast.campus.fcss07.domain.EncryptionAlgorithm;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class User {
    private String username;
    private String password;
    private EncryptionAlgorithm algorithm;
    private List<Authority> authorities;
}
