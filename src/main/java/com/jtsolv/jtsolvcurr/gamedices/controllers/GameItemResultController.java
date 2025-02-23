package com.jtsolv.jtsolvcurr.gamedices.controllers;

import com.jtsolv.jtsolvcurr.gamedices.dto.GameItemResultDTO;
import com.jtsolv.jtsolvcurr.gamedices.service.admin.GameItemResultService;
import com.jtsolv.jtsolvcurr.logging.JTSolvGenericLogger;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
@CrossOrigin

public class GameItemResultController {

private final GameItemResultService gameItemResultService;
	
    public GameItemResultController(
    		GameItemResultService gameItemResultService) {        
        this.gameItemResultService = gameItemResultService;
    }

    @GetMapping("/game-item-result")
    public List<GameItemResultDTO> getGameItemResults() {

        String sm = "getGameItemResults";
        JTSolvGenericLogger.logGenericInfo(sm + "-start");
        try {
            final List<GameItemResultDTO> objects =  this.gameItemResultService.findAll();
            JTSolvGenericLogger.logGenericInfo(sm + "addGame-end");
            return objects;
        } catch (Exception ex) {
            JTSolvGenericLogger.logGenericException(ex, sm + "-exception");
            throw ex;
        }
    }

    @PostMapping("/game-item-result")
    void addGameItemResult(@RequestBody GameItemResultDTO gameItemResultDTO) {

        String sm = "getGameItemResults-";
        JTSolvGenericLogger.logGenericInfo(sm + "-method-start");
        try {
            gameItemResultDTO.setId(null);
            this.gameItemResultService.createCrud(gameItemResultDTO) ;
        } catch (Exception ex) {
            JTSolvGenericLogger.logGenericException(ex, sm + "method--exception");
            throw ex;
        }
        JTSolvGenericLogger.logGenericInfo(sm + "method-end");

    }
}
