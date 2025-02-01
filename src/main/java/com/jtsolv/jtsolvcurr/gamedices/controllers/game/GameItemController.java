package com.jtsolv.jtsolvcurr.gamedices.controllers.game;

import com.jtsolv.jtsolvcurr.gamedices.model.entity.GameItemEntity;
import com.jtsolv.jtsolvcurr.gamedices.repository.entity.GameItemRepositoryEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
@CrossOrigin
public class GameItemController {

    private final GameItemRepositoryEntity gameItemRepository;

    public GameItemController(GameItemRepositoryEntity gameItemRepository) {
        this.gameItemRepository = gameItemRepository;
    }

    @GetMapping("/game-item")
    public List<GameItemEntity> getGameItems() {
        return (List<GameItemEntity>) gameItemRepository.findAll();
    }

    @PostMapping("/game-item")
    void addGameItem(@RequestBody GameItemEntity gameItem) {
    	gameItemRepository.save(gameItem);
    }
}
