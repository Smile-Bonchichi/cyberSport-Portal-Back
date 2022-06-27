package kg.kstu.cyberSportPortal.service.database;

import kg.kstu.cyberSportPortal.entity.User;
import kg.kstu.cyberSportPortal.service.base.CrudService;

public interface UserDataBaseService extends CrudService<User> {
    User getByLogin(String login);
}
