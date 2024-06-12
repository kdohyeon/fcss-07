package fast.campus.fcss07.repository.entity;

import fast.campus.fcss07.domain.Authority;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "authorities")
public class AuthorityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @JoinColumn(name = "userEntity")
    @ManyToOne
    private UserEntity userEntity;

    public Authority toAuthority() {
        return Authority.builder()
                .name(this.name)
                .build();
    }
}
