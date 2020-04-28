package emeraldarmorandtools.init;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;

import java.util.function.Supplier;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;
import emeraldarmorandtools.EmeraldArmorAndTools;
@Mod.EventBusSubscriber(modid = EmeraldArmorAndTools.MOD_ID, bus = Bus.MOD)
@ObjectHolder(EmeraldArmorAndTools.MOD_ID)
public class ItemInit {
    public static final Item emerald_sword = null;
    public static final Item emerald_shovel = null;
    public static final Item emerald_pickaxe = null;
    public static final Item emerald_hoe = null;
    public static final Item emerald_axe = null;
    public static final Item emerald_leggings = null;
    public static final Item emerald_helmet = null;
    public static final Item emerald_chestplate = null;
    public static final Item emerald_boots = null;
    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new SwordItem(ItemTier.IRON, 7, (float)4.0, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("emerald_sword"));
        event.getRegistry().register(new ShovelItem(ItemTier.IRON, 2, (float)4.0, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("emerald_shovel"));
        event.getRegistry().register(new PickaxeItem(ItemTier.IRON, 2, (float)4.0, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("emerald_pickaxe"));
        event.getRegistry().register(new HoeItem(ItemTier.IRON, 2, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("emerald_hoe"));
        event.getRegistry().register(new AxeItem(ItemTier.IRON, 2, (float)4.0, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("emerald_axe"));
        event.getRegistry().register(new ArmorItem(ModArmorMaterial.EMERALD, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("emerald_leggings"));
        event.getRegistry().register(new ArmorItem(ModArmorMaterial.EMERALD, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("emerald_helmet"));
        event.getRegistry().register(new ArmorItem(ModArmorMaterial.EMERALD, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("emerald_chestplate"));
        event.getRegistry().register(new ArmorItem(ModArmorMaterial.EMERALD, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("emerald_boots"));
    }
    public enum ModArmorMaterial implements IArmorMaterial{
    	EMERALD(EmeraldArmorAndTools.MOD_ID + ":emerald", 3, new int[] {4,5,7,5}, 200, ((float)5.0), () -> {
    	    return Ingredient.fromItems(ItemInit.emerald_boots);	
    	});
    	
    	private static final int[] MAX_DAMAGE_ARRAY = new int[] {10,11,12,11};
    	private final String name;
    	private final int maxDamageFactor;
    	private final int[] damageReductionAmountArray;
    	private final int enchantability; 
    	private final float toughness;
    	private final LazyValue<Ingredient> repairMaterial;
    	private ModArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn, int enchantabilityIn, float toughnessIn, Supplier<Ingredient> repairMaterialIn) {
    		this.name = nameIn;
			this.maxDamageFactor = maxDamageFactorIn;
			this.damageReductionAmountArray = damageReductionAmountIn;
			this.enchantability = enchantabilityIn;
			this.toughness = toughnessIn;
			this.repairMaterial = new LazyValue<>(repairMaterialIn);
    	}
		@Override
		public int getDurability(EquipmentSlotType slotIn) {
			return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
		}

		@Override
		public int getDamageReductionAmount(EquipmentSlotType slotIn) {
			return this.damageReductionAmountArray[slotIn.getIndex()];
		}

		@Override
		public int getEnchantability() {
			return this.enchantability;
		}

		@Override
		public Ingredient getRepairMaterial() {
			return this.repairMaterial.getValue();
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public String getName() {
			return this.name;
		}

		@Override
		public float getToughness() {
			return this.toughness;
		}
		@Override
		public SoundEvent getSoundEvent() {
			// TODO Auto-generated method stub
			return null;
		}
    }
}
