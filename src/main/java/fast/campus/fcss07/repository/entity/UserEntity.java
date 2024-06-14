package fast.campus.fcss07.repository.entity;

import fast.campus.fcss07.domain.EncryptionAlgorithm;
import fast.campus.fcss07.domain.user.CreateUser;
import fast.campus.fcss07.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private EncryptionAlgorithm algorithm;

    @OneToMany(mappedBy = "userEntity", fetch = FetchType.EAGER)
    private List<AuthorityEntity> authorities;

    public UserEntity(String username, String password, EncryptionAlgorithm algorithm) {
        this.username = username;
        this.password = password;
        this.algorithm = algorithm;
    }

    public User toUser() {
        return User.builder()
                .username(this.username)
                .password(this.password)
                .algorithm(this.algorithm)
                .authorities(this.authorities.stream().map(AuthorityEntity::toAuthority).toList())
                .build();
    }

    public void replaceAuthority(List<AuthorityEntity> authorities) {
        this.authorities = authorities;
    }

    public static UserEntity newUser(CreateUser create) {
        return new UserEntity(
                create.getUsername(),
                create.getPassword(),
                EncryptionAlgorithm.BCRYPT
        );
    }
}
