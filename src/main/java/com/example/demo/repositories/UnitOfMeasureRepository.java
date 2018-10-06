package com.example.demo.repositories;

import com.example.demo.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByDescription(String description);

    default UnitOfMeasure get(String description){
        Optional<UnitOfMeasure> opt = findByDescription(description);
        if (opt.isPresent()){
            return opt.get();
        }
        throw new RuntimeException("Unsupported UOM");
    }


}
