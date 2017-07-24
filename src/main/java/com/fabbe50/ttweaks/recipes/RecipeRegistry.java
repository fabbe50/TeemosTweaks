package com.fabbe50.ttweaks.recipes;

import com.fabbe50.ttweaks.recipes.recipe.RecipesSmelting;

/**
 * Created by fabbe on 09/07/2017.
 */
public class RecipeRegistry {
    public static void init() {
        RecipesSmelting.addSmeltingRecipes();
    }
}
