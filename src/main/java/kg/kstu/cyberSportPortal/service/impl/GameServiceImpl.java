package kg.kstu.cyberSportPortal.service.impl;

import kg.kstu.cyberSportPortal.dto.request.game.GameDtoRequest;
import kg.kstu.cyberSportPortal.dto.response.game.GameDtoResponse;
import kg.kstu.cyberSportPortal.entity.Description;
import kg.kstu.cyberSportPortal.entity.Game;
import kg.kstu.cyberSportPortal.entity.Image;
import kg.kstu.cyberSportPortal.exception.GameNotFoundException;
import kg.kstu.cyberSportPortal.exception.ImageSaveException;
import kg.kstu.cyberSportPortal.mapper.CategoryMapper;
import kg.kstu.cyberSportPortal.mapper.GameMapper;
import kg.kstu.cyberSportPortal.service.GameService;
import kg.kstu.cyberSportPortal.service.database.DescriptionDataBaseService;
import kg.kstu.cyberSportPortal.service.database.GameDataBaseService;
import kg.kstu.cyberSportPortal.service.database.ImageDataBaseService;
import kg.kstu.cyberSportPortal.service.util.CategoryParserService;
import kg.kstu.cyberSportPortal.service.util.ImageLoadingInCloudinaryService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GameServiceImpl implements GameService {
    final GameDataBaseService gameDataBaseService;

    final DescriptionDataBaseService descriptionDataBaseService;

    final ImageDataBaseService imageDataBaseService;

    final ImageLoadingInCloudinaryService imageLoadingInCloudinaryService;

    final CategoryParserService categoryParserService;

    @Autowired
    public GameServiceImpl(GameDataBaseService gameDataBaseService,
                           DescriptionDataBaseService descriptionDataBaseService,
                           ImageDataBaseService imageDataBaseService,
                           ImageLoadingInCloudinaryService imageLoadingInCloudinaryService,
                           CategoryParserService categoryParserService) {
        this.gameDataBaseService = gameDataBaseService;
        this.descriptionDataBaseService = descriptionDataBaseService;
        this.imageDataBaseService = imageDataBaseService;
        this.imageLoadingInCloudinaryService = imageLoadingInCloudinaryService;
        this.categoryParserService = categoryParserService;
    }

    @Override
    public List<GameDtoResponse> getAllGames() {
        return getGameList();
    }

    @Override
    public GameDtoResponse createUpdateGame(GameDtoRequest gameDtoRequest) {
        Game game = gameDataBaseService.findGameByName(gameDtoRequest.getGameName());

        if (game == null) {
            Description description = descriptionDataBaseService.saveOrUpdate(
                    Description.builder()
                            .description(gameDtoRequest.getDescription())
                            .build()
            );

            List<Image> images = addImage(gameDtoRequest.getImages());

            game = gameDataBaseService.saveOrUpdate(
                    Game.builder()
                            .name(gameDtoRequest.getGameName())
                            .description(description)
                            .rating(gameDtoRequest.getRating())
                            .image(imageDataBaseService.saveAll(images))
                            .categories(categoryParserService.addUpdateCategory(gameDtoRequest.getCategoryIds()))
                            .build()
            );
        } else {
            game.setName(gameDtoRequest.getGameName());
            game.setRating(gameDtoRequest.getRating());
            game.setCategories(categoryParserService.addUpdateCategory(gameDtoRequest.getCategoryIds()));

            Description description = game.getDescription();
            description.setDescription(gameDtoRequest.getDescription());
            descriptionDataBaseService.saveOrUpdate(description);

            List<Image> images = game.getImage();
            imageDataBaseService.saveAll(images);

            game = gameDataBaseService.saveOrUpdate(game);
        }

        return GameMapper.INSTANCE.toGameDto(game);
    }

    @Override
    public GameDtoResponse deleteGameByName(GameDtoRequest gameDtoRequest) {
        Game game = gameDataBaseService.findGameByName(gameDtoRequest.getGameName());

        if (game == null) {
            throw new GameNotFoundException("Игры с таким названием не существует", HttpStatus.BAD_REQUEST);
        }

        return GameMapper.INSTANCE.toGameDto(gameDataBaseService.delete(game.getId()));
    }

    private List<Image> addImage(List<MultipartFile> imagesFile) {
        List<Image> imagesDataBase = new ArrayList<>();

        try {
            for (MultipartFile multipartFile : imagesFile) {
                imagesDataBase.add(
                        Image.builder()
                                .url(imageLoadingInCloudinaryService.saveInCloudinary(multipartFile))
                                .build()
                );
            }
        } catch (Exception e) {
            throw new ImageSaveException("Ошибка при загрузке файла в облочное хранилище", HttpStatus.SERVICE_UNAVAILABLE);
        }

        return imagesDataBase;
    }

    private List<GameDtoResponse> getGameList() {
        List<Game> games = gameDataBaseService.findAll();
        List<GameDtoResponse> gameDtoResponses = new ArrayList<>();

        for (Game game : games) {
            gameDtoResponses.add(
                    GameDtoResponse.builder()
                            .gameName(game.getName())
                            .description(game.getDescription().getDescription())
                            .rating(game.getRating())
                            .imagesUrl(game.getImage().stream()
                                    .map(Image::getUrl)
                                    .collect(Collectors.toList()))
                            .categories(CategoryMapper.INSTANCE.toCategoriesDto(game.getCategories()))
                            .build()
            );
        }

        return gameDtoResponses;
    }
}
