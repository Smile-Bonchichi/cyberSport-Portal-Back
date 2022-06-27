package kg.kstu.cyberSportPortal.service;

import kg.kstu.cyberSportPortal.dto.request.userData.UserDataDtoRequest;
import kg.kstu.cyberSportPortal.dto.response.userData.UserDataDtoResponse;

public interface UserDataService {
    UserDataDtoResponse writeNewUserData(UserDataDtoRequest userDataDtoRequest);
}
