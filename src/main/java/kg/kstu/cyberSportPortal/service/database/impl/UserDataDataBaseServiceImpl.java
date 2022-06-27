package kg.kstu.cyberSportPortal.service.database.impl;

import kg.kstu.cyberSportPortal.entity.UserData;
import kg.kstu.cyberSportPortal.repository.UserDataRepository;
import kg.kstu.cyberSportPortal.service.base.impl.CrudServiceImpl;
import kg.kstu.cyberSportPortal.service.database.UserDataDataBaseService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDataDataBaseServiceImpl extends CrudServiceImpl<UserData> implements UserDataDataBaseService {
    final UserDataRepository userDataRepository;

    @Autowired
    public UserDataDataBaseServiceImpl(UserDataRepository userDataRepository) {
        super(userDataRepository);
        this.userDataRepository = userDataRepository;
    }

    @Override
    public UserData findByUserId(Long userId) {
        return userDataRepository.getByUserId(userId);
    }
}
