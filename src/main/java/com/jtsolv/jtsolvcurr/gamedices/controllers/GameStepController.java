package com.jtsolv.jtsolvcurr.gamedices.controllers;

import com.jtsolv.jtsolvcurr.gamedices.dto.GameStepDTO;
import com.jtsolv.jtsolvcurr.gamedices.service.admin.GameStepService;
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
        final List<GameStepDTO> objects =  this.gameStepService.findAll();
        return objects;
    }

    @PostMapping("/game-step")
    void addGameStep(@RequestBody GameStepDTO gameStepDTO) {
    	this.gameStepService.createCrud(gameStepDTO) ;       
    }
}
