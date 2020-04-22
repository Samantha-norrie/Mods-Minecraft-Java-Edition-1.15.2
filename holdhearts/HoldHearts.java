


package holdhearts;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import holdhearts.util.RegistryHandler;



@Mod("holdhearts")
public class HoldHearts
{
 
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "holdhearts";
    public HoldHearts() {
        
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        
        
        
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        RegistryHandler.init();
        
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        
    }

 
}
