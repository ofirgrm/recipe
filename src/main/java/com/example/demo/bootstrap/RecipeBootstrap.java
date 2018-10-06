package com.example.demo.bootstrap;

import com.example.demo.domain.*;
import com.example.demo.repositories.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Slf4j
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private UnitOfMeasureRepository unitOfMeasureRepository;
    private RecipeRepository recipeRepository;
    private CategoryRepository categoryRepository;
    private IngredientRepository ingredientRepository;
    private NotesRepository notesRepository;

    public RecipeBootstrap(
            UnitOfMeasureRepository unitOfMeasureRepository,
            RecipeRepository recipeRepository,
            CategoryRepository categoryRepository,
            IngredientRepository ingredientRepository,
            NotesRepository notesRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.ingredientRepository = ingredientRepository;
        this.notesRepository = notesRepository;
    }

    private void initData() {
        perfectGuacamoleRecipe();
    }

    private void perfectGuacamoleRecipe() {
        UnitOfMeasure teaspoon = this.unitOfMeasureRepository.get("Teaspoon");
        UnitOfMeasure tablespoon = this.unitOfMeasureRepository.get("Tablespoon");
        UnitOfMeasure cup = this.unitOfMeasureRepository.get("Cup");
        UnitOfMeasure pinch = this.unitOfMeasureRepository.get("Pinch");
        UnitOfMeasure ounce = this.unitOfMeasureRepository.get("Ounce");
        UnitOfMeasure unit = this.unitOfMeasureRepository.get("Unit");
        UnitOfMeasure dash = this.unitOfMeasureRepository.get("Dash");
        UnitOfMeasure pint = this.unitOfMeasureRepository.get("Pint");

        Recipe perfectGuacamole = new Recipe();
        perfectGuacamole.setCookTime(10);
        perfectGuacamole.setDescription("Perfect Guacamole");

        perfectGuacamole.setDirections(
                "1. Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl." +
                        "\n" +
                        "2. Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)" +
                        "\n" +
                        "3. Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                        "\n" +
                        "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                        "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste." +
                        "\n" +
                        "4. Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                        "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving."
        );

        Notes notes = new Notes();
        notes.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries (see our Strawberry Guacamole).\n" +
                "\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "\n" +
                "For a deviled egg version with guacamole, try our Guacamole Deviled Eggs!");
        perfectGuacamole.setNotes(notes);

        perfectGuacamole.setServings(4);
        perfectGuacamole.setSource("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        perfectGuacamole.setDifficulty(Difficulty.MODERATE);

        Category mexican = this.categoryRepository.findByDescription("Mexican").get();
        perfectGuacamole.addCategory(mexican);

        perfectGuacamole.addIngredient(new Ingredient("Avocados", 2, unit));
        perfectGuacamole.addIngredient(new Ingredient("Avocados", 2, unit));
        perfectGuacamole.addIngredient(new Ingredient("Kosher salt", 0.5, teaspoon));
        perfectGuacamole.addIngredient(new Ingredient("Fresh lime juice or lemon juice", 2, tablespoon));
        perfectGuacamole.addIngredient(new Ingredient("Minced red onion or thinly sliced green onion", 2, tablespoon));
        perfectGuacamole.addIngredient(new Ingredient("Serrano chiles, stems and seeds removed, minced", 1, unit));
        perfectGuacamole.addIngredient(new Ingredient("Cilantro (leaves and tender stems), finely chopped", 2, tablespoon));
        perfectGuacamole.addIngredient(new Ingredient("Freshly grated black pepper", 1, dash));
        perfectGuacamole.addIngredient(new Ingredient("Ripe tomato, seeds and pulp removed, chopped", 0.5, unit));

        this.recipeRepository.save(perfectGuacamole);
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.debug("Loading Bootstrap data...");
        initData();
    }
}
