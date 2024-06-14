package fast.campus.fcss07.repository.entity;

import fast.campus.fcss07.domain.Authority;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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

    AuthorityEntity(String name) {
        this.name = name;
    }

    public Authority toAuthority() {
        return Authority.builder()
                .name(this.name)
                .build();
    }

    public static List<AuthorityEntity> readAuthority() {
        List<AuthorityEntity> result = new ArrayList<AuthorityEntity>();
        result.add(new AuthorityEntity("READ"));
        return result;
    }
}
