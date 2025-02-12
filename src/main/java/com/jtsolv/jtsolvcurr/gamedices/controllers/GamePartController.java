package com.jtsolv.jtsolvcurr.gamedices.controllers;

import com.jtsolv.jtsolvcurr.gamedices.model.entity.GamePartEntity;
import com.jtsolv.jtsolvcurr.gamedices.repository.entity.GamePartRepositoryEntity;
import com.jtsolv.jtsolvcurr.logging.LkdGenericLogger;
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
        String sm = "getGameParts";
        LkdGenericLogger.logGenericInfo(sm + "-start-method");
        try {
            List<GamePartEntity> lst = gamePartRepository.findAll();
            LkdGenericLogger.logGenericInfo(sm + "method-end");
            return lst;
        } catch (Exception ex) {
            LkdGenericLogger.logGenericException(ex, sm + "-exception-occ");
            throw ex;
        }


    }

    @PostMapping("/game-part")
    void addGamePart(@RequestBody GamePartEntity gamePart) {
        String sm = "addGamePart";
        LkdGenericLogger.logGenericInfo(sm + "-start-method");
        try {
            gamePart.setId(null);
            gamePartRepository.save(gamePart);
        } catch (Exception ex) {
            LkdGenericLogger.logGenericException(ex, sm + "-exception-occ");
            throw ex;
        }
        LkdGenericLogger.logGenericInfo(sm + "-end-method");
    }
}
