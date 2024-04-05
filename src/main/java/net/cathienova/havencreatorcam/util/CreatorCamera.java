package net.cathienova.havencreatorcam.util;

import net.cathienova.havencreatorcam.HavenCreatorCam;
import net.cathienova.havencreatorcam.config.HavenConfig;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HavenCreatorCam.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class CreatorCamera
{
    private static boolean creatorCamKeyDown = false;

    @Mod.EventBusSubscriber(modid = HavenCreatorCam.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {

        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event)
        {
            Minecraft mc = Minecraft.getInstance();

            if (mc.player == null) return;

            boolean newCreatorCamKeyDown = ModKeybindings.INSTANCE.creatorcam.isDown();

            if (newCreatorCamKeyDown && !creatorCamKeyDown)
            {
                CreatorCamView(mc);
                if (HavenConfig.hideGUI)
                    mc.options.hideGui = true;
            }
            if (!newCreatorCamKeyDown && creatorCamKeyDown)
            {
                mc.options.setCameraType(CameraType.FIRST_PERSON);
                if (HavenConfig.hideGUI)
                    mc.options.hideGui = false;
            }

            // Update the key states for the next iteration
            creatorCamKeyDown = newCreatorCamKeyDown;
        }

        private static void CreatorCamView(Minecraft mc) {
            if (mc.options.getCameraType().isFirstPerson() || mc.options.getCameraType() == CameraType.THIRD_PERSON_BACK) {
                mc.options.setCameraType(CameraType.THIRD_PERSON_FRONT);
            }
        }
    }
}