package kg.kstu.cyberSportPortal.service.database.impl;

import kg.kstu.cyberSportPortal.entity.Role;
import kg.kstu.cyberSportPortal.repository.RoleRepository;
import kg.kstu.cyberSportPortal.service.base.impl.CrudServiceImpl;
import kg.kstu.cyberSportPortal.service.database.RoleDataBaseService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleDataBaseServiceImpl extends CrudServiceImpl<Role> implements RoleDataBaseService {
    final RoleRepository roleRepository;

    @Autowired
    public RoleDataBaseServiceImpl(RoleRepository roleRepository) {
        super(roleRepository);
        this.roleRepository = roleRepository;
    }

    @Override
    public Role saveOrUpdate(Role role) {
        Role roleInDataBase = roleRepository.getByRoleName(role.getRoleName());

        return roleInDataBase == null ? roleRepository.save(role) : roleInDataBase;
    }
}
