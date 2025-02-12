package com.jtsolv.jtsolvcurr.gamedices.controllers;

import com.jtsolv.jtsolvcurr.gamedices.model.entity.DiceEntity;
import com.jtsolv.jtsolvcurr.gamedices.repository.entity.DiceRepositoryEntity;
import com.jtsolv.jtsolvcurr.logging.LkdGenericLogger;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
@CrossOrigin
public class DiceController {

    private final DiceRepositoryEntity diceRepository;

    public DiceController(DiceRepositoryEntity diceRepository) {
        this.diceRepository = diceRepository;
    }

    @GetMapping("/dice")
    public List<DiceEntity> getDices() {
        LkdGenericLogger.logGenericInfo("getDices");
        try {
            List<DiceEntity> lst = diceRepository.findAll();
            return lst;
        } catch (Exception ex) {
            LkdGenericLogger.logGenericException(ex,"getDices");
            throw ex;
        }
    }

    @PostMapping("/dice")
    void addDice(@RequestBody DiceEntity dice) {
        LkdGenericLogger.logGenericInfo("addDice--start");
        try {
            dice.setId(null);
            diceRepository.save(dice);
            LkdGenericLogger.logGenericInfo("addDice--end");
        } catch (Exception ex) {
            LkdGenericLogger.logGenericException(ex,"addDice");
            throw ex;
        }

    }
}
