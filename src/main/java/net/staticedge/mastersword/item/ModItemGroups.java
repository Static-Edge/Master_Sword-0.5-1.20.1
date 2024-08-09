package net.staticedge.mastersword.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.staticedge.mastersword.MasterSword;

public class ModItemGroups {
    public static final ItemGroup MASTER_SWORD =  Registry.register(Registries.ITEM_GROUP,
            new Identifier(MasterSword.MOD_ID, "master_sword"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.mastersword"))
                    .icon(() -> new ItemStack(ModItems.THE_MASTER_SWORD)).entries((displayContext, entries) -> {
                        entries.add(ModItems.THE_MASTER_SWORD);
                        entries.add(ModItems.THE_TRUE_MASTER_SWORD);
                        entries.add(ModItems.DIVINE_UPGRADE_SMITHING_TEMPLATE);
                        entries.add(ModItems.HYLIAN_SHIELD);
                        entries.add(ModItems.LIGHTSCALE_TRIDENT);
                        entries.add(ModItems.GREAT_EAGLE_BOW);
                        entries.add(ModItems.BOULDER_BREAKER);



                    }).build());


    public static void registerItemGroups() {
        MasterSword.LOGGER.info("Registering Item Groups For " + MasterSword.MOD_ID);
    }
}
