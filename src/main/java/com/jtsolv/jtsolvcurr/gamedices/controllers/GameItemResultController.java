package com.jtsolv.jtsolvcurr.gamedices.controllers;

import com.jtsolv.jtsolvcurr.gamedices.dto.GameItemResultDTO;
import com.jtsolv.jtsolvcurr.gamedices.model.entity.GameItemEntity;
import com.jtsolv.jtsolvcurr.gamedices.service.admin.GameItemResultService;
import com.jtsolv.jtsolvcurr.logging.LkdGenericLogger;
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
        LkdGenericLogger.logGenericInfo(sm + "-start");
        try {
            final List<GameItemResultDTO> objects =  this.gameItemResultService.findAll();
            return objects;
        } catch (Exception ex) {
            LkdGenericLogger.logGenericException(ex, sm + "-exception");
            throw ex;
        }
        //LkdGenericLogger.logGenericInfo(sm + "addGame-end");

    }

    @PostMapping("/game-item-result")
    void addGameItemResult(@RequestBody GameItemResultDTO gameItemResultDTO) {

        String sm = "getGameItemResults-";
        LkdGenericLogger.logGenericInfo(sm + "-method-start");
        try {
            this.gameItemResultService.createCrud(gameItemResultDTO) ;
        } catch (Exception ex) {
            LkdGenericLogger.logGenericException(ex, sm + "method--exception");
            throw ex;
        }
        LkdGenericLogger.logGenericInfo(sm + "method-end");

    }
}
