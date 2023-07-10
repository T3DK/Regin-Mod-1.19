package net.t3dk.reginmod.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import net.t3dk.reginmod.ReginMod;
import net.t3dk.reginmod.recipe.FoundryRecipe;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIReginModPlugin implements IModPlugin {

    //Register all recipes
    public static RecipeType<FoundryRecipe> MELTING_TYPE =
            new RecipeType<>(FoundryRecipeCategory.UID, FoundryRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(ReginMod.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                FoundryRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    //Get all recipes
    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        List<FoundryRecipe> recipesMelting = rm.getAllRecipesFor(FoundryRecipe.Type.INSTANCE);
        registration.addRecipes(MELTING_TYPE, recipesMelting);
    }
}
