package com.jtsolv.jtsolvcurr.gamedices.controllers;

import com.jtsolv.jtsolvcurr.gamedices.dto.GameStepDTO;
import com.jtsolv.jtsolvcurr.gamedices.service.admin.GameStepService;
import com.jtsolv.jtsolvcurr.logging.LkdGenericLogger;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
@CrossOrigin

public class GameStepController {

	private final GameStepService gameStepService;
	
    public GameStepController(
    		GameStepService gameStepService) {        
        this.gameStepService = gameStepService;
    }

    @GetMapping("/game-step")
    public List<GameStepDTO> getGameSteps() {
        String sm = "getGameSteps";
        LkdGenericLogger.logGenericInfo(sm + "-start-method");
        try {
            final List<GameStepDTO> objects =  this.gameStepService.findAll();
            LkdGenericLogger.logGenericInfo(sm + "-end-method");
            return objects;
        } catch (Exception ex) {
            LkdGenericLogger.logGenericException(ex, sm + "-exception-occ");
            throw ex;
        }
    }

    @PostMapping("/game-step")
    void addGameStep(@RequestBody GameStepDTO gameStepDTO) {
        String sm = "getGameSteps";
        LkdGenericLogger.logGenericInfo(sm + "-start-method");
        try {
            gameStepDTO.setId(null);
            this.gameStepService.createCrud(gameStepDTO) ;
        } catch (Exception ex) {
            LkdGenericLogger.logGenericException(ex, sm + "-exception-occ");
            throw ex;
        }
    }
}
