package kg.kstu.cyberSportPortal.service.database.impl;

import kg.kstu.cyberSportPortal.entity.User;
import kg.kstu.cyberSportPortal.repository.UserRepository;
import kg.kstu.cyberSportPortal.service.base.impl.CrudServiceImpl;
import kg.kstu.cyberSportPortal.service.database.UserDataBaseService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDataBaseServiceImpl extends CrudServiceImpl<User> implements UserDataBaseService {
    final UserRepository userRepository;

    @Autowired
    public UserDataBaseServiceImpl(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    @Override
    public User getByLogin(String login) {
        return userRepository.getByLogin(login);
    }
}
