package palmtrees.init;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
//import net.minecraft.block.LeavesBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.PressurePlateBlock.Sensitivity;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import palmtrees.PalmTrees;
import palmtrees.objects.blocks.PalmButton;
//import palmtrees.objects.blocks.PalmDoor;
import palmtrees.objects.blocks.PalmPressurePlate;
public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, PalmTrees.MOD_ID);
    
    public static final RegistryObject<Block> COCONUT= BLOCKS.register("coconut", ()-> new Block(Block.Properties.create(Material.BAMBOO)));
    public static final RegistryObject<Block> PALM_WOOD= BLOCKS.register("palm_wood", ()-> new Block(Block.Properties.from(Blocks.ACACIA_PLANKS)));
    public static final RegistryObject<Block> PALM_TREE_WOOD= BLOCKS.register("palm_tree_wood", ()-> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.ACACIA_LOG)));
    //public static final RegistryObject<Block> PALM_TREE_LEAVES = BLOCKS.register("palm_tree_leaves", ()-> new LeavesBlock(Block.Properties.from(Blocks.ACACIA_LEAVES)));
    //public static final RegistryObject<Block> PALM_TREE_SAPLING = BLOCKS.register("palm_tree_sapling", ()-> new SaplingBlock(()-> new PalmTree(), Block.Properties.from(Blocks.ACACIA_SAPLING)));
	public static final RegistryObject<Block> PALM_STAIRS = BLOCKS.register("palm_stairs",() -> new StairsBlock(() -> BlockInit.PALM_WOOD.get().getDefaultState(),Block.Properties.create(Material.SAND)));
    public static final RegistryObject<Block> PALM_FENCE = BLOCKS.register("palm_fence", () -> new FenceBlock(Block.Properties.create(Material.WOOD)));
    public static final RegistryObject<Block> PALM_BUTTON = BLOCKS.register("palm_button", ()-> new PalmButton(Block.Properties.create(Material.WOOD)));
    public static final RegistryObject<Block> PALM_PRESSURE_PLATE = BLOCKS.register("palm_pressure_plate", ()-> new PalmPressurePlate(Sensitivity.EVERYTHING,Block.Properties.create(Material.WOOD)));
    //public static final RegistryObject<Block> PALM_DOOR = BLOCKS.register("palm_door", () -> new PalmDoor(Block.Properties.from(Blocks.ACACIA_DOOR)));
}
