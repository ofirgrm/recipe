package com.example.demo.repositories;

import com.example.demo.domain.Notes;
import com.example.demo.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

public interface NotesRepository extends CrudRepository<Notes, Long> {


}
