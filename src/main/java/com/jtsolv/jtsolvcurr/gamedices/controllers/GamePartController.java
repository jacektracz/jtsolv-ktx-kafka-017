package com.jtsolv.jtsolvcurr.gamedices.controllers;

import com.jtsolv.jtsolvcurr.gamedices.model.entity.GamePartEntity;
import com.jtsolv.jtsolvcurr.gamedices.repository.entity.GamePartRepositoryEntity;
import com.jtsolv.jtsolvcurr.logging.JTSolvGenericLogger;
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
        JTSolvGenericLogger.logGenericInfo(sm + "-start-method");
        try {
            List<GamePartEntity> lst = gamePartRepository.findAll();
            JTSolvGenericLogger.logGenericInfo(sm + "method-end");
            return lst;
        } catch (Exception ex) {
            JTSolvGenericLogger.logGenericException(ex, sm + "-exception-occ");
            throw ex;
        }


    }

    @PostMapping("/game-part")
    void addGamePart(@RequestBody GamePartEntity gamePart) {
        String sm = "addGamePart";
        JTSolvGenericLogger.logGenericInfo(sm + "-start-method");
        try {
            gamePart.setId(null);
            gamePartRepository.save(gamePart);
        } catch (Exception ex) {
            JTSolvGenericLogger.logGenericException(ex, sm + "-exception-occ");
            throw ex;
        }
        JTSolvGenericLogger.logGenericInfo(sm + "-end-method");
    }
}
