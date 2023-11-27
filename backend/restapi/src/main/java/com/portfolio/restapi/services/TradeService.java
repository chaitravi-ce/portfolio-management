package com.portfolio.restapi.services;

import com.portfolio.restapi.entities.Stock;
import com.portfolio.restapi.entities.Trade;
import com.portfolio.restapi.entities.User;
import com.portfolio.restapi.repositories.StockRepository;
import com.portfolio.restapi.repositories.TradeRepository;
import com.portfolio.restapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Service class for managing trade-related operations.
 */
@Service
public class TradeService {

    @Autowired
    private TradeRepository tradeRepository;
    @Autowired
    private StockRepository stockRepository;

    /**
     * Retrieves a list of all trades.
     *
     * @return A list containing all available trades.
     */
    public List<Trade> getAllTrades(){
        return tradeRepository.findAll();
    }

    /**
     * Adds a new trade.
     *
     * @param trade The trade to be added.
     * @return The added trade.
     */
    public Trade addTrade(Trade trade){

        String stockTicker = trade.getStockTicker();
        int tradeStatucCode = 0;
        Optional<Stock> existingStockOptional = stockRepository.findByStockTicker(stockTicker);

        if(existingStockOptional.isPresent()){
            Stock existingStock = existingStockOptional.get();

            String status = trade.getBuyOrSell();
            double tradePrice = trade.getStockPrice();
            Integer tradeVolume = trade.getVolume();

            double stockPrice = existingStock.getStockPrice();
            Integer stockVolume = existingStock.getVolume();

            if(Objects.equals(status, "BUY")){
                int totalVolume = tradeVolume + stockVolume;
                double totalPrice = (tradePrice*tradeVolume + stockPrice*stockVolume)/totalVolume;

                existingStock.setVolume(totalVolume);
                existingStock.setStockPrice(totalPrice);
                existingStock.setValue(totalVolume*totalPrice);
                tradeStatucCode = 1;
            }else{
                int totalVolume = stockVolume - tradeVolume;

                if(totalVolume == 0){
                    stockRepository.delete(existingStock);
                    tradeStatucCode = 1;
                } else if (totalVolume < 0){
                    tradeStatucCode = 2;
                }else{
                    existingStock.setVolume(totalVolume);
                    existingStock.setValue(totalVolume*stockPrice);
                    tradeStatucCode = 1;
                }
            }

        }else{
            Stock newStock = new Stock();
            newStock.setStockTicker(trade.getStockTicker());
            newStock.setStockPrice(trade.getStockPrice());
            newStock.setVolume(trade.getVolume());
            newStock.setValue(trade.getVolume()* trade.getStockPrice());
            tradeStatucCode = 1;
            stockRepository.save(newStock);
        }
        trade.setStatusCode(tradeStatucCode);
        return tradeRepository.save(trade);
    }

    /**
     * Retrieves a trade by its ID.
     *
     * @param id The ID of the trade to retrieve.
     * @return The trade with the specified ID.
     */
    public Trade getTradeById(Integer id){
        return tradeRepository.findById(id).get();
    }

    /**
     * Updates a trade by its ID.
     *
     * @param id The ID of the trade to be updated.
     * @param trade The updated trade information.
     * @return The updated trade.
     */
    public Trade updateTrade(Integer id, Trade trade){
        Trade updateTrade = tradeRepository.findById(id).get();

        updateTrade.setStockTicker(trade.getStockTicker());
        updateTrade.setStockPrice(trade.getStockPrice());
        updateTrade.setVolume(trade.getVolume());
        updateTrade.setBuyOrSell(trade.getBuyOrSell());
        updateTrade.setStatusCode(trade.getStatusCode());

        return tradeRepository.save(updateTrade);
    }

    /**
     * Partially updates a trade by its ID.
     *
     * @param id The ID of the trade to be partially updated.
     * @param partialTrade The partially updated trade information.
     * @return The partially updated trade.
     */
    public Trade partialUpdateTrade(Integer id, Trade partialTrade) {
        Trade tradeToUpdate = tradeRepository.findById(id).get();

        if (partialTrade.getStockTicker() != null) {
            tradeToUpdate.setStockTicker(partialTrade.getStockTicker());
        }
        if (partialTrade.getStockPrice() != 0) {
            tradeToUpdate.setStockPrice(partialTrade.getStockPrice());
        }
        if (partialTrade.getVolume() != null) {
            tradeToUpdate.setVolume(partialTrade.getVolume());
        }
        if (partialTrade.getBuyOrSell() != null) {
            tradeToUpdate.setBuyOrSell(partialTrade.getBuyOrSell());
        }
        if (partialTrade.getStatusCode() != 0) {
            tradeToUpdate.setStatusCode(partialTrade.getStatusCode());
        }

        // Apply the partial updates to other fields as needed

        return tradeRepository.save(tradeToUpdate);

    }


}
