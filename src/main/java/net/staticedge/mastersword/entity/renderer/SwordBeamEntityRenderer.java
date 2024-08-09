package net.staticedge.mastersword.entity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import net.staticedge.mastersword.MasterSword;
import net.staticedge.mastersword.entity.entitytype.SwordBeamEntity;
import net.staticedge.mastersword.entity.model.SwordBeamEntityModel;
import org.jetbrains.annotations.NotNull;

@Environment(EnvType.CLIENT)
public class SwordBeamEntityRenderer extends EntityRenderer<SwordBeamEntity> {

    private final SwordBeamEntityModel<SwordBeamEntity> entityModel;

    public SwordBeamEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        this.entityModel = new SwordBeamEntityModel<>(ctx.getPart(SwordBeamEntityModel.LAYER_LOCATION));
    }

    @Override
    public void render(@NotNull SwordBeamEntity swordBeam, float yaw, float tickDelta, @NotNull MatrixStack matrices, @NotNull VertexConsumerProvider vertexConsumers, int light) {
        super.render(swordBeam, yaw, tickDelta, matrices, vertexConsumers, light);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(swordBeam.getYaw()));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(swordBeam.getPitch()));
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(this.entityModel.getLayer(getTexture(swordBeam)));
        this.entityModel.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.5f, 1.0f);
    }

    @Override
    public Identifier getTexture(SwordBeamEntity swordBeam) {
        return new Identifier(MasterSword.MOD_ID, "textures/entity/sword_beam.png");
    }
}
