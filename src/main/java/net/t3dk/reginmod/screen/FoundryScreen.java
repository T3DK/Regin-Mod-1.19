package net.t3dk.reginmod.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.t3dk.reginmod.ReginMod;

public class FoundryScreen extends AbstractContainerScreen<FoundryMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(ReginMod.MOD_ID,"textures/gui/foundry_gui.png");

    public FoundryScreen(FoundryMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
    }

    @Override
    protected void init() {
        super.init();
    }

    //Override the Screen method for getting the title and return null instead
    //currently doesnt work, need to figure out what to null that isnt this
//    @Override
//    public Component getTitle() {
//        return null;
//    }

    @Override
    protected void renderBg(PoseStack stack, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - (imageWidth + 7)) / 2;
        int y = (height - (imageHeight - 12)) / 2;

        //renders the texture
        this.blit(stack, x, y, 0, 0, (imageWidth + 7), (imageHeight - 12));

        renderProgressArrow(stack, x, y);
    }

    private void renderProgressArrow(PoseStack stack, int x, int y) {
        //are we crafting, if not, no need to render arrow
        if(menu.isCrafting()) {
            //Goes to the arrow position (x and y)
            //Draws the arrow (at pos 176 0 on the texturesheet
            //width is 8, progress determines how much of the arrow to draw
            blit(stack, x + 35, y + 9, 183, 50, 3, menu.getScaledProgress());
        }
    }

    @Override
    public void render(PoseStack stack, int mouseX, int mouseY, float delta) {
        renderBackground(stack);
        super.render(stack, mouseX, mouseY, delta);
        renderTooltip(stack, mouseX, mouseY);
    }

    @Override
    protected void renderLabels(PoseStack pPoseStack, int pMouseX, int pMouseY) {
        //Override method to remove labels
    }
}
