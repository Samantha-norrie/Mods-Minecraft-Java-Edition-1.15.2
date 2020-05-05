package palmtrees;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
//import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import palmtrees.init.BlockInit;
import palmtrees.init.ItemInit;

@Mod("palmtrees")
@Mod.EventBusSubscriber(modid = PalmTrees.MOD_ID, bus = Bus.MOD)
public class PalmTrees {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "palmtrees";
    public static PalmTrees instance;
    
    public PalmTrees() {
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	modEventBus.addListener(this::setup);
    	modEventBus.addListener(this::doClientStuff);
    	ItemInit.ITEMS.register(modEventBus);
    	BlockInit.BLOCKS.register(modEventBus);
    	//ModTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
    	instance = this;
    	MinecraftForge.EVENT_BUS.register(this);
    }
    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
    	final IForgeRegistry<Item> registry = event.getRegistry();
    	
    	BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
    		final Item.Properties properties = new Item.Properties().group(PalmAssetsItemGroup.start);
    		final BlockItem blockItem = new BlockItem(block, properties);
    		blockItem.setRegistryName(block.getRegistryName());
    		registry.register(blockItem);
    	});
    }
    private void setup(final FMLCommonSetupEvent event) {
    	
    }
    private void doClientStuff(final FMLClientSetupEvent event) {
    	
    }
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
    	
    }
    public static class PalmAssetsItemGroup extends ItemGroup{
    	public static final ItemGroup start = new PalmAssetsItemGroup(ItemGroup.GROUPS.length, "palmtab");
    	private PalmAssetsItemGroup(int index, String label) {
    		super(index, label);
    	}

		@Override
		public ItemStack createIcon() {
			// TODO Auto-generated method stub
			return new ItemStack(BlockInit.PALM_TREE_WOOD.get());
		}
    }
//    @SubscribeEvent
//    public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
    	
//    }
}
