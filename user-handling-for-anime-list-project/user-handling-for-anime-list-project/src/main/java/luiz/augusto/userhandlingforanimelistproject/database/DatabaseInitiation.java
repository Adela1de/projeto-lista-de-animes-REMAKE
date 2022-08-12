package luiz.augusto.userhandlingforanimelistproject.database;

import lombok.RequiredArgsConstructor;
import luiz.augusto.userhandlingforanimelistproject.controllers.RegistrationController;
import luiz.augusto.userhandlingforanimelistproject.requests.UserPostRequestBody;
import luiz.augusto.userhandlingforanimelistproject.services.UserService;

@RequiredArgsConstructor
public class DatabaseInitiation {

    private final RegistrationController registrationController;

    public void DbInit()
    {
        registrationController.registerUser(new UserPostRequestBody(
           "Adelaide",
           "Adelaide@Adelaide.com",
           "6666"
        ));

        registrationController.registerUser(new UserPostRequestBody(
                "Luiz Augusto",
                "luiz@augusto.com",
                "78960"
        ));

        registrationController.registerUser(new UserPostRequestBody(
                "João",
                "Joao@gmail.com",
                "12345"
        ));

        registrationController.registerUser(new UserPostRequestBody(
                "Rogerio",
                "Rogerio@Silva.com",
                "67890"
        ));
    }
}
