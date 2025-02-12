package com.jtsolv.jtsolvcurr.gamedices.controllers;

import com.jtsolv.jtsolvcurr.gamedices.model.entity.UserEntity;
import com.jtsolv.jtsolvcurr.gamedices.repository.entity.UserRepository;
import com.jtsolv.jtsolvcurr.logging.LkdGenericLogger;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {

        this.userRepository = userRepository;

    }

    @GetMapping("/users")
    public List<UserEntity> getUsers() {
        String sm = "getObjectsByFilter";
        LkdGenericLogger.logGenericInfo(sm + "-start-method");
        try {
            List<UserEntity> ue = userRepository.findAll();
            LkdGenericLogger.logGenericInfo(sm + "method-end");
            return ue;
        } catch (Exception ex) {
            LkdGenericLogger.logGenericException(ex, sm + "-exception-occ");
            throw ex;
        }

    }

    @PostMapping("/users")
    void addUser(@RequestBody UserEntity user) {
        String sm = "addUser";
        LkdGenericLogger.logGenericInfo(sm + "-start-method");
        try {
            user.setId(null);
            userRepository.save(user);
        } catch (Exception ex) {
            LkdGenericLogger.logGenericException(ex, sm + "-exception-occ");
            throw ex;
        }
    }
}
