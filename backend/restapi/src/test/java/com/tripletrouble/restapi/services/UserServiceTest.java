package com.portfolio.restapi.services;

import com.portfolio.restapi.entities.User;
import com.portfolio.restapi.repositories.UserRepository;
import com.portfolio.restapi.repositories.TradeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = UserService.class)

public class UserServiceTest {

    @Autowired
    UserService service;

    @MockBean
    UserRepository mockRepo;
    @MockBean
    TradeRepository repo;


}
