package net.cathienova.havencreatorcam;

import net.cathienova.havencreatorcam.config.CommonConfig;
import net.cathienova.havencreatorcam.config.ConfigSubscriber;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.NeoForge;

@Mod(value = HavenCreatorCam.MOD_ID, dist = Dist.CLIENT)
public class HavenCreatorCam
{
    public static final String MOD_ID = "havencreatorcam";
    static final ModConfigSpec commonSpec;
    public static final CommonConfig c_config;

    static
    {
        final ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        c_config = new CommonConfig(builder);
        commonSpec = builder.build();
    }

    public HavenCreatorCam(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(HavenCreatorClient::registerKeyMappings);
        modEventBus.addListener(ConfigSubscriber::onModConfigEvent);
        NeoForge.EVENT_BUS.addListener(HavenCreatorClient.GameEventHandler::onClientTick);
        modContainer.registerConfig(ModConfig.Type.CLIENT, commonSpec);
    }
}