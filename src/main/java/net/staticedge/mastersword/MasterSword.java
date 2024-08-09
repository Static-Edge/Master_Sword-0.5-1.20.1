package net.staticedge.mastersword;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.staticedge.mastersword.enchantment.ModEnchantments;
import net.staticedge.mastersword.item.ModItems;
import net.staticedge.mastersword.util.ModLootTableModifiers;
import org.slf4j.Logger;
import net.staticedge.mastersword.item.ModItemGroups;
import org.slf4j.LoggerFactory;

public class MasterSword implements ModInitializer {
	public static final String MOD_ID = "master-sword";
	public static final Logger LOGGER = LoggerFactory.getLogger("master-sword");

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModEnchantments.registerModEnchantments();

		ModLootTableModifiers.modifyLootTables();
		LOGGER.info("Master Sword initialized!");
	}
}