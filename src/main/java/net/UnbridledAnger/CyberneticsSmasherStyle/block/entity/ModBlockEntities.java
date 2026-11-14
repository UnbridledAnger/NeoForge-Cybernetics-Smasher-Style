package net.UnbridledAnger.CyberneticsSmasherStyle.block.entity;

import net.UnbridledAnger.CyberneticsSmasherStyle.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;

import static com.perigrine3.createcybernetics.block.entity.ModBlockEntities.BLOCK_ENTITIES;


public class ModBlockEntities {
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
}
