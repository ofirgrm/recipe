package com.example.demo.services;

import com.example.demo.domain.Recipe;
import com.example.demo.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("I am a log");
        Set<Recipe> recipes = new HashSet<>();
        this.recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }

}
