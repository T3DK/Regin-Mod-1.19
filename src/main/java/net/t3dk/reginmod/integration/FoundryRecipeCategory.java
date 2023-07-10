package net.t3dk.reginmod.integration;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.t3dk.reginmod.ReginMod;
import net.t3dk.reginmod.block.ModBlocks;
import net.t3dk.reginmod.recipe.FoundryRecipe;

public class FoundryRecipeCategory implements IRecipeCategory<FoundryRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(ReginMod.MOD_ID, "metal_melting");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(ReginMod.MOD_ID, "textures/gui/foundry_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public FoundryRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 183, 47);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.FOUNDRY.get()));
    }

    @Override
    public RecipeType<FoundryRecipe> getRecipeType() {
        return JEIReginModPlugin.MELTING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Foundry");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, FoundryRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 11, 11).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 156, 11).addItemStack(recipe.getResultItem());
    }
}
