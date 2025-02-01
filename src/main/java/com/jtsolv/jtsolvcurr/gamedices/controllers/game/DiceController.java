package com.jtsolv.jtsolvcurr.gamedices.controllers.game;

import com.jtsolv.jtsolvcurr.gamedices.model.entity.DiceEntity;
import com.jtsolv.jtsolvcurr.gamedices.repository.entity.DiceRepositoryEntity;
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
        return (List<DiceEntity>) diceRepository.findAll();
    }

    @PostMapping("/dice")
    void addDice(@RequestBody DiceEntity dice) {
        diceRepository.save(dice);
    }
}
