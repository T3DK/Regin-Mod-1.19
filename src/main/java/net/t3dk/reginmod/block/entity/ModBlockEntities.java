package net.t3dk.reginmod.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.t3dk.reginmod.ReginMod;
import net.t3dk.reginmod.block.ModBlocks;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ReginMod.MOD_ID);

    //Tells it which block belongs to which block entity, and registers that block entity
    public static final RegistryObject<BlockEntityType<FoundryBlockEntity>> FOUNDRY =
            BLOCK_ENTITIES.register("foundry", () ->
                    BlockEntityType.Builder.of(FoundryBlockEntity::new,
                            ModBlocks.FOUNDRY.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
