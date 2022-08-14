package luiz.augusto.userhandlingforanimelistproject.events.listeners;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import luiz.augusto.userhandlingforanimelistproject.events.ResendVerificationTokenEvent;
import luiz.augusto.userhandlingforanimelistproject.services.UserService;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Log4j2
@Component
public class ResendVerificationTokenEventListener implements ApplicationListener<ResendVerificationTokenEvent> {

    private final UserService userService;

    @Override
    public void onApplicationEvent(ResendVerificationTokenEvent event) {
        var verificationToken = userService.getVerificationToken(event.getToken());
        verificationToken.setToken(UUID.randomUUID().toString());
        userService.saveVerificationToken(verificationToken);

        var url = event.getApplicationUrl() + "/users/confirmRegistration?token=" + verificationToken.getToken();
        log.info("Click the link to verify your e-mail: {}", url);

    }
}
