package net.staticedge.mastersword.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.staticedge.mastersword.entity.MasterSwordEntities;
import net.staticedge.mastersword.entity.entitytype.SwordBeamEntity;
import org.jetbrains.annotations.NotNull;

public class TrueMasterSwordItem extends UpgradedSwordItem{
    public TrueMasterSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(@NotNull World world, @NotNull PlayerEntity user, Hand hand) {

        ItemStack stack = user.getStackInHand(hand);
        if (!world.isClient()) {
            SwordBeamEntity swordBeam = MasterSwordEntities.SWORD_BEAM.create(world);
            swordBeam.setYaw(user.getHeadYaw());
            swordBeam.setPitch(user.getPitch());
            swordBeam.setOwner(user);
            swordBeam.setPosition(user.getX(), user.getY() + user.getEyeHeight(user.getPose()), user.getZ());
            swordBeam.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f,  1.5f, 0.0f);
            world.spawnEntity(swordBeam);
            stack.damage(1, user, (p) -> p.sendToolBreakStatus(user.getActiveHand()));
            user.getItemCooldownManager().set(stack.getItem(), 30);

        }

        return TypedActionResult.success(stack, true);
    }
}
