package net.staticedge.mastersword.entity.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.staticedge.mastersword.MasterSword;
import net.staticedge.mastersword.entity.entitytype.SwordBeamEntity;
import org.jetbrains.annotations.NotNull;

@Environment(EnvType.CLIENT)
public class SwordBeamEntityModel<T extends SwordBeamEntity> extends EntityModel<SwordBeamEntity> {

    public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(new Identifier(MasterSword.MOD_ID, "sword_beam"), "main");

    private final ModelPart sword_beam_main;

    public SwordBeamEntityModel(@NotNull ModelPart root) {
        this.sword_beam_main = root.getChild("sword_beam_main");
    }

    public static @NotNull TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData sword_beam_main = modelPartData.addChild("sword_beam_main", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0f, 0.0f, -4.0f, 2.0f, 2.0f, 8.0f, new Dilation(0.0f)), ModelTransform.pivot(0.0f, 0.0f, 0.0f));
        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void setAngles(SwordBeamEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        sword_beam_main.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}
