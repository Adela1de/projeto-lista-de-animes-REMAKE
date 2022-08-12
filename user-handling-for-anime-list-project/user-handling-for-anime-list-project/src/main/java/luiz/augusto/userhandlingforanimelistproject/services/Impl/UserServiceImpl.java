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
        var verificationToken = verificationTokenRepository.findByToken(token).orElseThrow(
                () -> new ObjectNotFoundException("Invalid token!")
        );

        var calendar = Calendar.getInstance();
        if(verificationToken.getExpirationTime().getTime() - calendar.getTime().getTime() >= 10)
            throw new TokenExpiredException("This token is Expired! ");

        var user = verificationToken.getUser();
        user.setEnabled(true);
        userRepository.save(user);

        return "User successfully enabled! ";
    }
}
