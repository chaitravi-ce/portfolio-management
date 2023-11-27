package com.portfolio.restapi.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

/**
 * Represents a user entity in a financial application.
 * Each User object encapsulates information about a user, including username, name, and their associated trade history.
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String name;

    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private List<Trade> trades;

    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private List<Stock> stocks;

    /**
     * Default constructor for creating a User instance.
     */
    public User(){}

    /**
     * Parameterized constructor to create a User instance.
     *
     * @param username The username of the user.
     * @param name The name of the user.
     */
    public User(String username, String name) {
        this.username = username;
        this.name = name;
    }

    /**
     * Gets the unique identifier of the user.
     *
     * @return The user's unique identifier.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the user.
     *
     * @param id The user's unique identifier.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the username of the user.
     *
     * @return The username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username The username of the user.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the name of the user.
     *
     * @return The name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     *
     * @param name The name of the user.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the list of trade history associated with the user.
     *
     * @return The list of trade history associated with the user.
     */
    public List<Trade> getTrades(){
        return trades;
    }

    public List<Stock> getStocks(){
        return stocks;
    }

    /**
     * Sets the list of trade history associated with the user.
     *
     * @param trades The list of trade history associated with the user.
     */
    public void setTrades(List<Trade> trades) {
        this.trades = trades;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    /**
     * Adds a trade to the user's trade history.
     *
     * @param trade The trade to be added to the user's trade history.
     */
    public void addUserTrade(Trade trade){
        trades.add(trade);
    }

    public void addUserStock(Stock stock){
        stocks.add(stock);
    }

    /**
     * Checks whether this user is equal to another object.
     *
     * @param o The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    /**
     * Generates the hash code for this user.
     *
     * @return The hash code for this user.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

