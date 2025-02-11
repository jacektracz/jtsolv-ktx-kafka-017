package com.jtsolv.jtsolvcurr.gamedices.controllers;

import com.jtsolv.jtsolvcurr.gamedices.dto.GameLoginDTO;
import com.jtsolv.jtsolvcurr.gamedices.service.admin.GameLoginService;
import com.jtsolv.jtsolvcurr.logging.LkdGenericLogger;
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
        String sm = "getGameLogins-";
        LkdGenericLogger.logGenericInfo(sm + "-method-start");
        try {
            List<GameLoginDTO> result = this.gameLoginService.findAll();
            return result;
        } catch (Exception ex) {
            LkdGenericLogger.logGenericException(ex, sm + "method--exception");
            throw ex;
        }
        //LkdGenericLogger.logGenericInfo(sm + "method-end");

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
