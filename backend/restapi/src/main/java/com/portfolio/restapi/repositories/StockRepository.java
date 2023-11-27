package com.portfolio.restapi.repositories;

import com.portfolio.restapi.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The repository interface for managing User entities.
 * This interface extends JpaRepository to provide basic CRUD operations and additional querying capabilities.
 *
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    boolean existsByStockTicker(String stockTicker);

    Optional<Stock> findByStockTicker(String name);

}