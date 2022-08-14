package luiz.augusto.userhandlingforanimelistproject.services;

import luiz.augusto.userhandlingforanimelistproject.entities.User;
import luiz.augusto.userhandlingforanimelistproject.entities.VerificationToken;

public interface UserService {

    User registerUser(User user);

    VerificationToken saveVerificationTokenForUser(User user, String token);

    String validateToken(String token);

    VerificationToken getVerificationToken(String token);

    void saveVerificationToken(VerificationToken token);
}
