package kg.kstu.cyberSportPortal.controller;

import io.swagger.annotations.ApiOperation;

import kg.kstu.cyberSportPortal.dto.request.userData.UserDataDtoRequest;
import kg.kstu.cyberSportPortal.dto.response.userData.UserDataDtoResponse;
import kg.kstu.cyberSportPortal.service.UserDataService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user-data/")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDataController {
    final UserDataService userDataService;

    @Autowired
    public UserDataController(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @PostMapping("write-profile")
    @ApiOperation("API для заполнения данных о пользователе на портале")
    public ResponseEntity<UserDataDtoResponse> writeUserData(@Valid @RequestBody UserDataDtoRequest userDataDtoRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userDataService.writeNewUserData(userDataDtoRequest));
    }
}
