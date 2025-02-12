package com.jtsolv.jtsolvcurr.gamedices.controllers;

import com.jtsolv.jtsolvcurr.gamedices.dto.GameStepDefDTO;
import com.jtsolv.jtsolvcurr.gamedices.service.admin.GameStepDefService;
import com.jtsolv.jtsolvcurr.logging.LkdGenericLogger;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
@CrossOrigin

public class GameStepDefController {
    
    private final GameStepDefService gameStepDefService;
    
    public GameStepDefController(final GameStepDefService gameStepDefService) {
        this.gameStepDefService = gameStepDefService;
    }

    @GetMapping("/game-step-def")
    public List<GameStepDefDTO> getGameStepDefs() {
        String sm = "getGameStepDefs";
        LkdGenericLogger.logGenericInfo(sm + "-start-method");
        try {
            List<GameStepDefDTO> result = this.gameStepDefService.findAll();
            LkdGenericLogger.logGenericInfo(sm + "method-end");
            return result;
        } catch (Exception ex) {
            LkdGenericLogger.logGenericException(ex, sm + "-exception-occ");
            throw ex;
        }
    }

    @PostMapping("/game-step-def-disabled")
    public void addGameStepDef(@RequestBody GameStepDefDTO gameStepDef) {
        String sm = "addGameStepDef";
        LkdGenericLogger.logGenericInfo(sm + "-start-method");
        try {
            gameStepDef.setId(null);
            this.gameStepDefService.create(gameStepDef);
        } catch (Exception ex) {
            LkdGenericLogger.logGenericException(ex, sm + "-exception-occ");
            throw ex;
        }

    }
    
    @PostMapping("/game-step-def")
    public void addGameStepDefCrud(@RequestBody GameStepDefDTO gameStepDef) {
        String sm = "getGameSteps";
        LkdGenericLogger.logGenericInfo(sm + "-start-method");
        try {
            gameStepDef.setId(null);
            this.gameStepDefService.createCrud(gameStepDef);
        } catch (Exception ex) {
            LkdGenericLogger.logGenericException(ex, sm + "-exception-occ");
            throw ex;
        }
    }
    
}
