package luiz.augusto.projetolistadeanimesREMAKE.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "tb_anime")
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private List<Integer> genre;
    private Integer releaseYear;
    private String author;
    private String synopsis;


}
