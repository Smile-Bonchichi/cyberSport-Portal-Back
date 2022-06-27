package kg.kstu.cyberSportPortal.controller;

import io.swagger.annotations.ApiOperation;

import kg.kstu.cyberSportPortal.dto.request.user.UserDtoRequest;
import kg.kstu.cyberSportPortal.dto.response.user.UserDtoResponse;
import kg.kstu.cyberSportPortal.service.UserService;

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
@RequestMapping("/api/user/")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserController {
    final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("sign-up")
    @ApiOperation("API для регистрации на портале")
    public ResponseEntity<UserDtoResponse> signUp(@Valid @RequestBody UserDtoRequest userDtoRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.signUpUser(userDtoRequest));
    }

    @PostMapping("sign-in")
    @ApiOperation("API для авторизации на портале")
    public ResponseEntity<UserDtoResponse> signIn(@Valid @RequestBody UserDtoRequest userDtoRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.signInUser(userDtoRequest));
    }
}
