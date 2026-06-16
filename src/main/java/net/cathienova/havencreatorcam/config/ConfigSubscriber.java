package net.cathienova.havencreatorcam.config;

import net.neoforged.fml.event.config.ModConfigEvent;

public class ConfigSubscriber {
    public static void onModConfigEvent(final ModConfigEvent event) {
        if (event instanceof ModConfigEvent.Reloading || event instanceof ModConfigEvent.Loading) {
            HavenConfig.bake(event.getConfig());
        } else if (event instanceof ModConfigEvent.Unloading) {

        }
    }
}