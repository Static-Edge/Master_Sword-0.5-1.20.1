package net.staticedge.mastersword.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.staticedge.mastersword.MasterSword;
import oshi.util.tuples.Pair;

import java.util.List;

public class ModItems {
    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(THE_MASTER_SWORD);
        entries.add(DIVINE_UPGRADE_SMITHING_TEMPLATE);
        entries.add(HYLIAN_SHIELD);
    }

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MasterSword.MOD_ID, name), item);
    }

    public static final Item THE_MASTER_SWORD = registerItem("the_master_sword",
            new UpgradedSwordItem(ToolMaterials.NETHERITE, 5, -2.5f, new FabricItemSettings().maxDamage(2502).rarity(Rarity.EPIC).fireproof()));

    public static final Item THE_TRUE_MASTER_SWORD = registerItem("the_true_master_sword",
            new TrueMasterSwordItem(ToolMaterials.NETHERITE, 7, -2.6f, new FabricItemSettings().maxDamage(3000).rarity(Rarity.EPIC).fireproof()));

    public static final Item BOULDER_BREAKER = registerItem("boulder_breaker",
            new UpgradedPickaxeItem(ModToolMaterial.DIVINE, 6, -3.0f, new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));

    public static final Item HYLIAN_SHIELD = registerItem("hylian_shield",
            new UpgradedShieldItem(null,
                    () -> Ingredient.ofItems(Items.NETHERITE_INGOT),
                    List.of(
                            new Pair<>(
                                    EntityAttributes.GENERIC_ARMOR,
                                    new EntityAttributeModifier(
                                            "hylian_shield",
                                            4.0,
                                            EntityAttributeModifier.Operation.ADDITION
                                    )
                            )
                    ),
                    new FabricItemSettings().maxDamage(2502).rarity(Rarity.EPIC).fireproof()));

    public static final Item GREAT_EAGLE_BOW = registerItem("great_eagle_bow", new UpgradedBowItem(new FabricItemSettings().maxDamage(2502).rarity(Rarity.EPIC).fireproof()));

    public static final Item DIVINE_UPGRADE_SMITHING_TEMPLATE = registerItem("divine_upgrade_smithing_template", DivineTemplateItem.createDivineUpgrade());

    public static final Item LIGHTSCALE_TRIDENT = registerItem("lightscale_trident", new UpgradedTridentItem(new FabricItemSettings().fireproof().maxDamage(2502).rarity(Rarity.EPIC)));

    public static void registerModItems() {
        MasterSword.LOGGER.info("Registering Mod Items for " + MasterSword.MOD_ID);
    }
}