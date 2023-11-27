package com.portfolio.restapi.repositories;

import com.portfolio.restapi.entities.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The repository interface for managing User entities.
 * This interface extends JpaRepository to provide basic CRUD operations and additional querying capabilities.
 *
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
@Repository
public interface TradeRepository extends JpaRepository<Trade, Integer> {

}
