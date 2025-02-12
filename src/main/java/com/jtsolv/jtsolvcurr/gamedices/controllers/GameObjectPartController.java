package com.jtsolv.jtsolvcurr.gamedices.controllers;

import com.jtsolv.jtsolvcurr.gamedices.model.entity.GameObjectPartEntity;
import com.jtsolv.jtsolvcurr.gamedices.repository.entity.GameObjectPartRepositoryEntity;
import com.jtsolv.jtsolvcurr.logging.LkdGenericLogger;
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
        String sm = "getGameObjectParts";
        LkdGenericLogger.logGenericInfo(sm + "-start-method");
        try {
            List<GameObjectPartEntity> lst = gameObjectPartRepository.findAll();
            LkdGenericLogger.logGenericInfo(sm + "method-end");
            return lst;
        } catch (Exception ex) {
            LkdGenericLogger.logGenericException(ex, sm + "-exception-occ");
            throw ex;
        }

    }

    @PostMapping("/game-object-part")
    void addGameObjectPart(@RequestBody GameObjectPartEntity gameObjectPart) {
        String sm = "addGameObjectPart";
        LkdGenericLogger.logGenericInfo(sm + "-start-method");
        try {
            gameObjectPart.setId(null);
            gameObjectPartRepository.save(gameObjectPart);
        } catch (Exception ex) {
            LkdGenericLogger.logGenericException(ex, sm + "-exception-occ");
            throw ex;
        }
        LkdGenericLogger.logGenericInfo(sm + "-end-method");
    }
}
