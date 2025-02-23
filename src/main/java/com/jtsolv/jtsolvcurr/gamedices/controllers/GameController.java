package com.jtsolv.jtsolvcurr.gamedices.controllers;

import com.jtsolv.jtsolvcurr.gamedices.model.entity.GameEntity;
import com.jtsolv.jtsolvcurr.gamedices.repository.entity.GameRepositoryEntity;
import com.jtsolv.jtsolvcurr.logging.JTSolvGenericLogger;
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
        JTSolvGenericLogger.logGenericInfo("getGames--start");
        try {
            List<GameEntity> outList = gameRepository.findAll();
            JTSolvGenericLogger.logGenericInfo("getGames--end");
            return outList;
        } catch (Exception ex) {
            JTSolvGenericLogger.logGenericException(ex,"getGames");
            throw ex;
        }
    }

    @PostMapping("/game")
    void addGame(@RequestBody GameEntity game) {
        JTSolvGenericLogger.logGenericInfo("addGame-start");
        try {
            game.setId(null);
            gameRepository.save(game);
            JTSolvGenericLogger.logGenericInfo("addGame-end");
        } catch (Exception ex) {
            JTSolvGenericLogger.logGenericException(ex,"addGame-exception");
            throw ex;
        }
        JTSolvGenericLogger.logGenericInfo("addGame-end");
    }
}
