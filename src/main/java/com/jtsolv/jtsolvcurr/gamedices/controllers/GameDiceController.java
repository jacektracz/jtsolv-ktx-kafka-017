package com.jtsolv.jtsolvcurr.gamedices.controllers;

import com.jtsolv.jtsolvcurr.gamedices.model.entity.DiceEntity;
import com.jtsolv.jtsolvcurr.gamedices.repository.entity.DiceRepositoryEntity;
import com.jtsolv.jtsolvcurr.logging.JTSolvGenericLogger;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
@CrossOrigin
public class GameDiceController {

    private final DiceRepositoryEntity diceRepository;

    public GameDiceController(DiceRepositoryEntity diceRepository) {
        this.diceRepository = diceRepository;
    }

    @GetMapping("/dice")
    public List<DiceEntity> getDices() {
        JTSolvGenericLogger.logGenericInfo("getDices");
        try {
            List<DiceEntity> lst = diceRepository.findAll();
            return lst;
        } catch (Exception ex) {
            JTSolvGenericLogger.logGenericException(ex,"getDices");
            throw ex;
        }
    }

    @PostMapping("/dice")
    void addDice(@RequestBody DiceEntity dice) {
        JTSolvGenericLogger.logGenericInfo("addDice--start");
        try {
            dice.setId(null);
            diceRepository.save(dice);
            JTSolvGenericLogger.logGenericInfo("addDice--end");
        } catch (Exception ex) {
            JTSolvGenericLogger.logGenericException(ex,"addDice");
            throw ex;
        }

    }
}
