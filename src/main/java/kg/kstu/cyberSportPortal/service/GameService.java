package kg.kstu.cyberSportPortal.service;

import kg.kstu.cyberSportPortal.dto.request.game.GameDtoRequest;
import kg.kstu.cyberSportPortal.dto.response.game.GameDtoResponse;

import java.util.List;

public interface GameService {
    List<GameDtoResponse> getAllGames();

    GameDtoResponse createUpdateGame(GameDtoRequest gameDtoRequest);

    GameDtoResponse deleteUpdateGame(GameDtoRequest gameDtoRequest);
}
