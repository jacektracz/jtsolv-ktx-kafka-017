package com.jtsolv.jtsolvcurr.gamedices.controllers.game;

import com.jtsolv.jtsolvcurr.gamedices.dto.GameStepDefDTO;
import com.jtsolv.jtsolvcurr.gamedices.service.admin.GameStepDefService;
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
        List<GameStepDefDTO> result = this.gameStepDefService.findAll();
        return result;
    }

    @PostMapping("/game-step-def-disabled")
    public void addGameStepDef(@RequestBody GameStepDefDTO gameStepDef) {
    	this.gameStepDefService.create(gameStepDef);
    }
    
    @PostMapping("/game-step-def")
    public void addGameStepDefCrud(@RequestBody GameStepDefDTO gameStepDef) {
    	this.gameStepDefService.createCrud(gameStepDef);
    }
    
}
