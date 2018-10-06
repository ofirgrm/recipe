package com.example.demo.controllers;

import com.example.demo.domain.Recipe;
import com.example.demo.services.RecipeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@Slf4j
public class IndexController {

    private RecipeServiceImpl recipeLoadService;

    public IndexController(RecipeServiceImpl recipeLoadService) {
        this.recipeLoadService = recipeLoadService;
    }

    // return the index.html for thymeleaf
    @RequestMapping({"", "/", "index"})
    public String getIndexPage(Model model) {
        log.debug("Getting index page ");
        Set<Recipe> recipes = this.recipeLoadService.getRecipes();
        model.addAttribute("recipes", recipes);
        return "index";
    }

}
