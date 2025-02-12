package com.jtsolv.jtsolvcurr.gamedices.controllers;

import com.jtsolv.jtsolvcurr.gamedices.dto.GameLoginDTO;
import com.jtsolv.jtsolvcurr.gamedices.model.entity.GameObjectEntity;
import com.jtsolv.jtsolvcurr.gamedices.repository.entity.GameObjectRepositoryEntity;
import com.jtsolv.jtsolvcurr.logging.LkdGenericLogger;
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
        LkdGenericLogger.logGenericInfo(sm + "-method-start");
        try {
            List<GameObjectEntity> lst =  gameObjectRepository.findAll();
            LkdGenericLogger.logGenericInfo(sm + "method-end");
            return lst;
        } catch (Exception ex) {
            LkdGenericLogger.logGenericException(ex, sm + "method--exception");
            throw ex;
        }
    }

    @PostMapping("/game-object")
    void addGameObject(@RequestBody GameObjectEntity gameObject) {
        String sm = "addGameObject";
        LkdGenericLogger.logGenericInfo(sm + "-start-method");
        try {
            gameObject.setId(null);
            gameObjectRepository.save(gameObject);
        } catch (Exception ex) {
            LkdGenericLogger.logGenericException(ex, sm + "-exception-occ");
            throw ex;
        }
        LkdGenericLogger.logGenericInfo(sm + "-end-method");
    }
}
