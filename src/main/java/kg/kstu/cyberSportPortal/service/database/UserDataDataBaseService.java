package kg.kstu.cyberSportPortal.service.database;

import kg.kstu.cyberSportPortal.entity.UserData;
import kg.kstu.cyberSportPortal.service.base.CrudService;

public interface UserDataDataBaseService extends CrudService<UserData> {
    UserData findByUserId(Long userId);
}
