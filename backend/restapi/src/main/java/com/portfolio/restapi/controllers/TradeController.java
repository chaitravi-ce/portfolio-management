package com.portfolio.restapi.controllers;

import com.portfolio.restapi.entities.Trade;
import com.portfolio.restapi.services.TradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling trade-related HTTP endpoints.
 */
//@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
@RestController
@RequestMapping("/trades")
public class TradeController {

    Logger logger = LoggerFactory.getLogger(TradeController.class);

    @Autowired
    TradeService tradeservice;

    /**
     * Retrieves a list of all trades.
     *
     * @return A list containing all available trades.
     */
    @GetMapping
    public List<Trade> showTradeList() {
        logger.info("Inside showTradeList method called by GET request to /trades endpoint.");
        return tradeservice.getAllTrades();
    }

    /**
     * Adds a new trade.
     *
     * @param t The trade to be added.
     * @return A list of trades after adding the new trade.
     */
    @PostMapping
    public List<Trade> postTrade(@RequestBody Trade t){
        tradeservice.addTrade(t);
        return tradeservice.getAllTrades();
    }

    /**
     * Updates a trade by its ID.
     *
     * @param id The ID of the trade to be updated.
     * @param t The updated trade information.
     * @return The updated trade.
     */
    @PutMapping("/{id}")
    public Trade updateTrade(@PathVariable Integer id, @RequestBody Trade t){
        return tradeservice.updateTrade(id, t);
    }

    /**
     * Partially updates a trade by its ID.
     *
     * @param id The ID of the trade to be partially updated.
     * @param partialTrade The partially updated trade information.
     * @return The partially updated trade.
     */
    @PatchMapping("/{id}")
    public Trade partialUpdateTrade(@PathVariable Integer id, @RequestBody Trade partialTrade){
        return tradeservice.partialUpdateTrade(id, partialTrade);
    }
}