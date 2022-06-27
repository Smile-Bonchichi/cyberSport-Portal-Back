package kg.kstu.cyberSportPortal.service.database.impl;

import kg.kstu.cyberSportPortal.entity.Game;
import kg.kstu.cyberSportPortal.repository.GameRepository;
import kg.kstu.cyberSportPortal.service.base.impl.CrudServiceImpl;
import kg.kstu.cyberSportPortal.service.database.GameDataBaseService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GameDataBaseServiceImpl extends CrudServiceImpl<Game> implements GameDataBaseService {
    final GameRepository gameRepository;

    @Autowired
    public GameDataBaseServiceImpl(GameRepository gameRepository) {
        super(gameRepository);
        this.gameRepository = gameRepository;
    }

    @Override
    public Game findGameByName(String name) {
        return gameRepository.getByGameName(name);
    }
}
