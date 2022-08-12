package luiz.augusto.userhandlingforanimelistproject.controllers;

import lombok.RequiredArgsConstructor;
import luiz.augusto.userhandlingforanimelistproject.entities.User;
import luiz.augusto.userhandlingforanimelistproject.mapper.UserMapper;
import luiz.augusto.userhandlingforanimelistproject.requests.UserPostRequestBody;
import luiz.augusto.userhandlingforanimelistproject.services.UserService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "users")
public class RegistrationController {

    private final UserService userService;
    private final ApplicationEventPublisher applicationEventPublisher;

    @PostMapping
    public ResponseEntity<User> registerUser(
            @RequestBody UserPostRequestBody userPostRequestBody,
            final HttpServletRequest request
            )
    {
        var user = UserMapper.toUser(userPostRequestBody);
        var savedUser = userService.registerUser(user);
        return ResponseEntity.ok(savedUser);
    }
}
