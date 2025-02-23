package com.jtsolv.jtsolvcurr.gamedices.controllers;

import com.jtsolv.jtsolvcurr.gamedices.model.entity.GameObjectEntity;
import com.jtsolv.jtsolvcurr.gamedices.repository.entity.GameObjectRepositoryEntity;
import com.jtsolv.jtsolvcurr.logging.JTSolvGenericLogger;
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
        String sm = "getGameObjects-";
        JTSolvGenericLogger.logGenericInfo(sm + "-method-start");
        try {
            List<GameObjectEntity> lst =  gameObjectRepository.findAll();
            JTSolvGenericLogger.logGenericInfo(sm + "method-end");
            return lst;
        } catch (Exception ex) {
            JTSolvGenericLogger.logGenericException(ex, sm + "method--exception");
            throw ex;
        }
    }

    @PostMapping("/game-object")
    void addGameObject(@RequestBody GameObjectEntity gameObject) {
        String sm = "addGameObject";
        JTSolvGenericLogger.logGenericInfo(sm + "-start-method");
        try {
            gameObject.setId(null);
            gameObjectRepository.save(gameObject);
        } catch (Exception ex) {
            JTSolvGenericLogger.logGenericException(ex, sm + "-exception-occ");
            throw ex;
        }
        JTSolvGenericLogger.logGenericInfo(sm + "-end-method");
    }
}
