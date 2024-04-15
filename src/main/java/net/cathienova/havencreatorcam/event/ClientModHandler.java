package net.cathienova.havencreatorcam.event;

import net.cathienova.havencreatorcam.HavenCreatorCam;
import net.cathienova.havencreatorcam.util.ModKeybindings;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;

@Mod.EventBusSubscriber(modid = HavenCreatorCam.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModHandler
{
    @SubscribeEvent
    public static void registerKeys(RegisterKeyMappingsEvent event)
    {
        event.register(ModKeybindings.INSTANCE.creatorcam);
    }
}
