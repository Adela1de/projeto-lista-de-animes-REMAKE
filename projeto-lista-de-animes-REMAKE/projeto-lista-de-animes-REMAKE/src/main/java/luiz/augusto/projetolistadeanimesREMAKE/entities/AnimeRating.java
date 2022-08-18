package luiz.augusto.projetolistadeanimesREMAKE.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "tb_anime")
@NoArgsConstructor
public class AnimeRating implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinTable(
            name = "tb_rating_anime",
            joinColumns = @JoinColumn(name = "rating_id"),
            inverseJoinColumns = @JoinColumn(name = "anime_id")
    )
    private List<Anime> animes = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "tb_rating_user",
            joinColumns = @JoinColumn(name = "rating_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users = new ArrayList<>();
    private Integer rating;

    public AnimeRating(Integer rating)
    {
        this.rating = rating;
    }

}
