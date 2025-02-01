package com.jtsolv.jtsolvcurr.gamedices.controllers.game;

import com.jtsolv.jtsolvcurr.gamedices.model.entity.GameEntity;
import com.jtsolv.jtsolvcurr.gamedices.repository.entity.GameRepositoryEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
@CrossOrigin
public class GameController {

    private final GameRepositoryEntity gameRepository;

    public GameController(GameRepositoryEntity gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping("/game")
    public List<GameEntity> getGames() {
        Iterable<GameEntity> outList = gameRepository.findAll();
        return (List<GameEntity>)outList;
    }

    @PostMapping("/game")
    void addGame(@RequestBody GameEntity game) {
        gameRepository.save(game);
    }
}
