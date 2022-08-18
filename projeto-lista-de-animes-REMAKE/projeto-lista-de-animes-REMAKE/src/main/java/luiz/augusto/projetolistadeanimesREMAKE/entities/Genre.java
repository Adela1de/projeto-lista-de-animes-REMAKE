package luiz.augusto.projetolistadeanimesREMAKE.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tb_genre")
public class Genre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    @JsonIgnore
    @ManyToMany(mappedBy = "genre")
    private List<Anime> anime = new ArrayList<>();

    public Genre(String name) { this.name = name; }
}
