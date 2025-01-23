package net.cathienova.havencreatorcam;

import com.mojang.logging.LogUtils;
import net.cathienova.havencreatorcam.config.CommonConfig;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;

@Mod(HavenCreatorCam.MOD_ID)
public class HavenCreatorCam
{
    public static final String MOD_ID = "havencreatorcam";
    private static final Logger LOGGER = LogUtils.getLogger();
    static final ModConfigSpec commonSpec;
    public static final CommonConfig c_config;

    static
    {
        final Pair<CommonConfig, ModConfigSpec> specPair = new ModConfigSpec.Builder().configure(CommonConfig::new);
        commonSpec = specPair.getRight();
        c_config = specPair.getLeft();
    }

    public HavenCreatorCam(IEventBus modEventBus, ModContainer modContainer)
    {
        modContainer.registerConfig(ModConfig.Type.CLIENT, commonSpec);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }
}
