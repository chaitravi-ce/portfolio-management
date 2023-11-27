package com.portfolio.restapi.controller;
import com.portfolio.restapi.entities.Trade;
import com.portfolio.restapi.repositories.TradeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
public class TradeControllerTest {
    @Autowired
    private TestEntityManager manager;

    @Autowired
    private TradeRepository repo;


}
