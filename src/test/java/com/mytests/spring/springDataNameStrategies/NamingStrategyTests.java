package com.mytests.spring.springDataNameStrategies;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class NamingStrategyTests {
   @Autowired Tab3Repo repo;
    @Test
    void testUserId() {
        Optional<Tab3Entity> byUserId = repo.findByUserId(0);
        System.out.println(byUserId.isPresent());
        assertNotNull(byUserId);
    }

    @Test
    void testCarId() {
        List<Tab3Entity> byCarId = repo.findByCarIdContaining("78");
        System.out.println(byCarId);
        assertNotNull(byCarId);
    }
}
