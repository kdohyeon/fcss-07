package fast.campus.fcss07.repository.entity;

import fast.campus.fcss07.domain.EncryptionAlgorithm;
import fast.campus.fcss07.domain.User;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
@Table(name = "users")
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

    public User toUser() {
        return User.builder()
                .username(this.username)
                .password(this.password)
                .algorithm(this.algorithm)
                .authorities(this.authorities.stream().map(AuthorityEntity::toAuthority).toList())
                .build();
    }
}
