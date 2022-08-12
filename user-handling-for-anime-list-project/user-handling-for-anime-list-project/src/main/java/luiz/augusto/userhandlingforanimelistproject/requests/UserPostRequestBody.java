package luiz.augusto.userhandlingforanimelistproject.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPostRequestBody {

    private String username;
    private String email;
    private String password;
}
