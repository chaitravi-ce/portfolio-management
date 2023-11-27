package com.portfolio.restapi.services;

import com.portfolio.restapi.entities.Stock;
import com.portfolio.restapi.entities.Trade;
import com.portfolio.restapi.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    StockRepository stockRepository;

    public List<Stock> getAllStocks(){

        return stockRepository.findAll();
    }
}
