package net.staticedge.mastersword;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.mixin.event.lifecycle.LivingEntityMixin;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.staticedge.mastersword.entity.MasterSwordEntities;
import net.staticedge.mastersword.entity.model.SwordBeamEntityModel;
import net.staticedge.mastersword.entity.renderer.SwordBeamEntityRenderer;
import net.staticedge.mastersword.item.ModItems;



public class MasterSwordClient implements
ClientModInitializer {
    public static final Identifier TEXTURE = new
Identifier(MasterSword.MOD_ID, "textures/entity/lightscale_trident_effect.png");
    @Override
    public void onInitializeClient() {

        MasterSword.LOGGER.info("MasterSwordClient has started up!");
        MasterSwordClient.registerEntityModelLayers();
        MasterSwordClient.registerEntityRenderers();

        ModelPredicateProviderRegistry.register(ModItems.HYLIAN_SHIELD, new Identifier("blocking"),
                (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0f : 0.0f);

        ModelPredicateProviderRegistry.register(ModItems.LIGHTSCALE_TRIDENT, new Identifier("throwing"),
                (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0f : 0.0f);

        ModelPredicateProviderRegistry.register(ModItems.GREAT_EAGLE_BOW, new Identifier("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getActiveItem() != stack ? 0.0F : (float)(stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 20.0F;
            }
        });

        ModelPredicateProviderRegistry.register(
                ModItems.GREAT_EAGLE_BOW,
                new Identifier("pulling"),
                (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F
        );
    }

    public static void registerEntityModelLayers() {
        EntityModelLayerRegistry.registerModelLayer(SwordBeamEntityModel.LAYER_LOCATION, SwordBeamEntityModel::getTexturedModelData);
    }

    public static void registerEntityRenderers() {

        EntityRendererRegistry.register(MasterSwordEntities.SWORD_BEAM, SwordBeamEntityRenderer::new);
    }
}




