package com.jtsolv.jtsolvcurr.gamedices.controllers.game;

import com.jtsolv.jtsolvcurr.gamedices.dto.LiveProductDTO;
import com.jtsolv.jtsolvcurr.gamedices.dto.LiveProductsDTO;
import com.jtsolv.jtsolvcurr.gamedices.service.admin.GameStepDefService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/game")
@CrossOrigin
public class StockController {

private final GameStepDefService gameStepDefService;
    
    public StockController(final GameStepDefService gameStepDefService) {
        this.gameStepDefService = gameStepDefService;
    }

    @GetMapping("/stocks")
    public LiveProductsDTO getStocks() {
    	LiveProductsDTO products = new LiveProductsDTO(); 
        return products;
    }
    
    @GetMapping("/products")
    public List<LiveProductDTO> getProducts() {
    	List<LiveProductDTO> products = new ArrayList<>(); 
        return products;
    }

    private LiveProductsDTO getProductsByStock() {
    	LiveProductsDTO products = new LiveProductsDTO(); 
        return products;
    	
    }
    
    private LiveProductsDTO getAllProducts() {
    	LiveProductsDTO products = new LiveProductsDTO();
    	
    	String s1="select count(*) from products";
    	
        return products;
    	
    }
    
    
}
