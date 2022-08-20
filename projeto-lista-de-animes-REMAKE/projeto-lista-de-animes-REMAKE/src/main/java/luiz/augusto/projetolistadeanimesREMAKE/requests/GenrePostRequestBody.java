package luiz.augusto.projetolistadeanimesREMAKE.requests;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GenrePostRequestBody {

    private List<String> name;
}
