package kg.kstu.cyberSportPortal.service.impl;

import kg.kstu.cyberSportPortal.dto.request.user.UserDtoRequest;
import kg.kstu.cyberSportPortal.dto.response.user.UserDtoResponse;
import kg.kstu.cyberSportPortal.entity.*;
import kg.kstu.cyberSportPortal.exception.UserNotCorrectPasswordException;
import kg.kstu.cyberSportPortal.exception.UserNotFoundException;
import kg.kstu.cyberSportPortal.mapper.UserMapper;
import kg.kstu.cyberSportPortal.service.UserService;
import kg.kstu.cyberSportPortal.service.database.*;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Collections;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {
    final UserDataBaseService userDataBaseService;

    final RoleDataBaseService roleDataBaseService;

    final UserRoleDataBaseService userRoleDataBaseService;

    final UserDataDataBaseService userDataDataBaseService;

    final DescriptionDataBaseService descriptionDataBaseService;

    final CategoryDataBaseService categoryDataBaseService;

    final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDataBaseService userDataBaseService,
                           RoleDataBaseService roleDataBaseService,
                           UserRoleDataBaseService userRoleDataBaseService,
                           UserDataDataBaseService userDataDataBaseService,
                           DescriptionDataBaseService descriptionDataBaseService,
                           CategoryDataBaseService categoryDataBaseService,
                           PasswordEncoder passwordEncoder) {
        this.userDataBaseService = userDataBaseService;
        this.roleDataBaseService = roleDataBaseService;
        this.userRoleDataBaseService = userRoleDataBaseService;
        this.userDataDataBaseService = userDataDataBaseService;
        this.descriptionDataBaseService = descriptionDataBaseService;
        this.categoryDataBaseService = categoryDataBaseService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDtoResponse signUpUser(UserDtoRequest userSignUpDtoRequest) {
        User user = UserMapper.INSTANCE.toUserEntity(userSignUpDtoRequest);
        List<Category> categories;
        Role role;

        if (user.getLogin().equalsIgnoreCase("admin")) {
            role = roleDataBaseService.saveOrUpdate(
                    Role.builder()
                            .roleName("ROLE_ADMIN")
                            .build()
            );
            categories = Collections.singletonList(categoryDataBaseService.findByName("ADMIN"));
        } else {
            role = roleDataBaseService.saveOrUpdate(
                    Role.builder()
                            .roleName("ROLE_USER")
                            .build()
            );

            categories = Collections.singletonList(categoryDataBaseService.findByName("Новичок"));
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setIsActive(1L);
        user = userDataBaseService.saveOrUpdate(user);

        userRoleDataBaseService.saveOrUpdate(
                UserRole.builder()
                        .user(user)
                        .role(role)
                        .build()
        );

        userDataDataBaseService.saveOrUpdate(
                UserData.builder()
                        .user(user)
                        .description(descriptionDataBaseService.getById(1L))
                        .categories(categories)
                        .build()
        );

        return getToken(user.getLogin(), userSignUpDtoRequest.getPassword());
    }

    @Override
    public UserDtoResponse signInUser(UserDtoRequest userSignInDtoRequest) {
        User user = userDataBaseService.getByLogin(userSignInDtoRequest.getLogin());

        if (user == null)
            throw new UserNotFoundException("Такого пользователя нет", HttpStatus.BAD_REQUEST);

        boolean isMatches = passwordEncoder.matches(userSignInDtoRequest.getPassword(), user.getPassword());
        if (isMatches) {
            return getToken(user.getLogin(), userSignInDtoRequest.getPassword());
        } else {
            throw new UserNotCorrectPasswordException("Неправильный логин или пароль", HttpStatus.BAD_REQUEST);
        }
    }

    private UserDtoResponse getToken(String login, String password) {
        return UserDtoResponse.builder()
                .token("Basic " + new String(
                        Base64.getEncoder().encode((login + ":" + password).getBytes())
                )).build();
    }
}
