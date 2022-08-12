package luiz.augusto.userhandlingforanimelistproject.controllers;

import lombok.RequiredArgsConstructor;
import luiz.augusto.userhandlingforanimelistproject.services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "users")
public class RegistrationController {

    private final UserService userService;


}
