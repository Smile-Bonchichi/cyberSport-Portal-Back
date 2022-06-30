package kg.kstu.cyberSportPortal.controller;

import kg.kstu.cyberSportPortal.dto.request.game.GameDtoRequest;
import kg.kstu.cyberSportPortal.dto.response.game.GameDtoResponse;
import kg.kstu.cyberSportPortal.service.GameService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/game/")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GameController {
    final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("get-all-game")
    public ResponseEntity<List<GameDtoResponse>> getAllGames() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(gameService.getAllGames());
    }

    @PostMapping("create-update-game")
    public ResponseEntity<GameDtoResponse> createUpdateGame(@Valid @RequestBody GameDtoRequest gameDtoRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(gameService.createUpdateGame(gameDtoRequest));
    }

    @DeleteMapping("delete-game")
    public ResponseEntity<GameDtoResponse> deleteGame(@Valid @RequestBody GameDtoRequest gameDtoRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(gameService.deleteGameByName(gameDtoRequest));
    }
}
