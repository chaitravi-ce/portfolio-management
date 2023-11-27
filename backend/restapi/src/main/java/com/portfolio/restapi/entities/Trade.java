package com.portfolio.restapi.entities;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

/**
 * Represents a trade entity for a financial application.
 * Each Trade object encapsulates information about a trade transaction, including stock details,
 * volume, buy or sell action, and status code.
 */
@Entity
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String stockTicker; //will check in test case for null value
    private double stockPrice; //will check in test case for negative value or 0
    private Integer volume; //will check in test case for negative value or 0

    private String buyOrSell;
    private int statusCode;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    /**
     * Default constructor for creating a Trade instance.
     */
    public Trade(){}

    /**
     * Parameterized constructor to create a Trade instance.
     *
     * @param stockTicker The ticker symbol of the stock associated with the trade.
     * @param stockPrice The price of the stock at the time of the trade.
     * @param volume The volume of stocks traded in this transaction.
     * @param buyOrSell Indicates whether the trade is a buy or sell action.
     * @param statusCode The status code representing the outcome of the trade.
     */

    public Trade(String stockTicker, double stockPrice, Integer volume, String buyOrSell, int statusCode) {
        this.stockTicker = stockTicker;
        this.stockPrice = stockPrice;
        this.volume = volume;
        this.buyOrSell = buyOrSell;
        this.statusCode = statusCode;
        if(stockTicker==null){
            throw new IllegalArgumentException("Stockticker can't be null");
        }
        if(stockPrice<=0){
            throw new IllegalArgumentException("StockPrice cannot have zero or negative value");
        }
        if(volume<=0){
            throw new IllegalArgumentException("Volume can't be null or zero");
        }
        if (!buyOrSell.equals("Buy") && !buyOrSell.equals("Sell")) {
            throw new IllegalArgumentException("Input must be either 'Buy' or 'Sell'");
        }
    }

    /**
     * Sets the timestamp to the current date and time when the entity is being persisted.
     */
    @PrePersist
    protected void onCreate() {
        timestamp = new Date();
    }

    /**
     * Gets the timestamp when the trade entity was created.
     *
     * @return The timestamp when the trade entity was created.
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the timestamp
     *
     * @param timestamp to be set
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Gets the unique identifier of the trade.
     *
     * @return The trade's unique identifier.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the trade.
     *
     * @param id The trade's unique identifier.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the ticker symbol of the stock associated with the trade.
     *
     * @return The stock's ticker symbol.
     */
    public String getStockTicker() {
        return stockTicker;
    }

    /**
     * Sets the ticker symbol of the stock associated with the trade.
     *
     * @param stockTicker The stock's ticker symbol.
     */
    public void setStockTicker(String stockTicker) {
        this.stockTicker = stockTicker;
    }

    /**
     * Gets the price of the stock at the time of the trade.
     *
     * @return The stock's price at the time of the trade.
     */
    public double getStockPrice() {
        return stockPrice;
    }

    /**
     * Sets the price of the stock at the time of the trade.
     *
     * @param stockPrice The stock's price at the time of the trade.
     */
    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
    }

    /**
     * Gets the volume of stocks traded in this transaction.
     *
     * @return The volume of stocks traded.
     */
    public Integer getVolume() {
        return volume;
    }

    /**
     * Sets the volume of stocks traded in this transaction.
     *
     * @param volume The volume of stocks traded.
     */
    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    /**
     * Gets whether the trade is a buy or sell action.
     *
     * @return A string indicating whether the trade is a buy or sell action.
     */
    public String getBuyOrSell() {
        return buyOrSell;
    }

    /**
     * Sets whether the trade is a buy or sell action.
     *
     * @param buyOrSell A string indicating whether the trade is a buy or sell action.
     */
    public void setBuyOrSell(String buyOrSell) {
        this.buyOrSell = buyOrSell;
    }

    /**
     * Gets the status code representing the outcome of the trade.
     *
     * @return The status code of the trade outcome.
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the status code representing the outcome of the trade.
     *
     * @param statusCode The status code of the trade outcome.
     */
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    //exception



}
