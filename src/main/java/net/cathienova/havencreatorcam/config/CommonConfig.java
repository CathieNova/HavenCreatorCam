package net.cathienova.havencreatorcam.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class CommonConfig
{
    public final ModConfigSpec.IntValue originalCamFOV;
    public final ModConfigSpec.IntValue creatorCamFOV;
    public final ModConfigSpec.BooleanValue hideGUI;
    public final ModConfigSpec.BooleanValue enableToggleView;


    public CommonConfig(ModConfigSpec.Builder builder)
    {
        creatorCamFOV = builder.comment("The FOV of the creator camera").defineInRange("creatorCamFOV", 30, 30, 110);
        originalCamFOV = builder.comment("The FOV you normally use. (defaulted to 70)").defineInRange("originalFOV", 70, 30, 110);
        hideGUI = builder.comment("Hide the GUI when using the creator camera?").define("hideGUI", true);
        enableToggleView = builder.comment("If enabled it will toggle the view when you press the keybind, otherwise it's hold to view").define("enableToggleView", false);
    }
}