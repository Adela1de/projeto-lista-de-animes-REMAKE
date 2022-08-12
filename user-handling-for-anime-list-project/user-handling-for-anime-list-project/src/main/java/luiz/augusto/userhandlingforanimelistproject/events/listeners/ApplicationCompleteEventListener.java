package luiz.augusto.userhandlingforanimelistproject.events.listeners;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import luiz.augusto.userhandlingforanimelistproject.events.RegistrationCompleteEvent;
import luiz.augusto.userhandlingforanimelistproject.services.UserService;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Component
public class ApplicationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    private final UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event)
    {
        var token = UUID.randomUUID().toString();
        var user = event.getUser();

        var url = event.getApplicationUrl() + "/confirmRegistration?token=" + token;
        log.info("Click the link to verify your e-mail: {}", url);
    }
}
