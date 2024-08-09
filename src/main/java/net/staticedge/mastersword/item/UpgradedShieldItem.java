package net.staticedge.mastersword.item;


import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import oshi.util.tuples.Pair;

import java.util.HashSet;
import java.util.List;
import java.util.function.Supplier;

public class UpgradedShieldItem extends ShieldItem {

    private Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
    public final static HashSet<UpgradedShieldItem> instances = new HashSet<>();

    @Nullable
    private final SoundEvent equipSound;

    private final Supplier<Ingredient> repairIngredientSupplier;

    public UpgradedShieldItem(@Nullable SoundEvent equipSound, Supplier<Ingredient> repairIngredientSupplier, List<Pair<EntityAttribute, EntityAttributeModifier>> attributeModifierList, Settings settings) {
        super(settings);
        this.attributeModifiers = buildModifiers(attributeModifierList);
        this.equipSound = equipSound;
        this.repairIngredientSupplier = repairIngredientSupplier;
        instances.add(this);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return this.repairIngredientSupplier.get().test(ingredient) || super.canRepair(stack, ingredient);
    }

    public void setAttributeModifiers(List<Pair<EntityAttribute, EntityAttributeModifier>> attributeModifierList) {
        this.attributeModifiers = buildModifiers(attributeModifierList);
    }

    @Override
    public Multimap<EntityAttribute,EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        if (slot == EquipmentSlot.OFFHAND) {
            return this.attributeModifiers;
        }
        return super.getAttributeModifiers(slot);
    }

    protected Multimap<EntityAttribute, EntityAttributeModifier> buildModifiers(List<Pair<EntityAttribute, EntityAttributeModifier>> attributeModifierList) {
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        for (Pair<EntityAttribute, EntityAttributeModifier> pair : attributeModifierList) {
            builder.put(pair.getA(), pair.getB());
        }
        return builder.build();
    }

    @Override
    public @Nullable SoundEvent getEquipSound() {
        return this.equipSound != null ? this.equipSound : super.getEquipSound();
    }

    @Override
    public boolean hasGlint(ItemStack stack){
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.master-sword.hylian_shield_tooltip"));
        tooltip.add(Text.translatable("tooltip.master-sword.hylian_shield_tooltip_2"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
