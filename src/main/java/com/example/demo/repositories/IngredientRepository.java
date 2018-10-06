package com.example.demo.repositories;

import com.example.demo.domain.Ingredient;
import com.example.demo.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {



}
