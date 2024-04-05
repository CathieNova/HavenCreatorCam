package net.cathienova.havencreatorcam.config;

import net.cathienova.havencreatorcam.HavenCreatorCam;
import net.minecraftforge.fml.config.ModConfig;

public class HavenConfig
{
    public static int creatorCamFOV;
    public static int originalFOV;
    public static boolean hideGUI;

    public static void bake(ModConfig config)
    {
        creatorCamFOV = HavenCreatorCam.c_config.creatorCamFOV.get();
        originalFOV = HavenCreatorCam.c_config.originalCamFOV.get();
        hideGUI = HavenCreatorCam.c_config.hideGUI.get();
    }
}