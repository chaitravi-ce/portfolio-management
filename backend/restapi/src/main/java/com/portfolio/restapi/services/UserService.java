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
import java.text.DecimalFormat;

/**
 * Service class for managing user-related operations.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TradeRepository tradeRepository;

    @Autowired
    private StockRepository stockRepository;

    /**
     * Retrieves a list of all users.
     *
     * @return A list containing all available users.
     */
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    /**
     * Adds a new user.
     *
     * @param user The user to be added.
     * @return The added user.
     */
    public User addUser(User user){
        return userRepository.save(user);
    }

    /**
     * Deletes a user by its ID.
     *
     * @param id The ID of the user to be deleted.
     */
    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }

    /**
     * Retrieves a user by its ID.
     *
     * @param id The ID of the user to retrieve.
     * @return The user with the specified ID.
     */
    public User getUserById(Integer id){
        return userRepository.findById(id).get();
    }

    /**
     * Adds a trade to a user's trade history.
     *
     * @param id The ID of the user to whom the trade will be added.
     * @param trade The trade to be added to the user's trade history.
     * @return The updated user with the added trade.
     */
    public User addTrade(Integer id, Trade trade){
        User user = userRepository.findById(id).get();

        List<Stock> stocks = user.getStocks();
        String stockTicker = trade.getStockTicker();

        Stock foundStock = null;
        for (Stock stock : stocks) {
            if (stock.getStockTicker().equals(stockTicker)) {
                foundStock = stock;
                break;
            }
        }

        int tradeStatucCode = 0;
//        Optional<Stock> existingStockOptional = stockRepository.findByStockTicker(stockTicker);

        if(foundStock!=null){
            Stock existingStock = foundStock;

            String status = trade.getBuyOrSell();
            double tradePrice = trade.getStockPrice();
            Integer tradeVolume = trade.getVolume();

            double stockPrice = existingStock.getStockPrice();
            Integer stockVolume = existingStock.getVolume();
            DecimalFormat df = new DecimalFormat("#.###");

            if(Objects.equals(status, "BUY")){
                int totalVolume = tradeVolume + stockVolume;
                double totalPrice = (tradePrice*tradeVolume + stockPrice*stockVolume)/totalVolume;

                existingStock.setVolume(totalVolume);
                existingStock.setStockPrice(totalPrice);
                existingStock.setValue(Double.parseDouble(df.format(totalPrice*totalVolume)));
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
            user.addUserStock(newStock);
            stockRepository.save(newStock);
        }
        trade.setStatusCode(tradeStatucCode);
        user.addUserTrade(trade);
        userRepository.save(user);

        return user;
    }

    /**
     * Updates a user's information.
     *
     * @param id The ID of the user to be updated.
     * @param updatedUser The updated user information.
     * @return The updated user.
     */
    public User updateUser(Integer id, User updatedUser) {
        User existingUser = userRepository.findById(id).get();
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setName(updatedUser.getName());
        return userRepository.save(existingUser);
    }

    /**
     * Partially updates a user's information.
     *
     * @param id The ID of the user to be partially updated.
     * @param partialUser The partially updated user information.
     * @return The partially updated user.
     */
    public User partialUpdateUser(Integer id, User partialUser) {
        User existingUser = userRepository.findById(id).get();

        if (partialUser.getUsername() != null) {
            existingUser.setUsername(partialUser.getUsername());
        }
        if (partialUser.getName() != null) {
            existingUser.setName(partialUser.getName());
        }

        return userRepository.save(existingUser);
    }
}
