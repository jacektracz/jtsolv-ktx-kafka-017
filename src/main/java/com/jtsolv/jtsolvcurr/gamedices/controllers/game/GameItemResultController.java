package com.jtsolv.jtsolvcurr.gamedices.controllers.game;

import com.jtsolv.jtsolvcurr.gamedices.dto.GameItemResultDTO;
import com.jtsolv.jtsolvcurr.gamedices.service.admin.GameItemResultService;
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
        final List<GameItemResultDTO> objects =  this.gameItemResultService.findAll();
        return objects;
    }

    @PostMapping("/game-item-result")
    void addGameItemResult(@RequestBody GameItemResultDTO gameItemResultDTO) {
    	this.gameItemResultService.createCrud(gameItemResultDTO) ;       
    }
}
