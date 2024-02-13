package xxrexraptorxx.exocraft.utils;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.Lazy;
import xxrexraptorxx.exocraft.main.References;
import xxrexraptorxx.exocraft.registry.ModItems;

import java.util.function.Supplier;

public enum ArmorMaterials implements ArmorMaterial {

    REINFORCED_IRON(References.MODID + ":reinforced_iron", 35, new int[] {3, 6, 8, 3}, 10, SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 0, ()-> { return Ingredient.of(ModItems.REINFORCED_IRON_PLATE.get());}),
    ATLAS(References.MODID + ":atlas", 35, new int[] {3, 6, 8, 3}, 0, SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 0.05F, ()-> { return Ingredient.of(ModItems.REINFORCED_IRON_PLATE.get());}),
    OGRE(References.MODID + ":atlas", 35, new int[] {3, 6, 8, 3}, 0, SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 0.05F, ()-> { return Ingredient.of(ModItems.REINFORCED_IRON_PLATE.get());}),
    LEGION(References.MODID + ":atlas", 35, new int[] {3, 6, 8, 3}, 0, SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 0.05F, ()-> { return Ingredient.of(ModItems.REINFORCED_IRON_PLATE.get());}),
    STRYDER(References.MODID + ":atlas", 35, new int[] {3, 6, 8, 3}, 0, SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 0.05F, ()-> { return Ingredient.of(ModItems.REINFORCED_IRON_PLATE.get());}),
    ION(References.MODID + ":atlas", 35, new int[] {3, 6, 8, 3}, 0, SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 0.05F, ()-> { return Ingredient.of(ModItems.REINFORCED_IRON_PLATE.get());});

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final float knockbackResistance;
    private final Lazy<Ingredient> repairMaterial;

    private ArmorMaterials(String nameIn, int maxDamageIn, int[] drAmtArray, int enchantabilityIn, SoundEvent soundIn, float toughnessIn,  float knockbackResistanceIn, Supplier<Ingredient> repairMatIn) {
        name = nameIn;
        maxDamageFactor = maxDamageIn;
        damageReductionAmountArray = drAmtArray;
        enchantability = enchantabilityIn;
        soundEvent = soundIn;
        toughness = toughnessIn;
        knockbackResistance = knockbackResistanceIn;
        repairMaterial = Lazy.of(repairMatIn);
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlot slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}