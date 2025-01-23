package net.cathienova.havencreatorcam.config;

import net.cathienova.havencreatorcam.HavenCreatorCam;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;

@EventBusSubscriber(modid = HavenCreatorCam.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ConfigSubscriber {
    @SubscribeEvent
    public static void onModConfigEvent(final ModConfigEvent event) {
        if (event instanceof ModConfigEvent.Reloading || event instanceof ModConfigEvent.Loading) {
            HavenConfig.bake(event.getConfig());
        } else if (event instanceof ModConfigEvent.Unloading) {

        }
    }
}
