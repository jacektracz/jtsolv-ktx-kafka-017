package com.jtsolv.jtsolvcurr.gamedices.controllers;

import com.jtsolv.jtsolvcurr.gamedices.model.entity.GameObjectEntity;
import com.jtsolv.jtsolvcurr.gamedices.repository.entity.GameObjectRepositoryEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
@CrossOrigin

public class GameObjectController {

    private final GameObjectRepositoryEntity gameObjectRepository;

    public GameObjectController(GameObjectRepositoryEntity gameObjectRepository) {
        this.gameObjectRepository = gameObjectRepository;
    }

    @GetMapping("/game-object")
    public List<GameObjectEntity> getGameObjects() {
        return (List<GameObjectEntity>) gameObjectRepository.findAll();
    }

    @PostMapping("/game-object")
    void addGameObject(@RequestBody GameObjectEntity gameObject) {
    	gameObjectRepository.save(gameObject);
    }
}
