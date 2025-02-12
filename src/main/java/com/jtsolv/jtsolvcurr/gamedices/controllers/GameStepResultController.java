package com.jtsolv.jtsolvcurr.gamedices.controllers;

import com.jtsolv.jtsolvcurr.gamedices.dto.GameStepDefDTO;
import com.jtsolv.jtsolvcurr.gamedices.dto.GameStepResultDTO;
import com.jtsolv.jtsolvcurr.gamedices.dto.filters.GameGenericFilterDTO;
import com.jtsolv.jtsolvcurr.gamedices.service.admin.GameStepResultService;
import com.jtsolv.jtsolvcurr.gamedices.service.game.DicesGameDataCollectorService;
import com.jtsolv.jtsolvcurr.gamedices.service.game.DicesGameExecutorService;
import com.jtsolv.jtsolvcurr.logging.LkdGenericLogger;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/game")
@CrossOrigin

public class GameStepResultController {

	private final GameStepResultService gameStepResultService;
	private final DicesGameExecutorService dicesGameExecutorService;
	private final DicesGameDataCollectorService dicesGameDataCollectorService;
    public GameStepResultController(
    		final GameStepResultService gameStepResultService,
    		final DicesGameExecutorService dicesGameExecutorService,
    		final DicesGameDataCollectorService dicesGameDataCollectorService) {        
        this.gameStepResultService = gameStepResultService;
        this.dicesGameExecutorService = dicesGameExecutorService;
        this.dicesGameDataCollectorService = dicesGameDataCollectorService;
    }

    @GetMapping("/game-step-result")
    public List<GameStepResultDTO> getGameStepResults() {
        String sm = "getGameStepResults";
        LkdGenericLogger.logGenericInfo(sm + "-start-method");
        try {
            final List<GameStepResultDTO> objects =  this.gameStepResultService.findAll();
            LkdGenericLogger.logGenericInfo(sm + "method-end");
            return objects;
        } catch (Exception ex) {
            LkdGenericLogger.logGenericException(ex, sm + "-exception-occ");
            throw ex;
        }
    }

    @PostMapping("/game-step-result")
    public void addGameStepResult(@RequestBody GameStepResultDTO gameStepResultDTO) {
        String sm = "addGameStepResult";
        LkdGenericLogger.logGenericInfo(sm + "-start-method");
        try {
            gameStepResultDTO.setId(null);
            this.gameStepResultService.createCrud(gameStepResultDTO) ;
        } catch (Exception ex) {
            LkdGenericLogger.logGenericException(ex, sm + "-exception-occ");
            throw ex;
        }
    }
    
    @PostMapping("/game-step-result-generic-filter")
    public List<GameStepResultDTO> getObjectsByFilter(@RequestBody GameGenericFilterDTO filter) {
        String sm = "getObjectsByFilter";
        LkdGenericLogger.logGenericInfo(sm + "-start-method");
        try {
            final List<GameStepResultDTO> objects =  this.gameStepResultService.findByGenericFilter(filter);
            LkdGenericLogger.logGenericInfo(sm + "-end-method");
            return objects;
        } catch (Exception ex) {
            LkdGenericLogger.logGenericException(ex, sm + "-exception-occ");
            throw ex;
        }
    }
    
    @PostMapping("/game-step-result-create-result")
    public List<GameStepResultDTO> createResults(@RequestBody GameStepResultDTO gameStepResultDTO) {
        String sm = "createResults";
        LkdGenericLogger.logGenericInfo(sm + "-start-method");
        try {
            final List<GameStepResultDTO> objects = new ArrayList<>();
            if(gameStepResultDTO == null) {
                return objects;
            }
            if(gameStepResultDTO.getId() == null) {
                return objects;
            }
            this.dicesGameExecutorService.executeDicesGame(gameStepResultDTO.getId());
            return objects;
        } catch (Exception ex) {
            LkdGenericLogger.logGenericException(ex, sm + "-exception-occ");
            throw ex;
        }

    }
    
    @PostMapping("/game-step-result-collect")
    public List<GameStepResultDTO> collectResults(@RequestBody GameStepResultDTO gameStepResultDTO) {
        String sm = "collectResults";
        LkdGenericLogger.logGenericInfo(sm + "-start-method");
        try {
            final List<GameStepResultDTO> objects = new ArrayList<>();
            if(gameStepResultDTO == null) {
                return objects;
            }
            if(gameStepResultDTO.getId() == null) {
                return objects;
            }
            this.dicesGameDataCollectorService.executeDicesGameCollector(gameStepResultDTO.getId());
            return objects;
        } catch (Exception ex) {
            LkdGenericLogger.logGenericException(ex, sm + "-exception-occ");
            throw ex;
        }

    }
    
}
