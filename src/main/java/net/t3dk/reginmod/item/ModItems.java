package net.t3dk.reginmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.t3dk.reginmod.ReginMod;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ReginMod.MOD_ID);

    public static final RegistryObject<Item> FIRE_BRICK = ITEMS.register("fire_brick",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.REGIN_TAB)));
    public static final RegistryObject<Item> FIRE_CLAY = ITEMS.register("fire_clay",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.REGIN_TAB)));
    public static final RegistryObject<Item> INVAR_INGOT = ITEMS.register("invar_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.REGIN_TAB)));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
