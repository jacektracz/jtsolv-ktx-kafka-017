package com.jtsolv.jtsolvcurr.gamedices.controllers.game;

import com.jtsolv.jtsolvcurr.gamedices.model.entity.GameObjectPartEntity;
import com.jtsolv.jtsolvcurr.gamedices.repository.entity.GameObjectPartRepositoryEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
@CrossOrigin

public class GameObjectPartController {

    private final GameObjectPartRepositoryEntity gameObjectPartRepository;

    public GameObjectPartController(GameObjectPartRepositoryEntity gameObjectPartRepository) {
        this.gameObjectPartRepository = gameObjectPartRepository;
    }

    @GetMapping("/game-object-part")
    public List<GameObjectPartEntity> getGameObjectParts() {
        return (List<GameObjectPartEntity>) gameObjectPartRepository.findAll();
    }

    @PostMapping("/game-object-part")
    void addGameObjectPart(@RequestBody GameObjectPartEntity gameObjectPart) {
    	gameObjectPartRepository.save(gameObjectPart);
    }
}
