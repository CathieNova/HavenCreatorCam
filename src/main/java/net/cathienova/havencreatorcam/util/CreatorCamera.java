package net.cathienova.havencreatorcam.util;

import net.cathienova.havencreatorcam.HavenCreatorCam;
import net.cathienova.havencreatorcam.config.CommonConfig;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.InputEvent;

public class CreatorCamera
{
    private static boolean frontCamKeyDown = false;
    private static boolean backCamKeyDown = false;

    @Mod.EventBusSubscriber(modid = HavenCreatorCam.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
    public static class ClientForgeEvents {

        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event)
        {
            Minecraft mc = Minecraft.getInstance();

            if (mc.player == null) return;

            boolean newFrontCamKeyDown = ModKeybindings.INSTANCE.frontcam.isDown();
            boolean newBackCamKeyDown = ModKeybindings.INSTANCE.backcam.isDown();

            if (newFrontCamKeyDown && !frontCamKeyDown)
            {
                FrontCamView(mc);
                if (CommonConfig.CONFIG.hideGUI.get())
                    mc.options.hideGui = true;
            }
            if (!newFrontCamKeyDown && frontCamKeyDown)
            {
                mc.options.setCameraType(CameraType.FIRST_PERSON);
                if (CommonConfig.CONFIG.hideGUI.get())
                    mc.options.hideGui = false;
            }

            if (ModKeybindings.INSTANCE.backcam.isDown() && !backCamKeyDown)
            {
                BackCamView(mc);
                if (CommonConfig.CONFIG.hideGUI.get())
                    mc.options.hideGui = true;
            }
            if (!ModKeybindings.INSTANCE.backcam.isDown() && backCamKeyDown)
            {
                mc.options.setCameraType(CameraType.FIRST_PERSON);
                if (CommonConfig.CONFIG.hideGUI.get())
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