package com.fabbe50.ttweaks.recipes.recipe;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by fabbe on 09/07/2017.
 */
public class RecipesSmelting {
    static int META_WILDCARD = Short.MAX_VALUE;

    public static void addSmeltingRecipes() {
        GameRegistry.addSmelting(new ItemStack(Items.ROTTEN_FLESH, 1, 0), new ItemStack(Items.LEATHER, 1, 0), 0.2f);
        GameRegistry.addSmelting(new ItemStack(Blocks.SANDSTONE, 1, META_WILDCARD), new ItemStack(Blocks.GLASS, 4, 0), 0.2f);
        GameRegistry.addSmelting(new ItemStack(Blocks.RED_SANDSTONE, 1, META_WILDCARD), new ItemStack(Blocks.GLASS, 4, 0), 0.2f);
        GameRegistry.addSmelting(new ItemStack(Blocks.SOUL_SAND, 1, 0), new ItemStack(Blocks.GLASS, 2, 0), 0.2f);
    }
}
