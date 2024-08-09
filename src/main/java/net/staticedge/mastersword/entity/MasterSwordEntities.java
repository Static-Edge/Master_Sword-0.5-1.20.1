package net.staticedge.mastersword.entity;


import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;

import net.minecraft.entity.EntityDimensions;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.staticedge.mastersword.MasterSword;
import net.staticedge.mastersword.entity.entitytype.SwordBeamEntity;


public class MasterSwordEntities {

    public static final EntityType<SwordBeamEntity> SWORD_BEAM = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(MasterSword.MOD_ID, "sword_beam"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, SwordBeamEntity::new)
                    .dimensions(EntityDimensions.fixed(0.45f,0.2f))
                    .fireImmune()
                    .build()
    );

    public static void registerMasterSwordEntities() {
        MasterSword.LOGGER.info(" has registered its entities.");
    }
}
