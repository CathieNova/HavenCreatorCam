package net.cathienova.havencreatorcam;

import com.mojang.blaze3d.platform.InputConstants;
import net.cathienova.havencreatorcam.config.HavenConfig;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.CameraType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.settings.KeyConflictContext;

@EventBusSubscriber(modid = HavenCreatorCam.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class HavenCreatorClient {
    public static final KeyMapping CREATOR_CAM_KEY_FRONT = new KeyMapping(
            "key.havencreatorcam.creatorcam_front",
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            InputConstants.KEY_Z,
            "key.categories.havencreatorcam"
    );

    public static final KeyMapping CREATOR_CAM_KEY_BACK = new KeyMapping(
            "key.havencreatorcam.creatorcam_back",
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            InputConstants.KEY_X,
            "key.categories.havencreatorcam"
    );

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(CREATOR_CAM_KEY_FRONT);
        event.register(CREATOR_CAM_KEY_BACK);
    }

    @EventBusSubscriber(modid = HavenCreatorCam.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.GAME)
    public static class GameEventHandler {
        private static boolean creatorCamFrontActive = false;
        private static boolean creatorCamBackActive = false;

        @SubscribeEvent
        public static void onClientTick(ClientTickEvent.Post event) {
            Minecraft mc = Minecraft.getInstance();
            if (mc.player == null) return;

            if (HavenConfig.enableToggleView) {
                handleToggleMode(mc, CREATOR_CAM_KEY_FRONT, CameraType.THIRD_PERSON_FRONT, () -> creatorCamFrontActive = !creatorCamFrontActive);
                handleToggleMode(mc, CREATOR_CAM_KEY_BACK, CameraType.THIRD_PERSON_BACK, () -> creatorCamBackActive = !creatorCamBackActive);
            } else {
                handleHoldMode(mc, CREATOR_CAM_KEY_FRONT, CameraType.THIRD_PERSON_FRONT);
                handleHoldMode(mc, CREATOR_CAM_KEY_BACK, CameraType.THIRD_PERSON_BACK);
            }
        }

        private static void handleToggleMode(Minecraft mc, KeyMapping key, CameraType cameraType, Runnable toggleAction) {
            if (key.consumeClick()) {
                if (mc.options.getCameraType() == cameraType) {
                    resetToFirstPerson(mc);
                } else {
                    toggleAction.run();
                    switchToCamera(mc, cameraType);
                }
            }
        }

        private static void handleHoldMode(Minecraft mc, KeyMapping key, CameraType cameraType) {
            if (key.isDown()) {
                switchToCamera(mc, cameraType);
            } else if (mc.options.getCameraType() == cameraType) {
                resetToFirstPerson(mc);
            }
        }

        private static void switchToCamera(Minecraft mc, CameraType cameraType) {
            mc.options.setCameraType(cameraType);
            mc.options.hideGui = HavenConfig.hideGUI;
        }

        private static void resetToFirstPerson(Minecraft mc) {
            mc.options.setCameraType(CameraType.FIRST_PERSON);
            mc.options.hideGui = false;
        }
    }
}
