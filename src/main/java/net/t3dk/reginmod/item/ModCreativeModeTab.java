package net.t3dk.reginmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab REGIN_TAB = new CreativeModeTab("regintab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.FIRE_BRICK.get());
        }
    };
}
