package net.cathienova.havencreatorcam.event;

import net.cathienova.havencreatorcam.HavenCreatorCam;
import net.cathienova.havencreatorcam.util.ModKeybindings;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = HavenCreatorCam.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModHandler
{
    @SubscribeEvent
    public static void registerKeys(FMLClientSetupEvent event)
    {
        ModKeybindings.registerKeybindings();
    }
}
