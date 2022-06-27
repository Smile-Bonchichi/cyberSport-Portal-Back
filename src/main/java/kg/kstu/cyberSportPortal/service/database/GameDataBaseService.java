package kg.kstu.cyberSportPortal.service.database;

import kg.kstu.cyberSportPortal.entity.Game;
import kg.kstu.cyberSportPortal.service.base.CrudService;

public interface GameDataBaseService extends CrudService<Game> {
    Game findGameByName(String name);
}
