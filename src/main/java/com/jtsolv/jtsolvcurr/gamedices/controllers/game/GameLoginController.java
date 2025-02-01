package com.jtsolv.jtsolvcurr.gamedices.controllers.game;

import com.jtsolv.jtsolvcurr.gamedices.dto.GameLoginDTO;
import com.jtsolv.jtsolvcurr.gamedices.service.admin.GameLoginService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
@CrossOrigin

public class GameLoginController {
    
    private final GameLoginService gameLoginService;
    public GameLoginController(final GameLoginService gameLoginService) {
        this.gameLoginService = gameLoginService;

    }

    @GetMapping("/game-login")
    public List<GameLoginDTO> getGameLogins() {
        List<GameLoginDTO> result = this.gameLoginService.findAll();
        return result;
    }

    @PostMapping("/game-login-entity")
    public void addGameLogin(@RequestBody GameLoginDTO gameLogin) {

    	this.gameLoginService.create(gameLogin);
    }
    
    @PostMapping("/game-login")
    public void addGameLoginCrud(@RequestBody GameLoginDTO gameLogin) {
    	this.gameLoginService.createCrud(gameLogin);
    }
    
}
