package breadblockmod.init;

import breadblockmod.BreadBlockMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = BreadBlockMod.MOD_ID, bus = Bus.MOD)
@ObjectHolder(BreadBlockMod.MOD_ID)
public class BlockInit {
	public static final Block bread_block_block = null;
	@SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
	    event.getRegistry().register(new Block(Block.Properties.create(Material.SAND).hardnessAndResistance((float)0.3).sound(SoundType.SWEET_BERRY_BUSH)).setRegistryName("bread_block_block"));	
	}
	
	@SubscribeEvent
    public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
	    event.getRegistry().register(new BlockItem(bread_block_block, new Item.Properties().group(ItemGroup.FOOD)).setRegistryName("bread_block_block"));	
	}
}
