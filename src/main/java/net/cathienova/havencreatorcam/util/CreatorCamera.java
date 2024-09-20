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
    private static boolean frontCamKeyDown = false;
    private static boolean backCamKeyDown = false;

    @Mod.EventBusSubscriber(modid = HavenCreatorCam.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {

        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event)
        {
            Minecraft mc = Minecraft.getInstance();

            if (mc.player == null) return;

            boolean newFrontCamKeyDown = ModKeybindings.INSTANCE.frontcam.isDown();
            boolean newBackCamKeyDown = ModKeybindings.INSTANCE.backcam.isDown();

            // Add the front camera keybind
            if (newFrontCamKeyDown && !frontCamKeyDown)
            {
                FrontCamView(mc);
                if (HavenConfig.hideGUI)
                    mc.options.hideGui = true;
            }
            if (!newFrontCamKeyDown && frontCamKeyDown)
            {
                mc.options.setCameraType(CameraType.FIRST_PERSON);
                if (HavenConfig.hideGUI)
                    mc.options.hideGui = false;
            }

            // Add the back camera keybind
            if (newBackCamKeyDown && !backCamKeyDown)
            {
                BackCamView(mc);
                if (HavenConfig.hideGUI)
                    mc.options.hideGui = true;
            }
            if (!newBackCamKeyDown && backCamKeyDown)
            {
                mc.options.setCameraType(CameraType.FIRST_PERSON);
                if (HavenConfig.hideGUI)
                    mc.options.hideGui = false;
            }

            // Update the key states for the next iteration
            frontCamKeyDown = newFrontCamKeyDown;
            backCamKeyDown = newBackCamKeyDown;
        }

        private static void FrontCamView(Minecraft mc) {
            if (mc.options.getCameraType().isFirstPerson() || mc.options.getCameraType() == CameraType.THIRD_PERSON_BACK) {
                mc.options.setCameraType(CameraType.THIRD_PERSON_FRONT);
            }
        }

        private static void BackCamView(Minecraft mc) {
            if (mc.options.getCameraType().isFirstPerson() || mc.options.getCameraType() == CameraType.THIRD_PERSON_FRONT) {
                mc.options.setCameraType(CameraType.THIRD_PERSON_BACK);
            }
        }
    }
}