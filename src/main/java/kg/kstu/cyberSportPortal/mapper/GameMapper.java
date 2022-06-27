package kg.kstu.cyberSportPortal.mapper;

import kg.kstu.cyberSportPortal.dto.response.game.GameDtoResponse;
import kg.kstu.cyberSportPortal.entity.Game;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GameMapper {
    GameMapper INSTANCE = Mappers.getMapper(GameMapper.class);

    GameDtoResponse toGameDto(Game game);
}
