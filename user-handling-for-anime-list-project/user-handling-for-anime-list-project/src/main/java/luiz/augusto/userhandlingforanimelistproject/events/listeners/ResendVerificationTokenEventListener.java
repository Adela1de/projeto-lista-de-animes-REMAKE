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
        var oldToken = event.getToken();
        var newToken = userService.generateNewVerificationToken(oldToken);

        var url = event.getApplicationUrl() + "/users/confirmRegistration?token=" + newToken.getToken();
        log.info("Click the link to verify your e-mail: {}", url);

    }
}
