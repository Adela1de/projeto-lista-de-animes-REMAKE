package luiz.augusto.userhandlingforanimelistproject.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "tb_user")
@NoArgsConstructor
public class User {

    private Long id;
    private String username;
    private String email;
    private String password;
    private String role;
    private boolean enabled;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
