package com.odde.bbuddy.charter.domain;

import com.odde.bbuddy.charter.repo.CarConfig;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface CarConfigRepository extends Repository<CarConfig, Long> {

    List<CarConfig> findAll();
}
