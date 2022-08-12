package luiz.augusto.userhandlingforanimelistproject.controllers;

import lombok.RequiredArgsConstructor;
import luiz.augusto.userhandlingforanimelistproject.events.RegistrationCompleteEvent;
import luiz.augusto.userhandlingforanimelistproject.mapper.UserMapper;
import luiz.augusto.userhandlingforanimelistproject.requests.UserPostRequestBody;
import luiz.augusto.userhandlingforanimelistproject.services.UserService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "users")
public class RegistrationController {

    private final UserService userService;
    private final ApplicationEventPublisher applicationEventPublisher;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(
            @RequestBody UserPostRequestBody userPostRequestBody,
            HttpServletRequest request
    )
    {
        var user = UserMapper.toUser(userPostRequestBody);
        var savedUser = userService.registerUser(user);
        applicationEventPublisher.publishEvent(new RegistrationCompleteEvent(savedUser, applicationUrl(request)));
        return ResponseEntity.ok("User successfully registered!");
    }

    @PostMapping("/confirmRegistration")
    public ResponseEntity<String> confirmRegistration(@RequestParam("token") String token)
    {
        return ResponseEntity.ok(userService.validateToken(token));
    }

    private String applicationUrl(HttpServletRequest request)
    {
        return "http://" +
                request.getServerName() +
                ":" +
                request.getServerPort() +
                request.getContextPath();
    }
}
