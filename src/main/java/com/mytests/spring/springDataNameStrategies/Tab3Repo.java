package com.mytests.spring.springDataNameStrategies;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * *
 * <p>Created by irina on 9/14/2022.</p>
 * <p>Project: spring-boot-jpa-projection</p>
 * *
 */
public interface Tab3Repo extends CrudRepository<Tab3Entity,Long> {

    Optional<Tab3Entity> findByUserId(long userId);

    List<Tab3Entity> findByCarIdContaining(String carId);
}
