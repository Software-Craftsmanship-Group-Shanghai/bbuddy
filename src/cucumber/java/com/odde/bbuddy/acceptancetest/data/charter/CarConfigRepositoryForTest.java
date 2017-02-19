package com.odde.bbuddy.acceptancetest.data.charter;

import com.odde.bbuddy.charter.repo.CarConfig;
import org.springframework.data.repository.Repository;

public interface CarConfigRepositoryForTest extends Repository<CarConfig, Long> {

    void save(CarConfig carConfig);
    void deleteAll();

}
