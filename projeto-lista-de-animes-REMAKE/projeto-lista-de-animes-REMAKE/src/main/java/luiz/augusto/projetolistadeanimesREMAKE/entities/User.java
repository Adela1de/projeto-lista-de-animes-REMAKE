package luiz.augusto.projetolistadeanimesREMAKE.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "tb_user")
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String role;
    private boolean enabled = false;
    @ManyToMany(mappedBy = "users")
    private List<AnimeRating> ratings = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "tb_user_favorite",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "anime_id")
    )
    private List<Anime> favorites = new ArrayList<>();

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }


}
