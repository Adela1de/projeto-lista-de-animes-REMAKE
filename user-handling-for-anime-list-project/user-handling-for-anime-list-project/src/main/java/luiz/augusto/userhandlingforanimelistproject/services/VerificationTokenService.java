package luiz.augusto.userhandlingforanimelistproject.services;

import luiz.augusto.userhandlingforanimelistproject.entities.User;
import luiz.augusto.userhandlingforanimelistproject.entities.VerificationToken;

public interface VerificationTokenService {

    VerificationToken saveVerificationTokenForUser(User user, String token);
}
