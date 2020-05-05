package palmtrees.init;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
//import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.registries.DeferredRegister;
import palmtrees.PalmTrees;
import palmtrees.PalmTrees.PalmAssetsItemGroup;
import net.minecraftforge.fml.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, PalmTrees.MOD_ID);
    public static final RegistryObject<Item> COCONUT_REMAINS= ITEMS.register("coconut_remains", ()-> new Item(new Item.Properties().group(PalmAssetsItemGroup.start).food(new Food.Builder().hunger(1).saturation((float)1.0).setAlwaysEdible().build())));
    public static final RegistryObject<Item> COCONUT_MILK= ITEMS.register("coconut_milk", ()-> new Item(new Item.Properties().group(PalmAssetsItemGroup.start).food(new Food.Builder().hunger(8).saturation((float)2.0).effect(new EffectInstance(Effects.FIRE_RESISTANCE,5000, 4),(float)0.3).setAlwaysEdible().build())));
}
