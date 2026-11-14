
package net.UnbridledAnger.CyberneticsSmasherStyle.block.entity;

import net.UnbridledAnger.CyberneticsSmasherStyle.SmasherStyle;
import net.UnbridledAnger.CyberneticsSmasherStyle.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(
                    Registries.BLOCK_ENTITY_TYPE,
                    SmasherStyle.MODID
            );

    public static final DeferredHolder<
            BlockEntityType<?>,
            BlockEntityType<AdvancedRobosurgeonBlockEntity>
            > ADVANCED_ROBOSURGEON_BLOCKENTITY =
            BLOCK_ENTITIES.register(
                    "advanced_robosurgeon_blockentity",
                    () -> BlockEntityType.Builder.of(
                            AdvancedRobosurgeonBlockEntity::new,
                            ModBlocks.ADVANCEDROBOSURGEON.get()
                    ).build(null)
            );

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
