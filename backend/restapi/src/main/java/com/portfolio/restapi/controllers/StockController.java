package com.portfolio.restapi.controllers;

import com.portfolio.restapi.entities.Stock;
import com.portfolio.restapi.entities.Trade;
import com.portfolio.restapi.services.StockService;
import com.portfolio.restapi.services.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {
    @Autowired
    StockService stockService;

    @GetMapping
    public List<Stock> showTradeList() {
        return stockService.getAllStocks();
    }
}
