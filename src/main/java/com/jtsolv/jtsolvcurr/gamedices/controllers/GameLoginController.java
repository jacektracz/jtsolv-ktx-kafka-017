package com.jtsolv.jtsolvcurr.gamedices.controllers;

import com.jtsolv.jtsolvcurr.gamedices.dto.GameLoginDTO;
import com.jtsolv.jtsolvcurr.gamedices.service.admin.GameLoginService;
import com.jtsolv.jtsolvcurr.logging.JTSolvGenericLogger;
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
        JTSolvGenericLogger.logGenericInfo(sm + "-method-start");
        try {
            List<GameLoginDTO> result = this.gameLoginService.findAll();
            JTSolvGenericLogger.logGenericInfo(sm + "method-end");
            return result;
        } catch (Exception ex) {
            JTSolvGenericLogger.logGenericException(ex, sm + "method--exception");
            throw ex;
        }

    }

    @PostMapping("/game-login-entity")
    public void addGameLogin(@RequestBody GameLoginDTO gameLogin) {

        String sm = "addGameLogin";
        JTSolvGenericLogger.logGenericInfo(sm + "-start-method");
        try {
            gameLogin.setId(null);
            this.gameLoginService.create(gameLogin);
        } catch (Exception ex) {
            JTSolvGenericLogger.logGenericException(ex, sm + "-exception-occ");
            throw ex;
        }
        JTSolvGenericLogger.logGenericInfo(sm + "-end-method");
    }
    
    @PostMapping("/game-login")
    public void addGameLoginCrud(@RequestBody GameLoginDTO gameLogin) {
        String sm = "addGameLoginCrud";
        JTSolvGenericLogger.logGenericInfo(sm + "-start-method");
        try {
            gameLogin.setId(null);
            this.gameLoginService.createCrud(gameLogin);
        } catch (Exception ex) {
            JTSolvGenericLogger.logGenericException(ex, sm + "-exception-occ");
            throw ex;
        }
        JTSolvGenericLogger.logGenericInfo(sm + "-end-method");
    }
    
}
