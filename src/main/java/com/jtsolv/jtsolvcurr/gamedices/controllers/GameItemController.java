package com.jtsolv.jtsolvcurr.gamedices.controllers;

import com.jtsolv.jtsolvcurr.gamedices.model.entity.GameItemEntity;
import com.jtsolv.jtsolvcurr.gamedices.repository.entity.GameItemRepositoryEntity;
import com.jtsolv.jtsolvcurr.logging.LkdGenericLogger;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
@CrossOrigin
public class GameItemController {

    private final GameItemRepositoryEntity gameItemRepository;

    public GameItemController(GameItemRepositoryEntity gameItemRepository) {
        this.gameItemRepository = gameItemRepository;
    }

    @GetMapping("/game-item")
    public List<GameItemEntity> getGameItems() {

        String sm = "getGameItems";
        LkdGenericLogger.logGenericInfo(sm + "-start");
        try {
            return (List<GameItemEntity>) gameItemRepository.findAll();
        } catch (Exception ex) {
            LkdGenericLogger.logGenericException(ex, sm + "-exception");
            throw ex;
        }
        //LkdGenericLogger.logGenericInfo(sm + "addGame-end");
    }

    @PostMapping("/game-item")
    void addGameItem(@RequestBody GameItemEntity gameItem) {
        String sm = "addGameItem";
        LkdGenericLogger.logGenericInfo(sm + "-start-method");
        try {
            gameItem.setId(null);
            gameItemRepository.save(gameItem);
        } catch (Exception ex) {
            LkdGenericLogger.logGenericException(ex, sm + "-exception-occ");
            throw ex;
        }
        LkdGenericLogger.logGenericInfo(sm + "-end-method");
    }
}
