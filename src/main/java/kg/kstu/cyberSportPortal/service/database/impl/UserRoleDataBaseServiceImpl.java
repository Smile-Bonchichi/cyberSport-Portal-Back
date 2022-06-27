package kg.kstu.cyberSportPortal.service.database.impl;

import kg.kstu.cyberSportPortal.entity.UserRole;
import kg.kstu.cyberSportPortal.repository.UserRoleRepository;
import kg.kstu.cyberSportPortal.service.base.impl.CrudServiceImpl;
import kg.kstu.cyberSportPortal.service.database.UserRoleDataBaseService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRoleDataBaseServiceImpl extends CrudServiceImpl<UserRole> implements UserRoleDataBaseService {
    final UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleDataBaseServiceImpl(UserRoleRepository userRoleRepository) {
        super(userRoleRepository);
        this.userRoleRepository = userRoleRepository;
    }
}
