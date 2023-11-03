package xxrexraptorxx.exocraft.utils;

import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.Lazy;
import xxrexraptorxx.exocraft.main.References;
import xxrexraptorxx.exocraft.registry.ModItems;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum ArmorMaterials implements ArmorMaterial {

    /**                              VANILLA ARMOR
     LEATHER("leather", 5, Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266652_) -> {
     p_266652_.put(ArmorItem.Type.BOOTS, 1);
     p_266652_.put(ArmorItem.Type.LEGGINGS, 2);
     p_266652_.put(ArmorItem.Type.CHESTPLATE, 3);
     p_266652_.put(ArmorItem.Type.HELMET, 1);
     }), 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> {
     return Ingredient.of(Items.LEATHER);
     }),
     CHAIN("chainmail", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266651_) -> {
     p_266651_.put(ArmorItem.Type.BOOTS, 1);
     p_266651_.put(ArmorItem.Type.LEGGINGS, 4);
     p_266651_.put(ArmorItem.Type.CHESTPLATE, 5);
     p_266651_.put(ArmorItem.Type.HELMET, 2);
     }), 12, SoundEvents.ARMOR_EQUIP_CHAIN, 0.0F, 0.0F, () -> {
     return Ingredient.of(Items.IRON_INGOT);
     }),
     IRON("iron", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266654_) -> {
     p_266654_.put(ArmorItem.Type.BOOTS, 2);
     p_266654_.put(ArmorItem.Type.LEGGINGS, 5);
     p_266654_.put(ArmorItem.Type.CHESTPLATE, 6);
     p_266654_.put(ArmorItem.Type.HELMET, 2);
     }), 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
     return Ingredient.of(Items.IRON_INGOT);
     }),
     GOLD("gold", 7, Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266650_) -> {
     p_266650_.put(ArmorItem.Type.BOOTS, 1);
     p_266650_.put(ArmorItem.Type.LEGGINGS, 3);
     p_266650_.put(ArmorItem.Type.CHESTPLATE, 5);
     p_266650_.put(ArmorItem.Type.HELMET, 2);
     }), 25, SoundEvents.ARMOR_EQUIP_GOLD, 0.0F, 0.0F, () -> {
     return Ingredient.of(Items.GOLD_INGOT);
     }),
     DIAMOND("diamond", 33, Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266649_) -> {
     p_266649_.put(ArmorItem.Type.BOOTS, 3);
     p_266649_.put(ArmorItem.Type.LEGGINGS, 6);
     p_266649_.put(ArmorItem.Type.CHESTPLATE, 8);
     p_266649_.put(ArmorItem.Type.HELMET, 3);
     }), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> {
     return Ingredient.of(Items.DIAMOND);
     }),
     NETHERITE("netherite", 37, Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266655_) -> {
     p_266655_.put(ArmorItem.Type.BOOTS, 3);
     p_266655_.put(ArmorItem.Type.LEGGINGS, 6);
     p_266655_.put(ArmorItem.Type.CHESTPLATE, 8);
     p_266655_.put(ArmorItem.Type.HELMET, 3);
     }), 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> {
     return Ingredient.of(Items.NETHERITE_INGOT);
     });
    **/
    MECH(References.MODID + ":mech_suit", 3, Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266650_) -> {
        p_266650_.put(ArmorItem.Type.BOOTS, 3);
        p_266650_.put(ArmorItem.Type.LEGGINGS, 6);
        p_266650_.put(ArmorItem.Type.CHESTPLATE, 8);
        p_266650_.put(ArmorItem.Type.HELMET, 3);
    }), 1, SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 10, () -> {
        return Ingredient.of(ModItems.REINFORCED_IRON_PLATE.get());
    });

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final Lazy<Ingredient> repairMaterial;
    private final float knockbackResistance;
    private final int durabilityMultiplier;
    private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
    private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266653_) -> {
        p_266653_.put(ArmorItem.Type.BOOTS, 13);
        p_266653_.put(ArmorItem.Type.LEGGINGS, 15);
        p_266653_.put(ArmorItem.Type.CHESTPLATE, 16);
        p_266653_.put(ArmorItem.Type.HELMET, 11);
    });

    ArmorMaterials(String nameIn, int durabilityMultiplierIn, EnumMap<ArmorItem.Type, Integer> protectionFunctionForTypeIn, int enchantabilityIn,
                   SoundEvent soundIn, float toughnessIn, int knockbackResistanceIn, Supplier<Ingredient> repairMatIn) {
        name = nameIn;
        durabilityMultiplier = durabilityMultiplierIn;
        protectionFunctionForType = protectionFunctionForTypeIn;
        enchantability = enchantabilityIn;
        soundEvent = soundIn;
        toughness = toughnessIn;
        knockbackResistance = knockbackResistanceIn;
        repairMaterial = Lazy.of(repairMatIn);
    }


    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return HEALTH_FUNCTION_FOR_TYPE.get(type) * this.durabilityMultiplier;
    }


    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.protectionFunctionForType.get(type);
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