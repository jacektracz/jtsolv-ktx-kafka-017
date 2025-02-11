package com.jtsolv.jtsolvcurr.gamedices.controllers;

import com.jtsolv.jtsolvcurr.gamedices.model.entity.GamePartEntity;
import com.jtsolv.jtsolvcurr.gamedices.repository.entity.GamePartRepositoryEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
@CrossOrigin

public class GamePartController {

    private final GamePartRepositoryEntity gamePartRepository;

    public GamePartController(GamePartRepositoryEntity gamePartRepository) {
        this.gamePartRepository = gamePartRepository;
    }

    @GetMapping("/game-part")
    public List<GamePartEntity> getGameParts() {
        return (List<GamePartEntity>) gamePartRepository.findAll();
    }

    @PostMapping("/game-part")
    void addGamePart(@RequestBody GamePartEntity gamePart) {
    	gamePartRepository.save(gamePart);
    }
}
