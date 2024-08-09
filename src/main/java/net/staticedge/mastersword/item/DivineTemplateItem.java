package net.staticedge.mastersword.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.trim.ArmorTrimPattern;
import net.minecraft.registry.RegistryKey;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DivineTemplateItem extends Item {
    private static final Formatting TITLE_FORMATTING = Formatting.GRAY;
    private static final Formatting DESCRIPTION_FORMATTING = Formatting.BLUE;
    private static final String TRANSLATION_KEY = Util.createTranslationKey("item", new Identifier("divine_template"));
    private static final Text INGREDIENTS_TEXT = Text.translatable(Util.createTranslationKey("item", new Identifier("divine_template.ingredients")))
            .formatted(TITLE_FORMATTING);
    private static final Text APPLIES_TO_TEXT = Text.translatable(Util.createTranslationKey("item", new Identifier("divine_template.applies_to")))
            .formatted(TITLE_FORMATTING);
    private static final Text DIVINE_UPGRADE_TEXT = Text.translatable(Util.createTranslationKey("upgrade", new Identifier("divine_upgrade")))
            .formatted(TITLE_FORMATTING);
    private static final Text ARMOR_TRIM_APPLIES_TO_TEXT = Text.translatable(
                    Util.createTranslationKey("item", new Identifier("divine_template.armor_trim.applies_to"))
            )
            .formatted(DESCRIPTION_FORMATTING);
    private static final Text ARMOR_TRIM_INGREDIENTS_TEXT = Text.translatable(
                    Util.createTranslationKey("item", new Identifier("divine_template.armor_trim.ingredients"))
            )
            .formatted(DESCRIPTION_FORMATTING);
    private static final Text ARMOR_TRIM_BASE_SLOT_DESCRIPTION_TEXT = Text.translatable(
            Util.createTranslationKey("item", new Identifier("divine_template.armor_trim.base_slot_description"))
    );
    private static final Text ARMOR_TRIM_ADDITIONS_SLOT_DESCRIPTION_TEXT = Text.translatable(
            Util.createTranslationKey("item", new Identifier("divine_template.armor_trim.additions_slot_description"))
    );
    private static final Text DIVINE_UPGRADE_APPLIES_TO_TEXT = Text.translatable(
                    Util.createTranslationKey("item", new Identifier("divine_template.divine_upgrade.applies_to"))
            )
            .formatted(DESCRIPTION_FORMATTING);
    private static final Text DIVINE_UPGRADE_INGREDIENTS_TEXT = Text.translatable(
                    Util.createTranslationKey("item", new Identifier("divine_template.divine_upgrade.ingredients"))
            )
            .formatted(DESCRIPTION_FORMATTING);
    private static final Text DIVINE_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = Text.translatable(
            Util.createTranslationKey("item", new Identifier("divine_template.divine_upgrade.base_slot_description"))
    );
    private static final Text DIVINE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Text.translatable(
            Util.createTranslationKey("item", new Identifier("divine_template.divine_upgrade.additions_slot_description"))
    );
    private static final Identifier EMPTY_ARMOR_SLOT_HELMET_TEXTURE = new Identifier("item/empty_armor_slot_helmet");
    private static final Identifier EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE = new Identifier("item/empty_armor_slot_chestplate");
    private static final Identifier EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE = new Identifier("item/empty_armor_slot_leggings");
    private static final Identifier EMPTY_ARMOR_SLOT_BOOTS_TEXTURE = new Identifier("item/empty_armor_slot_boots");
    private static final Identifier EMPTY_SLOT_HOE_TEXTURE = new Identifier("item/empty_slot_hoe");
    private static final Identifier EMPTY_SLOT_AXE_TEXTURE = new Identifier("item/empty_slot_axe");
    private static final Identifier EMPTY_SLOT_SWORD_TEXTURE = new Identifier("item/empty_slot_sword");
    private static final Identifier EMPTY_SLOT_SHOVEL_TEXTURE = new Identifier("item/empty_slot_shovel");
    private static final Identifier EMPTY_SLOT_PICKAXE_TEXTURE = new Identifier("item/empty_slot_pickaxe");
    private static final Identifier EMPTY_SLOT_INGOT_TEXTURE = new Identifier("item/empty_slot_ingot");
    private static final Identifier EMPTY_SLOT_REDSTONE_DUST_TEXTURE = new Identifier("item/empty_slot_redstone_dust");
    private static final Identifier EMPTY_SLOT_QUARTZ_TEXTURE = new Identifier("item/empty_slot_quartz");
    private static final Identifier EMPTY_SLOT_EMERALD_TEXTURE = new Identifier("item/empty_slot_emerald");
    private static final Identifier EMPTY_SLOT_DIAMOND_TEXTURE = new Identifier("item/empty_slot_diamond");
    private static final Identifier EMPTY_SLOT_LAPIS_LAZULI_TEXTURE = new Identifier("item/empty_slot_lapis_lazuli");
    private static final Identifier EMPTY_SLOT_AMETHYST_SHARD_TEXTURE = new Identifier("item/empty_slot_amethyst_shard");
    private final Text appliesToText;
    private final Text ingredientsText;
    private final Text titleText;
    private final Text baseSlotDescriptionText;
    private final Text additionsSlotDescriptionText;
    private final List<Identifier> emptyBaseSlotTextures;
    private final List<Identifier> emptyAdditionsSlotTextures;

    public DivineTemplateItem(
            Text appliesToText,
            Text ingredientsText,
            Text titleText,
            Text baseSlotDescriptionText,
            Text additionsSlotDescriptionText,
            List<Identifier> emptyBaseSlotTextures,
            List<Identifier> emptyAdditionsSlotTextures
    ) {
        super(new Item.Settings());
        this.appliesToText = appliesToText;
        this.ingredientsText = ingredientsText;
        this.titleText = titleText;
        this.baseSlotDescriptionText = baseSlotDescriptionText;
        this.additionsSlotDescriptionText = additionsSlotDescriptionText;
        this.emptyBaseSlotTextures = emptyBaseSlotTextures;
        this.emptyAdditionsSlotTextures = emptyAdditionsSlotTextures;
    }

    public static DivineTemplateItem of(RegistryKey<ArmorTrimPattern> trimPattern) {
        return of(trimPattern.getValue());
    }

    public static DivineTemplateItem of(Identifier trimPatternIn) {
        return new DivineTemplateItem(
                ARMOR_TRIM_APPLIES_TO_TEXT,
                ARMOR_TRIM_INGREDIENTS_TEXT,
                Text.translatable(Util.createTranslationKey("trim_pattern", trimPatternIn)).formatted(TITLE_FORMATTING),
                ARMOR_TRIM_BASE_SLOT_DESCRIPTION_TEXT,
                ARMOR_TRIM_ADDITIONS_SLOT_DESCRIPTION_TEXT,
                getArmorTrimEmptyBaseSlotTextures(),
                getArmorTrimEmptyAdditionsSlotTextures()
        );
    }

    public static DivineTemplateItem createDivineUpgrade() {
        return new DivineTemplateItem(
                DIVINE_UPGRADE_APPLIES_TO_TEXT,
                DIVINE_UPGRADE_INGREDIENTS_TEXT,
                DIVINE_UPGRADE_TEXT,
                DIVINE_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT,
                DIVINE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT,
                getDivineUpgradeEmptyBaseSlotTextures(),
                getDivineUpgradeEmptyAdditionsSlotTextures()
        );
    }

    private static List<Identifier> getArmorTrimEmptyBaseSlotTextures() {
        return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_ARMOR_SLOT_BOOTS_TEXTURE);
    }

    private static List<Identifier> getArmorTrimEmptyAdditionsSlotTextures() {
        return List.of(
                EMPTY_SLOT_INGOT_TEXTURE,
                EMPTY_SLOT_REDSTONE_DUST_TEXTURE,
                EMPTY_SLOT_LAPIS_LAZULI_TEXTURE,
                EMPTY_SLOT_QUARTZ_TEXTURE,
                EMPTY_SLOT_DIAMOND_TEXTURE,
                EMPTY_SLOT_EMERALD_TEXTURE,
                EMPTY_SLOT_AMETHYST_SHARD_TEXTURE
        );
    }

    private static List<Identifier> getDivineUpgradeEmptyBaseSlotTextures() {
        return List.of(
                EMPTY_ARMOR_SLOT_HELMET_TEXTURE,
                EMPTY_SLOT_SWORD_TEXTURE,
                EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE,
                EMPTY_SLOT_PICKAXE_TEXTURE,
                EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE,
                EMPTY_SLOT_AXE_TEXTURE,
                EMPTY_ARMOR_SLOT_BOOTS_TEXTURE,
                EMPTY_SLOT_HOE_TEXTURE,
                EMPTY_SLOT_SHOVEL_TEXTURE
        );
    }

    private static List<Identifier> getDivineUpgradeEmptyAdditionsSlotTextures() {
        return List.of(EMPTY_SLOT_INGOT_TEXTURE);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(this.titleText);
        tooltip.add(ScreenTexts.EMPTY);
        tooltip.add(APPLIES_TO_TEXT);
        tooltip.add(ScreenTexts.space().append(this.appliesToText));
        tooltip.add(INGREDIENTS_TEXT);
        tooltip.add(ScreenTexts.space().append(this.ingredientsText));
    }

    public Text getBaseSlotDescription() {
        return this.baseSlotDescriptionText;
    }

    public Text getAdditionsSlotDescription() {
        return this.additionsSlotDescriptionText;
    }

    public List<Identifier> getEmptyBaseSlotTextures() {
        return this.emptyBaseSlotTextures;
    }

    public List<Identifier> getEmptyAdditionsSlotTextures() {
        return this.emptyAdditionsSlotTextures;
    }

    @Override
    public String getTranslationKey() {
        return TRANSLATION_KEY;
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}

