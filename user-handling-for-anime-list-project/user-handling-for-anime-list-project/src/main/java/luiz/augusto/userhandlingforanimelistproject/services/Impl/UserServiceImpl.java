package luiz.augusto.userhandlingforanimelistproject.services.Impl;

import lombok.RequiredArgsConstructor;
import luiz.augusto.userhandlingforanimelistproject.entities.User;
import luiz.augusto.userhandlingforanimelistproject.entities.VerificationToken;
import luiz.augusto.userhandlingforanimelistproject.exceptions.ObjectNotFoundException;
import luiz.augusto.userhandlingforanimelistproject.exceptions.TokenExpiredException;
import luiz.augusto.userhandlingforanimelistproject.repositories.UserRepository;
import luiz.augusto.userhandlingforanimelistproject.repositories.VerificationTokenRepository;
import luiz.augusto.userhandlingforanimelistproject.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final VerificationTokenRepository verificationTokenRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        return userRepository.save(user);
    }

    @Override
    public VerificationToken saveVerificationTokenForUser(User user, String token) {
        var verificationToken = new VerificationToken(user, token);
        return verificationTokenRepository.save(verificationToken);
    }

    @Override
    public String validateToken(String token) {
        var verificationToken = getVerificationTokenOrElseThrowObjectNotFoundException(token);

        var calendar = Calendar.getInstance();
        if(verificationToken.getExpirationTime().getTime() - calendar.getTime().getTime() <= 10)
            throw new TokenExpiredException("This token is Expired! ");

        var user = verificationToken.getUser();
        user.setEnabled(true);
        userRepository.save(user);

        return "User successfully enabled! ";
    }

    @Override
    public VerificationToken getVerificationTokenOrElseThrowObjectNotFoundException(String token) {
        return verificationTokenRepository.findByToken(token).orElseThrow(
                () -> new ObjectNotFoundException("Token does not exists! ")
        );
    }

    @Override
    public void saveVerificationToken(VerificationToken verificationToken)
    {
        verificationTokenRepository.save(verificationToken);
    }

    @Override
    public VerificationToken generateNewVerificationToken(String oldToken) {
        var token = getVerificationTokenOrElseThrowObjectNotFoundException(oldToken);
        token.setToken(UUID.randomUUID().toString());
        token.setExpirationTime(token.calculateExpirationDate(10));
        verificationTokenRepository.save(token);
        return token;
    }
}
