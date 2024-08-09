package net.staticedge.mastersword.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.staticedge.mastersword.MasterSword;


public class ModTags {
    public static class Blocks {


        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(MasterSword.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> SHIELD_REPAIR_MATERIALS =
                createTag("shield_repair_materials");
        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(MasterSword.MOD_ID, name));
        }
    }
}
