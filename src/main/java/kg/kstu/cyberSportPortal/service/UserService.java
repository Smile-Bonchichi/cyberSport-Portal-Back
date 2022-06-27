package kg.kstu.cyberSportPortal.service;

import kg.kstu.cyberSportPortal.dto.request.user.UserDtoRequest;
import kg.kstu.cyberSportPortal.dto.response.user.UserDtoResponse;

public interface UserService {
    UserDtoResponse signUpUser(UserDtoRequest userSignUpDtoRequest);

    UserDtoResponse signInUser(UserDtoRequest userSignInDtoRequest);
}
