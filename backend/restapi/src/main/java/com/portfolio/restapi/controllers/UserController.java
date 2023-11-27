package com.portfolio.restapi.controllers;

import com.portfolio.restapi.entities.Trade;
import com.portfolio.restapi.entities.User;
import com.portfolio.restapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling user-related HTTP endpoints.
 */
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * Retrieves a list of all users.
     *
     * @return A list containing all available users.
     */
    @GetMapping
    public List<User> getUsers(){

        return userService.getAllUsers();
    }

    /**
     * Retrieves a list of trades associated with a user by their ID.
     *
     * @param id The ID of the user.
     * @return A list of trades associated with the user.
     */
    @GetMapping("/{id}/trades")
    public List<Trade> getTradesById(@PathVariable Integer id){
        User user = userService.getUserById(id);
        return user.getTrades();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    /**
     * Adds a new user.
     *
     * @param user The user to be added.
     * @return The added user.
     */
    @PostMapping
    public User postUser(@RequestBody User user){

        return userService.addUser(user);
    }

    /**
     * Adds a trade to a user's trade history.
     *
     * @param id The ID of the user to whom the trade will be added.
     * @param trade The trade to be added to the user's trade history.
     * @return The updated user with the added trade.
     */
    @PostMapping("/add-trades/{id}")
    public User postTrade(@PathVariable Integer id, @RequestBody Trade trade){
        return userService.addTrade(id, trade);
    }

    /**
     * Updates a user by their ID.
     *
     * @param id The ID of the user to be updated.
     * @param user The updated user information.
     * @return The updated user.
     */
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    /**
     * Partially updates a user by their ID.
     *
     * @param id The ID of the user to be partially updated.
     * @param partialUser The partially updated user information.
     * @return The partially updated user.
     */
    @PatchMapping("/{id}")
    public User partialUpdateUser(@PathVariable Integer id, @RequestBody User partialUser) {
        return userService.partialUpdateUser(id, partialUser);
    }

    /**
     * Deletes a user by their ID.
     *
     * @param id The ID of the user to be deleted.
     */
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }

}

