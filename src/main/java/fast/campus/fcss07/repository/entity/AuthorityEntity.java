package fast.campus.fcss07.repository.entity;

import fast.campus.fcss07.domain.Authority;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "authorities")
@AllArgsConstructor
@NoArgsConstructor
public class AuthorityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @JoinColumn(name = "userEntity")
    @ManyToOne
    private UserEntity userEntity;

    public AuthorityEntity(String name, UserEntity user) {
        this.name = name;
        this.userEntity = user;
    }

    public Authority toAuthority() {
        return Authority.builder()
                .name(this.name)
                .build();
    }
}
