package net.staticedge.mastersword.item;


import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class UpgradedBowItem extends MultishotBowItem {

    public UpgradedBowItem(Settings settings) {
        super(settings);
    }

    @Override
    public int arrowCount() {
        return 3;
    }

    @Override
    public boolean hasGlint(ItemStack stack){
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.master-sword.great_eagle_bow_tooltip"));
        tooltip.add(Text.translatable("tooltip.master-sword.great_eagle_bow_tooltip_2"));
        tooltip.add(Text.translatable("tooltip.master-sword.great_eagle_bow_tooltip_3"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}